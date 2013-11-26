
package Model.Persistence.JDBC;

import Model.Persistence.DAOs.TurmaDAO;
import Model.Persistence.DAOs.HistoricoDAO;
import Model.Persistence.DAOs.DisciplinaDAO;
import Model.Logic.Aluno;
import Model.Logic.Disciplina;
import Model.Logic.HistoricoEscolar;
import Model.Logic.HistoricoEscolarElemento;
import Model.Logic.Turma;
import Model.Persistence.FactoryDAO;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Zanella
 */
public class JDBCHistoricoDAO extends JDBCDAO implements HistoricoDAO{
    
    public JDBCHistoricoDAO(){
        super();
    }
    
    @Override
    public HistoricoEscolar getHistorico(Aluno aluno) {
        HistoricoEscolar novoHistorico = new HistoricoEscolar();
        try {
            FactoryDAO novaFactory = new FactoryDAO();
            TurmaDAO novaTurmaDAO = novaFactory.criarTurmaDAO();
           
            String query = "SELECT * FROM turma_cursada WHERE cpfAluno = '"+aluno.getCpf()+"'";
            st = con.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
                Turma novaTurma = novaTurmaDAO.getTurma(rs.getInt("idTurma"));
                if(rs.getString("conceito") == null) continue;
                novoHistorico.addElemento(novaTurma, rs.getString("conceito").charAt(0));
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCHistoricoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return novoHistorico;
    }

    @Override
    public boolean salvarElemento(HistoricoEscolarElemento novoElemento) {
        return false;
    }

    @Override
    public Set<Disciplina> getDisciplinasCursadas(Aluno aluno) {
         Set<Disciplina> disciplinasCursadas = new HashSet<Disciplina>();
        try {
            FactoryDAO novaFactory = new FactoryDAO();
            TurmaDAO novaTurmaDAO = novaFactory.criarTurmaDAO();
            DisciplinaDAO novaDisciplinaDAO = novaFactory.criarDisciplinaDAO();
               
            String query = "SELECT idTurma FROM turma_cursada WHERE cpfAluno = '"+aluno.getCpf()+"' AND conceito!='D' AND conceito!='FF'";
            st = con.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
                Turma umaTurma = novaTurmaDAO.getTurma(rs.getInt("idTurma"));
                Disciplina novaDisciplina = novaDisciplinaDAO.getDisciplina(umaTurma.getCodigoDisciplina());
                disciplinasCursadas.add(novaDisciplina);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCHistoricoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return disciplinasCursadas;
    }

    @Override
    public Set<Disciplina> getDisciplinasNaoCursadas(Aluno aluno) {
        Set<Disciplina> naoCursadas = new HashSet<Disciplina>();
        try {
            String query = "SELECT disciplina.codigo FROM disciplina WHERE "
                    + "disciplina.codigo NOT IN (SELECT disciplina.codigo FROM "
                    + "disciplina, turma,turma_cursada WHERE turma_cursada.idTurma "
                    + "= turma.id AND turma.codigoDisciplina = disciplina.codigo AND"
                    + " turma_cursada.cpfAluno = '"+aluno.getCpf()+"')";
            FactoryDAO novaFactory = new FactoryDAO();
            DisciplinaDAO disciplinaDAO = novaFactory.criarDisciplinaDAO();
            st = con.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
                Disciplina novaDisciplina = disciplinaDAO.getDisciplina(
                        rs.getString("disciplina.codigo"));
                naoCursadas.add(novaDisciplina);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCHistoricoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return naoCursadas;
    }
    
    
}

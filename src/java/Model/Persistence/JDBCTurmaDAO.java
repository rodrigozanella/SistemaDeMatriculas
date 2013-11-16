
package Model.Persistence;

import Model.Logic.Turma;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCTurmaDAO extends JDBCDAO implements TurmaDAO{
    
    public JDBCTurmaDAO(){
        super();
    }
    
    @Override
    public Turma getTurma(int id) {
        Turma novaTurma = null;
        try {
            String query = "SELECT * FROM turma WHERE id = "+id;
            st = con.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
                novaTurma = new Turma(rs.getInt("id"), rs.getString("codigoDisciplina"), 
                        rs.getString("horario"), rs.getString("semestre"), 
                        rs.getInt("numvagas"), rs.getString("cpfProfessor"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCTurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return novaTurma;
    }

    @Override
    public boolean adicionaTurma(Turma turma) {
        return false;
    }

    @Override
    public boolean excluirTurma(Turma turma) {
        return false;
    }

    @Override
    public Set<Turma> getTurmasSemestre(String codDisciplina, String semestre) {
        Set<Turma> turmasSemestre = new HashSet<Turma>();
        try {
            st = con.createStatement();
            String query = "SELECT * FROM turma WHERE codigoDisciplina = '"+codDisciplina+"' AND semestre = '"+semestre+"'";
            rs = st.executeQuery(query);
            while(rs.next()){
                Turma novaTurma = new Turma(rs.getInt("id"), rs.getString("codigoDisciplina"), 
                        rs.getString("horario"), rs.getString("semestre"), 
                        rs.getInt("numvagas"), rs.getString("cpfProfessor"));
                turmasSemestre.add(novaTurma);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCTurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return turmasSemestre;
    }
    
}

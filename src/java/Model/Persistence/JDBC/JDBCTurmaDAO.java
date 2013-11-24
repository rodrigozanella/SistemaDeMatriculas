
package Model.Persistence.JDBC;

import Model.Persistence.DAOs.TurmaDAO;
import Model.Logic.Turma;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCTurmaDAO extends JDBCDAO implements TurmaDAO{
    
    public JDBCTurmaDAO(){
        super();
    }
    
    /**
     * getTurma
     * Dado um id de turma, obtém o seu registro.
     */
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

    /**
     * adicionaTurma
     * Adiciona uma turma no BD. (assum que os seus dados estão corretos)
     */
    @Override
    public boolean adicionaTurma(Turma turma) {
        try{
            //insere a disciplina na tabela de turmas
            PreparedStatement statement = con.prepareStatement("INSERT INTO turma "
                                        + "(codigo, codigoDisciplina, horario, semestre, numvagas, cpfProfessor)"
                                        + " VALUES (?, ?, ?, ?, ?, ?)");

            statement.setString(1, String.valueOf((char)turma.getCodigo()));
            statement.setString(2, turma.getCodigoDisciplina());
            statement.setString(3, turma.getHorario());
            statement.setString(4, turma.getSemestre());
            statement.setInt(5, turma.getNumeroDeVagas());
            statement.setString(6, turma.getCpfProfessor());
            statement.execute();
            
        } catch(SQLException ex){
            Logger.getLogger(JDBCTurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public boolean excluirTurma(Turma turma) {
        return false;
    }

    /**
     * getTurmasSemestre
     * Obtém um conjunto de turmas de um determinado semenstre.
     */
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

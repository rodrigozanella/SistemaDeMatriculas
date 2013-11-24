
package Model.Persistence.JDBC;

import Model.Persistence.DAOs.ProfessorDAO;
import Model.Persistence.DAOs.TurmaDAO;
import Model.Logic.Professor;
import Model.Logic.Turma;
import Model.Logic.Usuario;
import Model.Persistence.FactoryDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCProfessorDAO extends JDBCDAO implements ProfessorDAO {
    
    @Override
    public List<Turma> getTurmas(String cpfProfessor) {
        List<Turma> turmas = new ArrayList<Turma>();
        try {
            String query =  "SELECT id FROM turma WHERE cpfProfessor = '"+cpfProfessor+"'";
            st = con.createStatement();
            rs = st.executeQuery(query);
            FactoryDAO factory = new FactoryDAO();
            TurmaDAO turmaDAO = factory.criarTurmaDAO();
            while(rs.next()){
                Turma novaTurma = turmaDAO.getTurma(rs.getInt("id"));
                turmas.add(novaTurma);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return turmas;
    }

    @Override
    public Professor getProfessor(String usuario, String password) {
        try {
            String query ="SELECT * FROM professor WHERE nomeUsuario='"+usuario+"'";
            st = con.createStatement();
            rs = st.executeQuery(query);
            if(rs.next()){
                return new Professor(rs.getString("nome"), rs.getString("cpf"), usuario, 
                        password, rs.getString("email"), null, 
                        rs.getString("areaInteresse"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}

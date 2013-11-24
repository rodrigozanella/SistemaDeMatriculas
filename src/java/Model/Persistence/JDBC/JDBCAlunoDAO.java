
package Model.Persistence.JDBC;

import Model.Logic.Aluno;
import Model.Persistence.DAOs.AlunoDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCAlunoDAO extends JDBCDAO implements AlunoDAO{

    @Override
    public Aluno getAluno(String usuario, String password) {
        try {
            String query ="SELECT * FROM aluno WHERE nomeUsuario='" + usuario + "'";
            st = con.createStatement();
            rs = st.executeQuery(query);
            if(rs.next()){
                return new Aluno(rs.getString("nome"),  rs.getString("cpf"),  
                        usuario, password, rs.getString("email"), null, 
                        rs.getString("metodoIngresso"), rs.getInt("pontuacaoVestibular"), 
                        rs.getString("semestreIngresso"), rs.getInt("matricula"));
           }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCAlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}

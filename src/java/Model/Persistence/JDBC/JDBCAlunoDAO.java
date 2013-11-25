
package Model.Persistence.JDBC;

import Model.Logic.Aluno;
import Model.Persistence.DAOs.AlunoDAO;
import java.sql.PreparedStatement;
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

    @Override
    public boolean adicionarAluno(Aluno aluno) {
        try {
            PreparedStatement statement;
            statement = con.prepareStatement("INSERT INTO aluno "
                    + "(cpf, nome, nomeUsuario, email, dataNascimento, matricula, "
                    + "semestreIngresso, metodoIngresso, pontuacaoVestibular, situacao, "
                    + "pontuacao) VALUES (?, ?, ?, ?, NULL, ?, ?, ?, ?, NULL, 100)");
            statement.setString(1, aluno.getCpf()); 
            statement.setString(2, aluno.getNome());
            statement.setString(3, aluno.getNomeDeUsuario());
            statement.setString(4, aluno.getEmail());
            statement.setInt(5, aluno.getNumeroDeMatricula()); 
            statement.setString(6, aluno.getSemestreDeIngresso());
            statement.setString(7, aluno.getTipoDeIngresso()); 
            statement.setInt(8, aluno.getPontuacaoVestibular());
            statement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(JDBCAlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}

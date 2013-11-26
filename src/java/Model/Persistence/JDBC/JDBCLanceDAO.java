
package Model.Persistence.JDBC;

import Model.Logic.Lance;
import Model.Persistence.DAOs.LanceDAO;
import Model.Validation.Validador;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCLanceDAO extends JDBCDAO implements LanceDAO{

    /**
     * adicionaLance
     * Adiciona um lance no BD após verificar seus atributos.
     */
    @Override
    public boolean adicionaLance(Lance lance) {
        try{
            
            //verifica se o lance pode ser inserido no BD
            Validador validador = new Validador();
            if(!validador.validaLance(lance)) return false;
            
            //insere o lance na tabela de lances
            PreparedStatement statement = con.prepareStatement("INSERT INTO lance "
                                        + "(idTurma, cpfAluno, valor, atendida)"
                                        + " VALUES (?, ?, ?, NULL)");

            statement.setInt(1, lance.getIdTurma());
            statement.setString(2, lance.getCpfAluno());
            statement.setInt(3, lance.getValor());
            statement.execute();
            
        } catch(SQLException ex){
            Logger.getLogger(JDBCTurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
}

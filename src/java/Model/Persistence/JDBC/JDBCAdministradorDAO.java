/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Persistence.JDBC;

import Model.Persistence.DAOs.AdministradorDAO;
import Model.Logic.Administrador;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCAdministradorDAO extends JDBCDAO implements AdministradorDAO {
    @Override
    public Administrador getAdministrador(String usuario, String password) {
        try {
            String query ="SELECT * FROM administrador WHERE nomeUsuario='"+usuario+"'";
            st = con.createStatement();
            rs = st.executeQuery(query);
            if(rs.next()){
                return new Administrador(rs.getString("nome"),  
                        rs.getString("cpf"), usuario, password, 
                        rs.getString("email"), null);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(JDBCAdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

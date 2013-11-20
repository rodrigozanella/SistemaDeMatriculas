
package Model.Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCDAO {
    protected Connection con;
    protected Statement st;
    protected ResultSet rs;
    
    public JDBCDAO(){
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/es_pratica3","root","aaaa");
            st = null;
            rs = null;
        } catch (SQLException ex) {
            Logger.getLogger(JDBCUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected void finalize(){
         try {
            if (rs != null) {
                rs.close();
	    }
            if (st != null) {
                st.close();
	    }
            if (con != null) {
                con.close();
	    }
	} catch (SQLException ex) {
	    
        }
    }
}

package Model.Persistence.JDBC;

import Model.Persistence.DAOs.SistemaDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class JDBCSistemaDAO extends JDBCDAO implements SistemaDAO{
    
    
    public JDBCSistemaDAO(){
        super(); 
    }
    
    @Override
    public String getEstado(){
        String result = null;
        try {
            String query = "SELECT estado FROM sistema";
            st = con.createStatement();
            rs = st.executeQuery(query);
            if(rs.next()){
                result = rs.getString(1);
            }
        } catch (Exception ex) {
            
        }
        return result;
    }
    
    @Override
    public String getSemestre(){
        String result = null;
        try {
            String query = "SELECT semestre FROM sistema";
            st = con.createStatement();
            rs = st.executeQuery(query);
            if(rs.next()){
                result = rs.getString(1);
            }
        } catch (Exception ex) {
            
        }
        return result;
    }
    
    @Override
    public boolean setEstado(String novoEstado){
        try{
            //atualiza lance
            String update = "UPDATE sistema "
                           + "SET estado = '" + novoEstado + "'";
            st = con.createStatement();
            st.executeUpdate(update);
  
        } catch(SQLException ex){
            Logger.getLogger(JDBCTurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
    @Override
    public boolean setSemestre(String novoSemestre){
       try{
            //atualiza lance
            String update = "UPDATE sistema "
                           + "SET semestre = '" + novoSemestre + "'";
            st = con.createStatement();
            st.executeUpdate(update);
  
        } catch(SQLException ex){
            Logger.getLogger(JDBCTurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
}

package Model.Persistence;

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
        return false;
    }
    
    @Override
    public boolean setSemestre(String novoSemestre){
        return false;
    }
    
}

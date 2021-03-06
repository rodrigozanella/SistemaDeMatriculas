
package Model.Persistence.JDBC;

import Model.Logic.Aluno;
import Model.Logic.Lance;
import Model.Logic.Turma;
import Model.Persistence.DAOs.LanceDAO;
import Model.Validation.LanceValidador;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
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
            LanceValidador lanceValidador = new LanceValidador();
            lanceValidador.setLance(lance);

            if(lanceValidador.validaTudo()){
                return this.atualizaLance(lance);
            }
            
            //insere o lance na tabela de lances
            PreparedStatement statement = con.prepareStatement("INSERT INTO lance "
                                        + "(idTurma, cpfAluno, valor, situacao)"
                                        + " VALUES (?, ?, ?, ?)");

            statement.setInt(1, lance.getIdTurma());
            statement.setString(2, lance.getCpfAluno());
            statement.setInt(3, lance.getValor());
            statement.setString(4, lance.getSituacao());
            statement.execute();
            
        } catch(SQLException ex){
            Logger.getLogger(JDBCTurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
    /**
     * getLances
     * Obtém todos os lances realizados por um determinado aluno.
     */
    @Override
    public Set<Lance> getLances(Aluno aluno){
        Set<Lance> lances = new HashSet<Lance>();
        try{
            //obtém lista de lances
            String query = "SELECT * FROM lance "
                           + "WHERE lance.cpfAluno = '" + aluno.getCpf() + "'";
            st = con.createStatement();
            rs = st.executeQuery(query);

            while(rs.next()){
                int idTurma = rs.getInt("idTurma");
                String cpfAluno = rs.getString("cpfAluno");
                int valor = rs.getInt("valor");
                String situacao = rs.getString("situacao");

                Lance lance = new Lance(idTurma, cpfAluno, valor, situacao);
                lances.add(lance);
            }
            
        } catch(SQLException ex){
            Logger.getLogger(JDBCTurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return lances;
    }
    
    /**
     * getLances
     * Obtém todos os lances de uma determinada turma.
     */
    @Override
    public Set<Lance> getLances(Turma turma){
        Set<Lance> lances = new HashSet<Lance>();
        try{
            //obtém lista de lances
            String query = "SELECT * FROM lance "
                           + "WHERE lance.idTurma = '" + turma.getCodigoUnico() + "'";
            st = con.createStatement();
            rs = st.executeQuery(query);

            while(rs.next()){
                int idTurma = rs.getInt("idTurma");
                String cpfAluno = rs.getString("cpfAluno");
                int valor = rs.getInt("valor");
                String situacao = rs.getString("situacao");
                
                Lance lance = new Lance(idTurma, cpfAluno, valor, situacao);
                lances.add(lance);
            }
            
        } catch(SQLException ex){
            Logger.getLogger(JDBCTurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return lances;
    }
    
    /**
     * atualizaLance
     * Atualiza um lance. Ocorre se um usuário já possuia um lance para uma determinada turma.
     */
    @Override
    public boolean atualizaLance(Lance lance){
        try{
            //atualiza lance
            String update = "UPDATE lance "
                           + "SET valor = '" + lance.getValor() + "', situacao = '" + lance.getSituacao() + "'"
                           + "WHERE cpfAluno = '" + lance.getCpfAluno() + "'"
                           + "AND idTurma = '" + lance.getIdTurma() + "'";
            st = con.createStatement();
            st.executeUpdate(update);
  
        } catch(SQLException ex){
            Logger.getLogger(JDBCTurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
}

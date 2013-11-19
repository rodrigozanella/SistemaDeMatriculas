
package Model.Persistence;

import Model.Logic.Administrador;
import Model.Logic.Aluno;
import Model.Logic.Professor;
import Model.Logic.Usuario;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCUsuarioDAO extends JDBCDAO implements UsuarioDAO {
    
    public JDBCUsuarioDAO(){
      super();
    }
    
    /**
     * getUsuario
     * Dados um identificador do usuário e uma senha, é retornado um tipo
     * usuário que contém as informações do usuário que são representados pelo
     * identificador e a senha.
     * @param name Identificador do usuário
     * @param password Senha do usuário
     * @return O Usuário representado pelo identificador e pela senha
     */
    @Override
    public Usuario getUsuario(String name, String password){ 
        try {
            
            /*
             * Pesquisa na tabela usuário
             */
            
            String tipo = null;
            String query = "SELECT tipo FROM usuario WHERE nomeUsuario='"+name+"' AND senha='"+password+"'";            
            st = con.createStatement();
            
            rs = st.executeQuery(query);
            while(rs.next()){
                tipo = rs.getString(1);
            }
            
            /*
             * Pesquisa na tabela específica do usuário
             */
            
            if(tipo.equalsIgnoreCase("aluno")){
                query ="SELECT * FROM aluno WHERE nomeUsuario='"+name+"'";
                st = con.createStatement();
                rs = st.executeQuery(query);
                if(rs.next()){
                    Aluno novoAluno = new Aluno(rs.getString("nome"), 
                            rs.getString("cpf"), 
                            rs.getString("nomeUsuario"), 
                            password);
                    return novoAluno;
                }
            }
            if(tipo.equalsIgnoreCase("administrador")){
                query ="SELECT * FROM administrador WHERE nomeUsuario='"+name+"'";
                st = con.createStatement();
                rs = st.executeQuery(query);
                if(rs.next()){
                    return new Administrador(rs.getString("nome"), 
                            rs.getString("cpf"), 
                            rs.getString("nomeUsuario"), 
                            password);
                }
            }
            if(tipo.equalsIgnoreCase("professor")){
                query ="SELECT * FROM professor WHERE nomeUsuario='"+name+"'";
                st = con.createStatement();
                rs = st.executeQuery(query);
                if(rs.next()){
                    return new Professor(rs.getString("nome"), 
                            rs.getString("cpf"), 
                            rs.getString("nomeUsuario"), 
                            password,
                            rs.getString("areaInteresse"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e){
            return null;
        }
        return null;
    }
    
    @Override
    public boolean excluirUsuario(Usuario user){
        return true;
    }
    
    @Override
    public boolean adicionarUsuario(Usuario user){
        return true;
    }

    @Override
    public String getNomeUsuario(String cpf) {
        String nome = "";
        try {
            String query = "(SELECT aluno.cpf, aluno.nome FROM aluno WHERE "
                    + "cpf = '"+cpf+"') UNION (SELECT professor.cpf, professor.nome "
                    + "FROM professor WHERE cpf = '"+cpf+"') UNION"
                    + "(SELECT administrador.cpf, administrador.nome FROM administrador "
                    + "WHERE cpf = '"+cpf+"')";
            st = con.createStatement();
            rs = st.executeQuery(query);
            
            if(rs.next()){
                nome=rs.getString("nome");
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}

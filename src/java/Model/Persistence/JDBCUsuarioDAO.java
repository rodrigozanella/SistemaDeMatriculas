
package Model.Persistence;

import Model.Logic.Administrador;
import Model.Logic.Aluno;
import Model.Logic.Professor;
import Model.Logic.Usuario;
import java.sql.PreparedStatement;
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
                tipo = rs.getString("tipo");
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
    /**
     * adicionarUsuario
     * Dado um usuário de qualquer tipo, adiciona ele no BD.
     * @param user Usuario a ser inserido no BD (deve estar validado)
     * @return Valor booleano representando o sucesso ou não da operação
     */
    public boolean adicionarUsuario(Usuario user){
        try {
            PreparedStatement statement;
                    
            //obtém o tipo do usuário
            String tipoUsuario = user.getRole();
            
            //é necessário inserir uma entrada na tabela de usuários
            statement = con.prepareStatement("INSERT INTO usuario "
                    + "(nomeUsuario, senha, tipo) VALUES (?, ?, ?)");
            statement.setString(1, user.getNomeDeUsuario());
            statement.setString(2, user.getSenha());
            statement.setString(3, user.getRole());
            statement.execute();
            
            //e também na tabela especifica do usuario
            if(tipoUsuario.equalsIgnoreCase("aluno")){
                Aluno aluno = (Aluno)user;
                
                statement = con.prepareStatement("INSERT INTO aluno "
                        + "(cpf, nome, nomeUsuario, email, dataNascimento, matricula, "
                        + "semestreIngresso, metodoIngresso, pontuacaoVestibular, situacao, "
                        + "pontuacao) VALUES ('?, ?, ?, ?, NULL, ?, ?, ?, ?, NULL, 100)");
                statement.setString(1, aluno.getCpf()); 
                statement.setString(2, aluno.getNome());
                statement.setString(3, aluno.getNomeDeUsuario());
                statement.setString(4, aluno.getEmail());
                statement.setString(6, aluno.getNumeroDeMatricula()+"");
                statement.setString(7, aluno.getSemestreDeIngresso());
                statement.setString(8, aluno.getTipoDeIngresso().toString());
                statement.setString(9, aluno.getPontuacaoVestibular()+"");
                statement.execute();
            }
            else if(tipoUsuario.equalsIgnoreCase("professor")){
                Professor professor = (Professor)user;
                
                statement = con.prepareStatement("INSERT INTO professor "
                        + "(cpf, nome, email, nomeUsuario, dataNascimento, areaInteresse)"
                        + " VALUES (?, ?, ?, ?, NULL, ?)");
                statement.setString(1, professor.getCpf()); 
                statement.setString(2, professor.getNome());
                statement.setString(3, professor.getEmail());
                statement.setString(4, professor.getNomeDeUsuario());
                statement.setString(5, professor.getAreaDeInteresse());
                statement.execute();
            }        
            else if(tipoUsuario.equalsIgnoreCase("administrador")){
                Administrador administrador = (Administrador)user;
                
                statement = con.prepareStatement("INSERT INTO administrador "
                        + "(cpf, nome, email, nomeUsuario, dataNascimento)"
                        + " VALUES (?, ?, ?, ?, NULL)");
                statement.setString(1, administrador.getCpf()); 
                statement.setString(2, administrador.getNome());
                statement.setString(3, administrador.getEmail());
                statement.setString(4, administrador.getNomeDeUsuario());
                
                statement.execute();
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(JDBCUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
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

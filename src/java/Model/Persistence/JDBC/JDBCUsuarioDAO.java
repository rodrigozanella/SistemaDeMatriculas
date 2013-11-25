
package Model.Persistence.JDBC;

import Model.Persistence.DAOs.ProfessorDAO;
import Model.Persistence.DAOs.UsuarioDAO;
import Model.Persistence.DAOs.AdministradorDAO;
import Model.Logic.Administrador;
import Model.Logic.Aluno;
import Model.Logic.Professor;
import Model.Logic.Usuario;
import Model.Persistence.DAOs.AlunoDAO;
import Model.Persistence.FactoryDAO;
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
        Usuario novoUser = null;
        try {
            String query = "SELECT tipo FROM usuario WHERE nomeUsuario='"+name+"' AND senha='"+password+"'";            
            st = con.createStatement();
            rs = st.executeQuery(query);
            
            String tipo = null;
            while(rs.next()){
                tipo = rs.getString("tipo");
            }
          
            FactoryDAO factory = new FactoryDAO();
            
            if(tipo.equalsIgnoreCase("aluno")){
                AlunoDAO alunoDAO = factory.criarAlunoDAO();
                novoUser = alunoDAO.getAluno(name, password);
            }
            if(tipo.equalsIgnoreCase("administrador")){
                AdministradorDAO administradorDAO = factory.criarAdministradorDAO();
                novoUser = administradorDAO.getAdministrador(name, password);
            }
            if(tipo.equalsIgnoreCase("professor")){
                ProfessorDAO  professorDAO = factory.criarProfessorDAO();
                novoUser = professorDAO.getProfessor(name, password);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e){
            return null;
        }
        return novoUser;
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
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(JDBCUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    
    /**
     * getUsuario
     * Dado um CPF, obtém o usuário que possui o cpf, caso contrário, retorna null.
     */
    @Override
    public Usuario getUsuario(String cpf) {
        try {
            //procura pelo cpf na tabela de alunos
            String query = "SELECT * FROM aluno, usuario WHERE cpf = '" + cpf + "' AND aluno.nomeUsuario = usuario.nomeUsuario";
            st = con.createStatement();
            rs = st.executeQuery(query);
            
            if(rs.next()){
                return new Aluno(rs.getString("nome"), cpf, rs.getString("aluno.nomeUsuario"), rs.getString("senha"), rs.getString("email"), null, rs.getString("metodoIngresso"), rs.getInt("pontuacaoVestibular"), rs.getString("semestreIngresso"), rs.getInt("matricula"));
            }
            
            //procura pelo cpf na tabela de professores
            query = "SELECT * FROM professor, usuario WHERE cpf = '" + cpf + "' AND professor.nomeUsuario = usuario.nomeUsuario";
            st = con.createStatement();
            rs = st.executeQuery(query);
            
            if(rs.next()){
                return new Professor(rs.getString("nome"), cpf, rs.getString("professor.nomeUsuario"), rs.getString("senha"), rs.getString("email"), null, rs.getString("areaInteresse"));
            }
            
            //procura pelo cpf na tabela de professores
            query = "SELECT * FROM administrador, usuario WHERE cpf = '" + cpf + "' AND administrador.nomeUsuario = usuario.nomeUsuario";
            st = con.createStatement();
            rs = st.executeQuery(query);
            
            if(rs.next()){
                return new Administrador(rs.getString("nome"), cpf, rs.getString("administrador.nomeUsuario"), rs.getString("senha"), rs.getString("email"), null);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(JDBCUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

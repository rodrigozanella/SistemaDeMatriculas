
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
import java.util.ArrayList;
import java.util.Date;
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
            
            //e também na tabela especifica do usuario
            if(tipoUsuario.equalsIgnoreCase("aluno")){
                Aluno aluno = (Aluno)user;
                
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

    /**
     * getProfessores
     * Obtém uma lista de todos os professores cadastrados no sistema.
     */
    @Override
    public ArrayList<Professor> getProfessores(){
        ArrayList<Professor> professores = new ArrayList<Professor>();
        try{
            //obtém todos os registros de professores
            String query = "SELECT * FROM professor, usuario WHERE usuario.nomeUsuario = professor.nomeUsuario ORDER BY nome";
            st = con.createStatement();
            rs = st.executeQuery(query);

            //cria as instâncias de professores e as coloca no array
            while(rs.next()){
                String cpf = rs.getString("cpf");
                String nome = rs.getString("nome");
                String nomeUsuario = rs.getString("nomeUsuario");
                String senha = rs.getString("senha");
                String email = rs.getString("email");
                //Date nascimento =  rs.getDate("dataNascimento");
                String areaDeInteresse = rs.getString("areaInteresse");
                
                Professor professor = new Professor(nome, cpf, nomeUsuario, senha, email, null, areaDeInteresse);
                professores.add(professor);
            }
        } catch(SQLException ex){
            Logger.getLogger(JDBCUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return professores;
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

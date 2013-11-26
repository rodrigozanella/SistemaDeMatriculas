
package Model.Persistence.JDBC;

import Model.Logic.Aluno;
import Model.Persistence.DAOs.AlunoDAO;
import Model.Persistence.DAOs.UsuarioDAO;
import Model.Persistence.FactoryDAO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCAlunoDAO extends JDBCDAO implements AlunoDAO{

    @Override
    public Aluno getAluno(String usuario, String password) {
        try {
            String query ="SELECT * FROM aluno WHERE nomeUsuario='" + usuario + "'";
            st = con.createStatement();
            rs = st.executeQuery(query);
            if(rs.next()){
                return new Aluno(rs.getString("nome"),  rs.getString("cpf"),  
                        usuario, password, rs.getString("email"), null, 
                        rs.getString("metodoIngresso"), rs.getInt("pontuacaoVestibular"), 
                        rs.getString("semestreIngresso"), rs.getInt("matricula"));
           }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCAlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean adicionarAluno(Aluno aluno) {
        try {
            PreparedStatement statement;
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
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(JDBCAlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Set<Aluno> getAlunosIrregulares() {
        Set<Aluno> alunos = new HashSet<Aluno>();
        
        try {
            String query = "SELECT cpfAluno,COUNT(conceito) as numconc FROM turma_cursada WHERE conceito = 'FF' GROUP BY cpfAluno";
            st = con.createStatement();
            rs = st.executeQuery(query);
            FactoryDAO factory = new FactoryDAO();
            UsuarioDAO usuarioDAO = factory.criarUsuarioDAO();
 
            while(rs.next()){
                if(rs.getInt("nunconc")>=10){
                    Aluno aluno = (Aluno) usuarioDAO.getUsuario(rs.getString("cpfAluno"));
                    alunos.add(aluno);
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(JDBCAlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alunos;
    }

    @Override
    public boolean expulsarAluno(Aluno aluno) {
        try {
            PreparedStatement statement;
            statement = con.prepareStatement("UPDATE aluno SET situacao = 'ExpulsoFF' WHERE cpf = '"+aluno.getCpf()+"'");
            return statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCAlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean situacao(Aluno aluno) {
        try {
            String query = "SELECT * FROM aluno WHERE (situacao = 'ExpulsoFF' OR situacao = 'Expulso') AND cpf = '"+aluno.getCpf()+"'";
            st = con.createStatement();
            rs = st.executeQuery(query);
            if(rs.next()){
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCAlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public Set<Aluno> getAlunos() {
        Set<Aluno> alunos = new HashSet<Aluno>();
        try {
            FactoryDAO factory = new FactoryDAO();
            UsuarioDAO usuarioDAO = factory.criarUsuarioDAO();
            String query = "SELECT cpf FROM aluno";
            st = con.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
                Aluno aluno = (Aluno) usuarioDAO.getUsuario(rs.getString("cpf"));
                alunos.add(aluno);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCAlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alunos;
    }
    
}

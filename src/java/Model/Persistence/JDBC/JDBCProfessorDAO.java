
package Model.Persistence.JDBC;

import Model.Persistence.DAOs.ProfessorDAO;
import Model.Persistence.DAOs.TurmaDAO;
import Model.Logic.Professor;
import Model.Logic.Turma;
import Model.Persistence.FactoryDAO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCProfessorDAO extends JDBCDAO implements ProfessorDAO {
    
    @Override
    public List<Turma> getTurmas(String cpfProfessor) {
        List<Turma> turmas = new ArrayList<Turma>();
        try {
            String query =  "SELECT id FROM turma WHERE cpfProfessor = '"+cpfProfessor+"'";
            st = con.createStatement();
            rs = st.executeQuery(query);
            FactoryDAO factory = new FactoryDAO();
            TurmaDAO turmaDAO = factory.criarTurmaDAO();
            while(rs.next()){
                Turma novaTurma = turmaDAO.getTurma(rs.getInt("id"));
                turmas.add(novaTurma);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return turmas;
    }

    @Override
    public Professor getProfessor(String usuario, String password) {
        try {
            String query ="SELECT * FROM professor WHERE nomeUsuario='"+usuario+"'";
            st = con.createStatement();
            rs = st.executeQuery(query);
            if(rs.next()){
                return new Professor(rs.getString("nome"), rs.getString("cpf"), usuario, 
                        password, rs.getString("email"), null, 
                        rs.getString("areaInteresse"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean adicionarProfessor(Professor professor) {
        try {
            PreparedStatement statement;
            statement = con.prepareStatement("INSERT INTO professor "
                    + "(cpf, nome, email, nomeUsuario, dataNascimento, areaInteresse)"
                    + " VALUES (?, ?, ?, ?, NULL, ?)");
            statement.setString(1, professor.getCpf()); 
            statement.setString(2, professor.getNome());
            statement.setString(3, professor.getEmail());
            statement.setString(4, professor.getNomeDeUsuario());
            statement.setString(5, professor.getAreaDeInteresse());
            statement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(JDBCProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
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
}

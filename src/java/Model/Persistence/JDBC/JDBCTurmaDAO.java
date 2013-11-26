
package Model.Persistence.JDBC;

import Model.Logic.Aluno;
import Model.Persistence.DAOs.TurmaDAO;
import Model.Logic.Turma;
import Model.Persistence.DAOs.UsuarioDAO;
import Model.Persistence.FactoryDAO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCTurmaDAO extends JDBCDAO implements TurmaDAO{
    
    public JDBCTurmaDAO(){
        super();
    }
    
    /**
     * getTurma
     * Dado um id de turma, obtém o seu registro.
     */
    @Override
    public Turma getTurma(int id) {
        Turma novaTurma = null;
        try {
            String query = "SELECT * FROM turma WHERE id = "+id;
            st = con.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
                novaTurma = new Turma((int)rs.getString("codigo").charAt(0), rs.getString("codigoDisciplina"), 
                        rs.getString("horario"), rs.getString("semestre"), 
                        rs.getInt("numvagas"), rs.getString("cpfProfessor"));
                novaTurma.setCodigoUnico(id);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCTurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return novaTurma;
    }

    /**
     * adicionaTurma
     * Adiciona uma turma no BD. (assum que os seus dados estão corretos)
     */
    @Override
    public boolean adicionaTurma(Turma turma) {
        try{
            //insere a disciplina na tabela de turmas
            PreparedStatement statement = con.prepareStatement("INSERT INTO turma "
                                        + "(codigo, codigoDisciplina, horario, semestre, numvagas, cpfProfessor)"
                                        + " VALUES (?, ?, ?, ?, ?, ?)");

            statement.setString(1, String.valueOf((char)turma.getCodigo()));
            statement.setString(2, turma.getCodigoDisciplina());
            statement.setString(3, turma.getHorario());
            statement.setString(4, turma.getSemestre());
            statement.setInt(5, turma.getNumeroDeVagas());
            statement.setString(6, turma.getCpfProfessor());
            statement.execute();
            
        } catch(SQLException ex){
            Logger.getLogger(JDBCTurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public boolean excluirTurma(Turma turma) {
        return false;
    }
    
    /**
     * getTurmasSemestre
     * Obtém um conjunto de turmas de uma disciplina de um determinado semenstre.
     */
    @Override
    public Set<Turma> getTurmasSemestre(String codDisciplina, String semestre) {
        Set<Turma> resultado = new HashSet<Turma>();

        //Obtém uma lista de turmas do semestre
        Set<Turma> turmasSemestre = this.getTurmasSemestre(semestre);
        
        //Seleciona apenas aquelas que são da disciplina desejada
        for(Turma turma : turmasSemestre){
            if(turma.getCodigoDisciplina().equalsIgnoreCase(codDisciplina)){
                resultado.add(turma);
            }
        }

        return resultado;
    }

    @Override
    public Set<Turma> getTurmasSemestre(String semestre){
        Set<Turma> turmasSemestre = new HashSet<Turma>();
        try {
            st = con.createStatement();
            String query = "SELECT * FROM turma WHERE semestre = '"+semestre+"'";
            rs = st.executeQuery(query);
            while(rs.next()){
                Turma novaTurma = new Turma((int)rs.getString("codigo").charAt(0), rs.getString("codigoDisciplina"), 
                        rs.getString("horario"), rs.getString("semestre"), 
                        rs.getInt("numvagas"), rs.getString("cpfProfessor"));
                novaTurma.setCodigoUnico(rs.getInt("id"));
                turmasSemestre.add(novaTurma);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCTurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return turmasSemestre;
    }
    
    public boolean matriculaAluno(Turma turma, Aluno aluno){
        try{
            //insere registro tabela de turma_cursada
            PreparedStatement statement = con.prepareStatement("INSERT INTO turma_cursada "
                                        + "(cpfAluno, idTurma, conceito)"
                                        + " VALUES (?, ?, NULL)");

            statement.setString(1, aluno.getCpf());
            statement.setInt(2, turma.getCodigoUnico());
            statement.execute();
            
        } catch(SQLException ex){
            Logger.getLogger(JDBCTurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public Set<Aluno> getAlunos(int id) {
        Set<Aluno> alunos = new HashSet<Aluno>();
        try {
            String query = "SELECT cpfAluno FROM turma_cursada WHERE idTurma = "+id;
             st = con.createStatement();
             rs = st.executeQuery(query);
             FactoryDAO factory = new FactoryDAO();
             UsuarioDAO usuarioDAO = factory.criarUsuarioDAO();
             while(rs.next()){
                 Aluno novoAluno = (Aluno) usuarioDAO.getUsuario(rs.getString("cpfAluno"));
                 alunos.add(novoAluno);
             }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCTurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alunos;
    }

    @Override
    public boolean existeTurmas(String semestre) {
        try {
            String query = "SELECT * FROM turma WHERE semestre = '"+semestre+"'";
            st = con.createStatement();
            rs = st.executeQuery(query);
            if(rs.next()){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCTurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}

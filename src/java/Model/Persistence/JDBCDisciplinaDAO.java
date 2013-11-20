
package Model.Persistence;

import Model.Logic.Disciplina;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCDisciplinaDAO extends JDBCDAO implements DisciplinaDAO{
    
    public JDBCDisciplinaDAO(){
        super();
    }
    
    @Override
    public Disciplina getDisciplina(String id) {
        Disciplina novaDisciplina = null;
        try {
            String query = "SELECT * FROM disciplina WHERE codigo ='"+id+"'";
            st = con.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
                boolean eletiva = rs.getInt("ehEletiva") == 1;
                novaDisciplina = new Disciplina (rs.getString("codigo"), rs.getString("nome"), eletiva, rs.getInt("numCreditos"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCDisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return novaDisciplina;
    }

    @Override
    public Set<Disciplina> getPreRequisitos(Disciplina disciplina) {
        Set<Disciplina> preRequisitos = new HashSet<Disciplina>();
        try {
            st = con.createStatement();
            String query = "SELECT codigoDisciplinaRequisito FROM pre_requisito WHERE codigoDisciplina = '"+disciplina.getCodigo()+"'";
            rs = st.executeQuery(query);
            FactoryDAO novoFactory = new FactoryDAO();
            DisciplinaDAO disciplinaDAO = novoFactory.criarDisciplinaDAO();
            
            while(rs.next()){
                Disciplina novaDisciplina = disciplinaDAO.getDisciplina(rs.getString("codigoDisciplinaRequisito"));
                preRequisitos.add(novaDisciplina);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCDisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return preRequisitos;
    }
    
    /*
     * getCodigoDisciplinas
     * Obtém todos os nomes das disciplinas cadastradas no sistema.
     */
    @Override
    public Set<String> getNomesDisciplinas(){
        try{
            String query = "(SELECT nome FROM disciplina)";
            st = con.createStatement();
            rs = st.executeQuery(query);

            Set<String> nomesDisciplinas = new HashSet<String>();
            while(rs.next()){
                nomesDisciplinas.add(rs.getString("nome"));
            }
            return nomesDisciplinas;
        } catch(SQLException ex){
            Logger.getLogger(JDBCDisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    /*
     * getCodigo
     * Obtém o código correspondente ao nome da disciplina.
     */
    @Override
    public String getCodigo(String nomeDisciplina){
        try{
            String query = "SELECT codigo FROM disciplina WHERE nome = '" + nomeDisciplina + "'";
            st = con.createStatement();
            rs = st.executeQuery(query);

            if(rs.next()){
                return rs.getString("codigo");
            }
            
        } catch(SQLException ex){
            Logger.getLogger(JDBCDisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return ""; 
        }
        return ""; 
    }
    
    /*
     * adicionarDisciplina
     * Adiciona uma nova disciplina no BD. (assume que os dados esão corretos)
     */
    @Override
    public boolean adicionarDisciplina(Disciplina disciplina){
        try{
            PreparedStatement statement = con.prepareStatement("INSERT INTO administrador "
                                        + "(codigo, nome, ehEletiva, numCreditos)"
                                        + " VALUES (?, ?, ?, ?)");
            statement.setString(1, disciplina.getCodigo()); 
            statement.setString(2, disciplina.getNome());
            if(disciplina.isEletiva()){
                statement.setString(3, "1");
            }else{
                statement.setString(3, "0");
            }
            statement.setString(4, disciplina.getNumeroDeCreditos()+"");
            statement.execute();
        } catch(SQLException ex){
            Logger.getLogger(JDBCDisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false; 
        }
        return true;
    }

}

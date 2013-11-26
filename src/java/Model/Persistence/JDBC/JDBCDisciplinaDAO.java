
package Model.Persistence.JDBC;

import Model.Persistence.DAOs.DisciplinaDAO;
import Model.Logic.Disciplina;
import Model.Persistence.FactoryDAO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCDisciplinaDAO extends JDBCDAO implements DisciplinaDAO{
    
    public JDBCDisciplinaDAO(){
        super();
    }
    
    /**
     * getDisciplina
     * Dado um código de disciplina, obtém a instância da disciplina correspondente a ele.
     */
    @Override
    public Disciplina getDisciplina(String id) {
        Disciplina novaDisciplina = null;
        try {
            String query = "SELECT * FROM disciplina WHERE codigo ='" + id + "'";
            st = con.createStatement();
            rs = st.executeQuery(query);
            
            //se o registro existir, obtém as informações da disciplina
            if(rs.next()){
                String nome = rs.getString("nome");
                String codigo = rs.getString("codigo");
                int numCreditos = rs.getInt("numCreditos");
                boolean ehEletiva = rs.getInt("ehEletiva") == 1;
                int numCreditosMin = rs.getInt("numCreditosMin");
                
                //obtém os pré-requisitos da disciplina
                query = "SELECT codigoDisciplinaRequisito FROM pre_requisito WHERE codigoDisciplina ='" + id + "'";
                st = con.createStatement();
                rs = st.executeQuery(query);
                
                //armazena os pré-requisitos em uma lista
                ArrayList<String> preRequisitos = new ArrayList<String>();
                while(rs.next()){
                    preRequisitos.add(rs.getString("codigoDisciplinaRequisito"));
                }
                
                //cria a instância
                novaDisciplina = new Disciplina (codigo, nome, numCreditos, ehEletiva, numCreditosMin, preRequisitos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCDisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return novaDisciplina;
    }

    /**
     * getPreRequisitos
     * Obtém as disciplinas que são pré-requisitos de uma dada disciplina.
     */
    @Override
    public Set<Disciplina> getPreRequisitos(Disciplina disciplina) {
        Set<Disciplina> preRequisitos = new HashSet<Disciplina>();
        try {
            String query = "SELECT codigoDisciplinaRequisito FROM pre_requisito "
                            + "WHERE codigoDisciplina = '" + disciplina.getCodigo() + "'";
            st = con.createStatement();
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
    
    /**
     * getCodigoDisciplinas
     * Obtém todas as disciplinas cadastradas no sistema.
     */
    @Override
    public ArrayList<Disciplina> getDisciplinas(){
        ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
        try{
            //obtém todos os registros de disciplinas
            String query = "SELECT * FROM disciplina";
            st = con.createStatement();
            rs = st.executeQuery(query);

            //cria as instâncias de disciplinas e as coloca no array (sem os pré-requisitos)
            while(rs.next()){
                String nome = rs.getString("nome");
                String codigo = rs.getString("codigo");
                int numCreditos = rs.getInt("numCreditos");
                boolean ehEletiva = rs.getInt("ehEletiva") == 1;
                int numCreditosMin = rs.getInt("numCreditosMin");

                Disciplina disciplina = new Disciplina(codigo, nome, numCreditos, ehEletiva, numCreditosMin, new ArrayList<String>());
                disciplinas.add(disciplina);
            }
            
            //obtém os pré-requisitos de cada disciplina
            for(Disciplina disciplina : disciplinas){
                query = "SELECT codigoDisciplinaRequisito FROM pre_requisito WHERE codigoDisciplina = '" + disciplina.getCodigo() + "'";
                st = con.createStatement();
                rs = st.executeQuery(query);
                
                //adiciona cada um dos pré-requisitos na lista de pré-requisitos
                ArrayList<String> preRequisitos = new ArrayList<String>();
                while(rs.next()){
                    preRequisitos.add(rs.getString("codigoDisciplinaRequisito"));
                }
                disciplina.setPreRequisitos(preRequisitos);
            }
        } catch(SQLException ex){
            Logger.getLogger(JDBCDisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return disciplinas;
    }
    
    /**
     * adicionarDisciplina
     * Adiciona uma nova disciplina no BD. (assume que os dados esão corretos)
     */
    @Override
    public boolean adicionarDisciplina(Disciplina disciplina){
        try{
            //insere a disciplina na tabela de disciplinas
            PreparedStatement statement = con.prepareStatement("INSERT INTO disciplina "
                                        + "(codigo, nome, ehEletiva, numCreditos, numCreditosMin)"
                                        + " VALUES (?, ?, ?, ?, ?)");
            statement.setString(1, disciplina.getCodigo()); 
            statement.setString(2, disciplina.getNome());
            if(disciplina.isEletiva()){ statement.setInt(3, 1); }
            else{ statement.setInt(3, 0); }
            statement.setInt(4, disciplina.getNumeroDeCreditos());
            statement.setInt(5, disciplina.getNumeroDeCreditosMinimos());
            statement.execute();
            
            //insere os seus pré-requisitos na tabela de pré-requisitos
            for(String preRequisito : disciplina.getPreRequisitos()){
                statement = con.prepareStatement("INSERT INTO pre_requisito "
                                        + "(codigoDisciplina, codigoDisciplinaRequisito)"
                                        + " VALUES (?, ?)");
                statement.setString(1, disciplina.getCodigo()); 
                statement.setString(2, preRequisito);
                statement.execute();
            }
            
        } catch(SQLException ex){
            Logger.getLogger(JDBCDisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
}

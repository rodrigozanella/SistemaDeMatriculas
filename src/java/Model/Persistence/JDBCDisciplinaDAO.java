
package Model.Persistence;

import Model.Logic.Disciplina;
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

}

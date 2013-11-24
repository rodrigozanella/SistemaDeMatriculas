/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Logic;

import Model.Persistence.FactoryDAO;
import Model.Persistence.DAOs.UsuarioDAO;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Zanella
 */
public class AlunoTest {
    private FactoryDAO factory;
    private UsuarioDAO alunoDAO;
    private Aluno instancia;
    
    public AlunoTest() {
        factory = new FactoryDAO();
        alunoDAO = factory.criarUsuarioDAO();
        instancia = null;
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
        
    }
    
    @Before
    public void setUp() {
        instancia = (Aluno) alunoDAO.getUsuario("rzanella", "1234");
    }
    
    @After
    public void tearDown() {
        instancia = null;
    }

    /**
     * Test of getPossibilidadesMatricula method, of class Aluno.
     */
    @Test
    public void testGetPossibilidadesMatricula() {
        Set<Turma> novasPossibilidades = instancia.getPossibilidadesMatricula();
        
    }

    /**
     * Test of getHistorico method, of class Aluno.
     */
    @Test
    public void testGetHistorico() {
        HistoricoEscolar novohist = instancia.getHistorico();
        List<HistoricoEscolarElemento> novoElemHist = novohist.getHistorico();
        Iterator<HistoricoEscolarElemento> itElementoHist = novoElemHist.iterator();
        while(itElementoHist.hasNext()){
            HistoricoEscolarElemento novoElemento = itElementoHist.next();
        }
    }
    
}
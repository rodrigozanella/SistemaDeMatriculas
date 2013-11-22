/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Persistence;

import Model.Logic.Aluno;
import Model.Logic.HistoricoEscolar;
import Model.Logic.HistoricoEscolarElemento;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Zanella
 */
public class JDBCHistoricoDAOTest {
    
    public JDBCHistoricoDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getHistorico method, of class JDBCHistoricoDAO.
     */
    @Test
    public void testGetHistorico() {
        System.out.println("getHistorico");
        Aluno aluno = null;
        JDBCHistoricoDAO instance = new JDBCHistoricoDAO();
        HistoricoEscolar expResult = null;
        HistoricoEscolar result = instance.getHistorico(aluno);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of salvarElemento method, of class JDBCHistoricoDAO.
     */
    @Test
    public void testSalvarElemento() {
        System.out.println("salvarElemento");
        HistoricoEscolarElemento novoElemento = null;
        JDBCHistoricoDAO instance = new JDBCHistoricoDAO();
        boolean expResult = false;
        boolean result = instance.salvarElemento(novoElemento);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDisciplinasCursadas method, of class JDBCHistoricoDAO.
     */
    @Test
    public void testGetDisciplinasCursadas() {
        System.out.println("getDisciplinasCursadas");
        Aluno aluno = null;
        JDBCHistoricoDAO instance = new JDBCHistoricoDAO();
        Set expResult = null;
        Set result = instance.getDisciplinasCursadas(aluno);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDisciplinasNaoCursadas method, of class JDBCHistoricoDAO.
     */
    @Test
    public void testGetDisciplinasNaoCursadas() {
        System.out.println("getDisciplinasNaoCursadas");
        Aluno aluno = null;
        JDBCHistoricoDAO instance = new JDBCHistoricoDAO();
        Set expResult = null;
        Set result = instance.getDisciplinasNaoCursadas(aluno);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
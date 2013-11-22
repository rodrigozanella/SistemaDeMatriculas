/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Persistence;

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
public class FactoryDAOTest {
    
    public FactoryDAOTest() {
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
     * Test of criarUsuarioDAO method, of class FactoryDAO.
     */
    @Test
    public void testCriarUsuarioDAO() {
        System.out.println("criarUsuarioDAO");
        FactoryDAO instance = new FactoryDAO();
        UsuarioDAO expResult = null;
        UsuarioDAO result = instance.criarUsuarioDAO();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of criarSistemaDAO method, of class FactoryDAO.
     */
    @Test
    public void testCriarSistemaDAO() {
        System.out.println("criarSistemaDAO");
        FactoryDAO instance = new FactoryDAO();
        SistemaDAO expResult = null;
        SistemaDAO result = instance.criarSistemaDAO();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of criarHistoricoDAO method, of class FactoryDAO.
     */
    @Test
    public void testCriarHistoricoDAO() {
        System.out.println("criarHistoricoDAO");
        FactoryDAO instance = new FactoryDAO();
        HistoricoDAO expResult = null;
        HistoricoDAO result = instance.criarHistoricoDAO();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of criarTurmaDAO method, of class FactoryDAO.
     */
    @Test
    public void testCriarTurmaDAO() {
        System.out.println("criarTurmaDAO");
        FactoryDAO instance = new FactoryDAO();
        TurmaDAO expResult = null;
        TurmaDAO result = instance.criarTurmaDAO();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of criarDisciplinaDAO method, of class FactoryDAO.
     */
    @Test
    public void testCriarDisciplinaDAO() {
        System.out.println("criarDisciplinaDAO");
        FactoryDAO instance = new FactoryDAO();
        DisciplinaDAO expResult = null;
        DisciplinaDAO result = instance.criarDisciplinaDAO();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
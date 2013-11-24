/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Persistence;

import Model.Persistence.JDBC.JDBCDisciplinaDAO;
import Model.Logic.Disciplina;
import java.util.ArrayList;
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
public class JDBCDisciplinaDAOTest {
    
    public JDBCDisciplinaDAOTest() {
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
     * Test of getDisciplina method, of class JDBCDisciplinaDAO.
     */
    @Test
    public void testGetDisciplina() {
        System.out.println("getDisciplina");
        String id = "";
        JDBCDisciplinaDAO instance = new JDBCDisciplinaDAO();
        Disciplina expResult = null;
        Disciplina result = instance.getDisciplina(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPreRequisitos method, of class JDBCDisciplinaDAO.
     */
    @Test
    public void testGetPreRequisitos() {
        System.out.println("getPreRequisitos");
        Disciplina disciplina = null;
        JDBCDisciplinaDAO instance = new JDBCDisciplinaDAO();
        Set expResult = null;
        Set result = instance.getPreRequisitos(disciplina);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDisciplinas method, of class JDBCDisciplinaDAO.
     */
    @Test
    public void testGetDisciplinas() {
        System.out.println("getDisciplinas");
        JDBCDisciplinaDAO instance = new JDBCDisciplinaDAO();
        ArrayList expResult = null;
        ArrayList result = instance.getDisciplinas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of adicionarDisciplina method, of class JDBCDisciplinaDAO.
     */
    @Test
    public void testAdicionarDisciplina() {
        System.out.println("adicionarDisciplina");
        Disciplina disciplina = null;
        JDBCDisciplinaDAO instance = new JDBCDisciplinaDAO();
        boolean expResult = false;
        boolean result = instance.adicionarDisciplina(disciplina);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
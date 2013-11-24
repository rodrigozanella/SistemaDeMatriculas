/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Persistence;

import Model.Persistence.JDBC.JDBCSistemaDAO;
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
public class JDBCSistemaDAOTest {
    
    public JDBCSistemaDAOTest() {
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
     * Test of getEstado method, of class JDBCSistemaDAO.
     */
    @Test
    public void testGetEstado() {
        System.out.println("getEstado");
        JDBCSistemaDAO instance = new JDBCSistemaDAO();
        String expResult = "";
        String result = instance.getEstado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSemestre method, of class JDBCSistemaDAO.
     */
    @Test
    public void testGetSemestre() {
        System.out.println("getSemestre");
        JDBCSistemaDAO instance = new JDBCSistemaDAO();
        String expResult = "";
        String result = instance.getSemestre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstado method, of class JDBCSistemaDAO.
     */
    @Test
    public void testSetEstado() {
        System.out.println("setEstado");
        String novoEstado = "";
        JDBCSistemaDAO instance = new JDBCSistemaDAO();
        boolean expResult = false;
        boolean result = instance.setEstado(novoEstado);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSemestre method, of class JDBCSistemaDAO.
     */
    @Test
    public void testSetSemestre() {
        System.out.println("setSemestre");
        String novoSemestre = "";
        JDBCSistemaDAO instance = new JDBCSistemaDAO();
        boolean expResult = false;
        boolean result = instance.setSemestre(novoSemestre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
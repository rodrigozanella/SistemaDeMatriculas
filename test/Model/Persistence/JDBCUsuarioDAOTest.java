/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Persistence;

import Model.Persistence.JDBC.JDBCUsuarioDAO;
import Model.Logic.Usuario;
import java.util.ArrayList;
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
public class JDBCUsuarioDAOTest {
    
    public JDBCUsuarioDAOTest() {
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
     * Test of getUsuario method, of class JDBCUsuarioDAO.
     */
    @Test
    public void testGetUsuario() {
        System.out.println("getUsuario");
        String name = "";
        String password = "";
        JDBCUsuarioDAO instance = new JDBCUsuarioDAO();
        Usuario expResult = null;
        Usuario result = instance.getUsuario(name, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of excluirUsuario method, of class JDBCUsuarioDAO.
     */
    @Test
    public void testExcluirUsuario() {
        System.out.println("excluirUsuario");
        Usuario user = null;
        JDBCUsuarioDAO instance = new JDBCUsuarioDAO();
        boolean expResult = false;
        boolean result = instance.excluirUsuario(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of adicionarUsuario method, of class JDBCUsuarioDAO.
     */
    @Test
    public void testAdicionarUsuario() {
        System.out.println("adicionarUsuario");
        Usuario user = null;
        JDBCUsuarioDAO instance = new JDBCUsuarioDAO();
        boolean expResult = false;
        boolean result = instance.adicionarUsuario(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProfessores method, of class JDBCUsuarioDAO.
     */
    @Test
    public void testGetProfessores() {
        System.out.println("getProfessores");
        JDBCUsuarioDAO instance = new JDBCUsuarioDAO();
        ArrayList expResult = null;
        ArrayList result = instance.getProfessores();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
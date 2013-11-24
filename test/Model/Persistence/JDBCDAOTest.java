/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Persistence;

import Model.Persistence.JDBC.JDBCDAO;
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
public class JDBCDAOTest {
    
    public JDBCDAOTest() {
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
     * Test of finalize method, of class JDBCDAO.
     */
    @Test
    public void testFinalize() {
        System.out.println("finalize");
        JDBCDAO instance = new JDBCDAO();
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
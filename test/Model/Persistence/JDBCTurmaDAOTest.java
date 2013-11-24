/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Persistence;

import Model.Persistence.JDBC.JDBCTurmaDAO;
import Model.Logic.Turma;
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
public class JDBCTurmaDAOTest {
    
    public JDBCTurmaDAOTest() {
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
     * Test of getTurma method, of class JDBCTurmaDAO.
     */
    @Test
    public void testGetTurma() {
        System.out.println("getTurma");
        int id = 0;
        JDBCTurmaDAO instance = new JDBCTurmaDAO();
        Turma expResult = null;
        Turma result = instance.getTurma(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of adicionaTurma method, of class JDBCTurmaDAO.
     */
    @Test
    public void testAdicionaTurma() {
        System.out.println("adicionaTurma");
        Turma turma = null;
        JDBCTurmaDAO instance = new JDBCTurmaDAO();
        boolean expResult = false;
        boolean result = instance.adicionaTurma(turma);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of excluirTurma method, of class JDBCTurmaDAO.
     */
    @Test
    public void testExcluirTurma() {
        System.out.println("excluirTurma");
        Turma turma = null;
        JDBCTurmaDAO instance = new JDBCTurmaDAO();
        boolean expResult = false;
        boolean result = instance.excluirTurma(turma);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTurmasSemestre method, of class JDBCTurmaDAO.
     */
    @Test
    public void testGetTurmasSemestre() {
        System.out.println("getTurmasSemestre");
        String codDisciplina = "";
        String semestre = "";
        JDBCTurmaDAO instance = new JDBCTurmaDAO();
        Set expResult = null;
        Set result = instance.getTurmasSemestre(codDisciplina, semestre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
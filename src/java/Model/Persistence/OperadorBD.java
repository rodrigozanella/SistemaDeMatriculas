/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Persistence;

import Model.Logic.Aluno;
import Model.Logic.Disciplina;
import Model.Logic.Turma;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tiago
 */
public class OperadorBD {
    //private static Connection con;
    static Connection con;
    static Statement st;
    static ResultSet rs;
    
    /* Inicializa conexão com o BD */
    public static void conectaBD() throws Exception{
        con = null;
	st = null;
	rs = null;

	try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            //preencham com as informações de vocês aqui
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/es_pratica3","root","aaaa");
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(OperadorBD.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            throw new Exception();
        }
    }
    
    /* Fecha conexão com BD */
    public static void desconectaBD() throws Exception{
        try {
            if (rs != null) {
                rs.close();
	    }
            if (st != null) {
                st.close();
	    }
            if (con != null) {
                con.close();
	    }
	} catch (SQLException ex) {
            Logger lgr = Logger.getLogger(OperadorBD.class.getName());
	    lgr.log(Level.WARNING, ex.getMessage(), ex);
            throw new Exception();
        }
    }
    
    /*
     * Insere um novo aluno no BD. Assume que seus atributos já foram verificados.
     */
    public static void insereRegistroAluno(Aluno novoAluno){
        //insere na tabela ALUNOS
    }
    
    /*
     * Insere uma nova turma no BD. Assume que seus atributos já foram verificados.
     */
    public static void insereRegistroTurma(Turma novaTurma){
        //insere na tabela TURMAS
    }

    /*
     * Insere uma nova disciplina no BD. Assume que seus atributos já foram verificados.
     */
    public static void insereRegistroDisciplina(Disciplina novaDisciplina){
        //insere na tabela DISCIPLINAS
    }
    
    /*
     * Procura no BD pelo registro do aluno que contém o username e senha especificados.
     */
    public static boolean existeAluno(String nomeDeUsuario, String senha) throws Exception{
        
        try{
            conectaBD();
            st = con.createStatement();
            String query = "SELECT * FROM aluno WHERE nome = '"+nomeDeUsuario+"' AND senha = '"+senha+"'";
            rs = st.executeQuery(query);
            if(!rs.next()){//se não encontrou, retorna falso
                return false;
            }
            desconectaBD();
        } catch(Exception ex){
            Logger lgr = Logger.getLogger(OperadorBD.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            throw new Exception();
        }

        return true;
    }
    
    /*
     * Procura no BD pelo registros de turmas da disciplina especificada em todos os semestres.
     */
    public static ArrayList<Turma> getTurmas(String codigoDisciplina){
        //procura na tabela TURMAS
        
        ArrayList<Turma> turmas = new ArrayList<Turma>();
        //para cada turma encontrada, insere ela na lista
        
        return turmas;
    }
    
    /*
     * Retorna uma lista de disciplinas que contém as disciplinas especificadas como pré-requisitos.
     */
    public static ArrayList<Disciplina> getDisciplinasPorRequisitos(ArrayList<Disciplina> preRequisitos){
        //procura na tabela DISCIPLINAS E PRÉ-REQUISITOS
        
        ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
        //para cada disciplina encontrada, insere ela na lista
        
        return disciplinas;
    }
    
    /*
     * Dado um código de disciplina, retorna true se ele já foi utilizado e false caso contrário.
     */
    public static boolean existeDisciplina(String codigoDaDisciplina){
        //procura na tabela DISCIPLINAS
        
        return false;
    }
}

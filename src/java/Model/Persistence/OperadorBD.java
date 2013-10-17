/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Persistence;

import Model.Logic.Aluno;
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
     * Procura no BD pelo registro do aluno que contém o username e senha especificados e o retorna.
     */
    public static Aluno obtemAluno(String nomeDeUsuario, String senha) throws Exception{
        Aluno aluno;
        try{
            conectaBD();
            st = con.createStatement();
            String query = "SELECT * FROM aluno WHERE nome = '"+nomeDeUsuario+"' AND senha = '"+senha+"'";
            rs = st.executeQuery(query);
            if(!rs.next()){
                throw new Exception();
            } else {
                aluno = new Aluno(rs.getString(2), rs.getString(6), rs.getString(1), rs.getString(3), rs.getString(4), rs.getInt(5));
            }
        } catch(Exception ex){
            Logger lgr = Logger.getLogger(OperadorBD.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            throw new Exception();
        } finally {
            desconectaBD();
        }

        return aluno;
    }
    
    /*
     * Retorna uma lista de códigos de disciplinas que são pré-requisitos de uma outra disciplina.
     */
    public static ArrayList<String> obtemPreRequisitos(String codigoDisciplina) throws Exception{
        ArrayList<String> preRequisitos = new ArrayList<String>();
        try{
            conectaBD();
            st = con.createStatement();
            String query = "SELECT codigoDisciplinaRequisito FROM pre_requisitos WHERE codigoDisciplina = '"+codigoDisciplina+"'";
            rs = st.executeQuery(query);
            do{
                if(!rs.next()) break;
                preRequisitos.add(rs.getString(1));
            }while(true);
        } catch(Exception ex){
            Logger lgr = Logger.getLogger(OperadorBD.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            throw new Exception();
        } finally {
            desconectaBD();
        }

        return preRequisitos;
    }
    
     /*
     * Retorna uma lista de códigos de disciplinas que já foram cursadas por um determinado aluno.
     */
    public static ArrayList<String> obtemDisciplinasCursadas(Aluno aluno) throws Exception{
        ArrayList<String> disciplinas = new ArrayList<String>();
        try{
            conectaBD();
            st = con.createStatement();
            String query = "SELECT codigoDisciplina FROM turma, turmas_cursadas WHERE cpfAluno = '"+aluno.getCpf()+"' AND conceito != 'D' AND conceito != 'FF' AND turma.idTurma = turmas_cursadas.idTurma";
            rs = st.executeQuery(query);
            do{
                if(!rs.next()) break;
                disciplinas.add(rs.getString(1));
            }while(true);
        } catch(Exception ex){
            Logger lgr = Logger.getLogger(OperadorBD.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            throw new Exception();
        } finally {
            desconectaBD();
        }

        return disciplinas;
    }
    
      /*
     * Retorna uma lista de códigos de disciplinas que não foram cursadas por um determinado aluno.
     */
    public static ArrayList<String> obtemDisciplinasNaoCursadas(Aluno aluno) throws Exception{
        ArrayList<String> disciplinasTotais = new ArrayList<String>();
        ArrayList<String> disciplinasCursadas = new ArrayList<String>();
        
        try{
            conectaBD();
            st = con.createStatement();
            String query = "SELECT codigo FROM disciplina";
            rs = st.executeQuery(query);
            do{
                if(!rs.next()) break;
                disciplinasTotais.add(rs.getString(1));
            }while(true);
            disciplinasCursadas = obtemDisciplinasCursadas(aluno);
        } catch(Exception ex){
            Logger lgr = Logger.getLogger(OperadorBD.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            throw new Exception();
        } finally {
            desconectaBD();
        }
        
        disciplinasTotais.removeAll(disciplinasCursadas);
        return disciplinasTotais;
    }
    
    /*
     * Obtem as turmas de uma dada disciplina oferecidas em um determinado semestre
     */
    public static ArrayList<Turma> obtemTurmasDeDisciplina(String codigoDisciplina, String semestre) throws Exception{
        ArrayList<Turma> possibilidadesDeTurmas = new ArrayList<Turma>();
        
        try{
            conectaBD();
            st = con.createStatement();
            String query = "SELECT * FROM turma WHERE codgoDisciplina = '"+codigoDisciplina+"' AND semestre = '"+semestre+"'";
            rs = st.executeQuery(query);
            do{
                if(!rs.next()) break;
                possibilidadesDeTurmas.add(new Turma(rs.getString(3), rs.getString(2).charAt(0), rs.getString(5), rs.getInt(6)));
            }while(true);
        } catch(Exception ex){
            Logger lgr = Logger.getLogger(OperadorBD.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            throw new Exception();
        } finally {
            desconectaBD();
        }

        return possibilidadesDeTurmas;      
    }
    
    /*
     * Converte o código da disciplina para o seu nome.
     */
    public static String getNomeDisciplina(String codigoDisciplina) throws Exception{
        String nome = "";
        try{
            conectaBD();
            st = con.createStatement();
            String query = "SELECT nome FROM disciplina WHERE codgoDisciplina = '"+codigoDisciplina+"'";
            rs = st.executeQuery(query);
            if(rs.next()){
                nome = rs.getString(1);
            }
        } catch(Exception ex){
            Logger lgr = Logger.getLogger(OperadorBD.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            throw new Exception();
        } finally {
            desconectaBD();
        }

        return nome;      
    }
    
    /*
    * Retorna o estado do sistema
    */
    public static String getEstadoSistema(){
        return "Matricula";
    } 
    
}

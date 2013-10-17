/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Persistence;

import Model.Logic.Aluno;
import Model.Logic.Disciplina;
import Model.Logic.Turma;
import java.util.ArrayList;

/**
 *
 * @author Tiago
 */
public class OperadorBD {
    
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
    public static Aluno getAluno(String nomeDeUsuario, String senha) throws Exception{
        //procura na tabela ALUNOS
        
        if(false){ //se não encontrou, lança excessão
            throw new Exception();
        }
        
        return new Aluno(); //se encontrou, instancia o aluno e o retorna
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

package Model.Validation;

import Model.Logic.Professor;

/**
 * Classe utilizada para a validação de dados de um professor
 * @author Rodrigo Zanella Ribeiro
 */

public class ProfessorValidador {
    private Professor professor;
    
    public ProfessorValidador(){
        professor = null;
    }
    
    public void setProfessor(Professor novoProfessor){
        professor = novoProfessor;
    }
    
    public boolean validaAreaInteresse(){
        return false;
    }
    
    public boolean validaTurmasLecionadas(){
        return false;
    }
}

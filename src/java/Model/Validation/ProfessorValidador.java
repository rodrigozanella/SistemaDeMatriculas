/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Validation;

import Model.Logic.Professor;

/**
 *
 * @author Zanella
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

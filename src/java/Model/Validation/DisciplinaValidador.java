/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Validation;

import Model.Logic.Disciplina;

/**
 *
 * @author Zanella
 */
public class DisciplinaValidador {
    private Disciplina disciplina;
    
    public DisciplinaValidador(){
        disciplina = null;
    }
    
    public void setDisciplina(Disciplina novaDisciplina){
        disciplina = novaDisciplina;
    }
    
    public boolean validaNome(){
        return false;
    }
    
    public boolean validaCodigo(){
        return false;
    }
    
    public boolean validaNumeroDeCreditos(){
        return false;
    }
    
    public boolean validaEletiva(){
        return false;
    }
    
    public boolean validaNumCreditosMinimos(){
        return false;
    }
    
    public boolean validaPreRequisitos(){
        return false;
    }
}

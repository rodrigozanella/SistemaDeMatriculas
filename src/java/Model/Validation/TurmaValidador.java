/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Validation;

import Model.Logic.Turma;

/**
 *
 * @author Zanella
 */
public class TurmaValidador {
    private Turma turma;
    
    public TurmaValidador(){
        turma = null;
    }
    
    public void setTurma(Turma novaTurma){
        turma = novaTurma;
    }
    
    public boolean validaCodigoDisciplina(){
        return false;
    }
    
    public boolean validaCodigoUnico(){
        return false;
    }
    
    public boolean validaCodigo(){
        return false;
    }
    
    public boolean validaSemestre(){
        return false;
    }
    
    public boolean validaNumeroDeVagas(){
        return false;
    }
    
    public boolean validaHorario(){
        return false;
    }
    
    public boolean validaCPFProfessor(){
        return false;
    }
    
}

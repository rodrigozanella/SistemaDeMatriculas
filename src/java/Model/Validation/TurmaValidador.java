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
        return true;
    }
    
    public boolean validaCodigoUnico(){
        return true;
    }
    
    public boolean validaCodigo(){
        return true;
    }
    
    public boolean validaSemestre(){
        return turma.getSemestre().matches("20[0-9][0-9]/(1|2)");
    }
    
    public boolean validaNumeroDeVagas(){
        return turma.getNumeroDeVagas() >= 0;
    }
    
    public boolean validaHorario(){
        return turma.getHorario().matches("[0-9][0-9]:[0-9][0-9]");
    }
    
    public boolean validaCPFProfessor(){
        return turma.getCpfProfessor().matches("[0-9][0-9][0-9].[0-9][0-9][0-9].[0-9][0-9][0-9]-[0-9][0-9]");
    }
    
    public boolean validaTudo(){
        return this.validaCPFProfessor() &&
                this.validaCodigo() &&
                this.validaCodigoDisciplina() &&
                this.validaCodigoUnico() &&
                this.validaHorario() &&
                this.validaNumeroDeVagas() &&
                this.validaSemestre();
    }
}

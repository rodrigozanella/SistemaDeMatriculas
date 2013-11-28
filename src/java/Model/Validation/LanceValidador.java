/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Validation;

import Model.Logic.Lance;

/**
 *
 * @author Zanella
 */
public class LanceValidador {
    private Lance lance;
    
    public LanceValidador(){
        lance = null;
    }
    
    public void setLance(Lance novoLance){
        lance = novoLance;
    }
    
    public boolean validaIDTurma(){
        return true;
    }
    
    public boolean validaCPFAluno(){
        return lance.getCpfAluno().matches("[0-9][0-9][0-9].[0-9][0-9][0-9].[0-9][0-9][0-9]-[0-9][0-9]");
    }
    
    public boolean validaValor(){
        return lance.getValor() >= 0;
    }
    
    public boolean validaSituacao(){
        return true;
    }
    
    public boolean validaTudo(){
        return this.validaCPFAluno() &&
                this.validaIDTurma() &&
                this.validaSituacao() &&
                this.validaValor();
    }
}

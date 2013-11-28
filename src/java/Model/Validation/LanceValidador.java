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
        return false;
    }
    
    public boolean validaCPFAluno(){
        return false;
    }
    
    public boolean validaValor(){
        return false;
    }
    
    public boolean validaSituacao(){
        return false;
    }
}

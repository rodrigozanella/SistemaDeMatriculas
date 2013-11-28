/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Validation;

import Model.Logic.Administrador;

/**
 *
 * @author Zanella
 */
public class AdministradorValidador {
    private Administrador administrador;
    
    public AdministradorValidador(){
        administrador = null;
    }
    
    public void setAdministrador(Administrador novoAdministrador){
        administrador = novoAdministrador;
    }
    
    public boolean validaHistoricoOperacoes(){
        return false;
    }
}

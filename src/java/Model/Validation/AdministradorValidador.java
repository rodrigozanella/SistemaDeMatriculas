package Model.Validation;

import Model.Logic.Administrador;

/**
 * Classe utilizada para a validação de dados do administrador
 * @author Rodrigo Zanella Ribeiro
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


package Model.Validation;

import Model.Logic.Lance;
import Model.Persistence.DAOs.TurmaDAO;
import Model.Persistence.FactoryDAO;

/**
 * Classe utilizada para a validação de dados de um lance
 * @author Rodrigo Zanella Ribeiro
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
        FactoryDAO factoryDAO = new FactoryDAO();
        TurmaDAO turmaDAO = factoryDAO.criarTurmaDAO();
        
        if(turmaDAO.getTurma(lance.getIdTurma()) == null){
            return false;
        } 
        
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

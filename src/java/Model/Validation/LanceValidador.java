
package Model.Validation;

import Model.Logic.Aluno;
import Model.Logic.Lance;
import Model.Persistence.DAOs.LanceDAO;
import Model.Persistence.DAOs.TurmaDAO;
import Model.Persistence.DAOs.UsuarioDAO;
import Model.Persistence.FactoryDAO;
import java.util.Set;

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
    
    public boolean existeLance(){
        //verifica se o aluno já possui um lance para a turma selecionada
        FactoryDAO factoryDAO = new FactoryDAO();
        UsuarioDAO usuarioDAO = factoryDAO.criarUsuarioDAO();
        Aluno aluno = (Aluno)usuarioDAO.getUsuario(lance.getCpfAluno());
        LanceDAO lanceDAO = factoryDAO.criarLanceDAO();
        Set<Lance> lances = lanceDAO.getLances(aluno);
        for(Lance lanceCorrente : lances){
            if(lanceCorrente.getIdTurma() == lance.getIdTurma()){
                return true;
            }
        }
        return false;
    }
    
    public boolean validaTudo(){
        return this.validaCPFAluno() &&
                this.validaIDTurma() &&
                this.validaSituacao() &&
                this.validaValor() &&
                this.existeLance();
    }
}

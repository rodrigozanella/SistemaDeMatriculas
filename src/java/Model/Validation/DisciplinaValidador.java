package Model.Validation;

import Model.Logic.Disciplina;
import Model.Persistence.DAOs.DisciplinaDAO;
import Model.Persistence.FactoryDAO;

/**
 * Classe utilizada para a validação de dados de uma disciplina
 * @author Rodrigo Zanella Ribeiro
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
        return disciplina.getNome().length() > 0;
    }
    
    public boolean validaCodigo(){
        FactoryDAO factoryDAO = new FactoryDAO();
        DisciplinaDAO disciplinaDAO = factoryDAO.criarDisciplinaDAO();
        
        if(disciplinaDAO.getDisciplina(disciplina.getCodigo()) != null){
            return false;
        } 
        
        return true;
    }
    
    public boolean validaNumeroDeCreditos(){
        return disciplina.getNumeroDeCreditos() > 0;
    }
    
    public boolean validaEletiva(){
        return true;
    }
    
    public boolean validaNumCreditosMinimos(){
        return disciplina.getNumeroDeCreditosMinimos() >= 0;
    }
    
    public boolean validaPreRequisitos(){
        FactoryDAO factoryDAO = new FactoryDAO();
        DisciplinaDAO disciplinaDAO = factoryDAO.criarDisciplinaDAO();
        
        for(String id : disciplina.getPreRequisitos()){
            if(disciplinaDAO.getDisciplina(id) == null){
                return false;
            } 
        }
        
        return true;
    }
    
    public boolean validaTudo(){
        return this.validaCodigo() &&
                this.validaEletiva() &&
                this.validaNome() &&
                this.validaNumCreditosMinimos() &&
                this.validaNumeroDeCreditos() &&
                this.validaPreRequisitos();
    }
}

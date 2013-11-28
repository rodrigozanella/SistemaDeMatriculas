
package Model.Validation;

import Model.Logic.HistoricoEscolar;

/**
 * Classe utilizada para a validação de dados de um histórico escolar
 * @author Rodrigo Zanella Ribeiro
 */

public class HistoricoValidador {
    private HistoricoEscolar historico;
    
    public HistoricoValidador(){
        historico = null;
    }
    
    public void setHistorico(HistoricoEscolar novoHistorico){
        historico = novoHistorico;
    }
    
    public boolean validaElementos(){
        return false;
    }
}

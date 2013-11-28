/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Validation;

import Model.Logic.HistoricoEscolar;

/**
 *
 * @author Zanella
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

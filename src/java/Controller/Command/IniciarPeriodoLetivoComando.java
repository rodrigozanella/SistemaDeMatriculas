/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Command;

import Model.Persistence.DAOs.SistemaDAO;
import Model.Persistence.FactoryDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Zanella
 */
public class IniciarPeriodoLetivoComando implements Comando{

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) {
        FactoryDAO factory = new FactoryDAO();
        SistemaDAO sistemaDAO = factory.criarSistemaDAO();
        String estadoAtual = sistemaDAO.getEstado();
        if(estadoAtual.equalsIgnoreCase("metricula")){
            if(sistemaDAO.setEstado("letivo")){
                //preencher vaga das turmas
                
            }
        }
    }
    
}

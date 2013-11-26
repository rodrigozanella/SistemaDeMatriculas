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
public class IniciarPeriodoEncomendaComando implements Comando{

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) {
        FactoryDAO factory = new FactoryDAO();
        SistemaDAO sistemaDAO = factory.criarSistemaDAO();
        String estadoAtual = sistemaDAO.getEstado();
        if(estadoAtual.equalsIgnoreCase("ferias")){
            //verifica se tem ao menos uma turma aberta
                if(sistemaDAO.setSemestre("matricula")){
                    //calcula pontos de ordenamento dos alunos
                    
                }
        }
    }
    
}

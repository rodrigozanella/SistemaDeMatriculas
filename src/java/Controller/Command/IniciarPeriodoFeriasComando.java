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
public class IniciarPeriodoFeriasComando implements Comando{

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) {  
        FactoryDAO factory = new FactoryDAO();
        SistemaDAO sistemaDAO = factory.criarSistemaDAO();
        String estadoAtual = sistemaDAO.getEstado();
        if(estadoAtual.equalsIgnoreCase("letivo")){
            if(sistemaDAO.setEstado("ferias")){
                //expulsa alunos com 10 ou mais FF

                //expulsa alunos com 10 ou mais anos de curso

                //gradua alunos que completaram os creditos obrigatorios e eletivos
            }
        }
    }
    
}

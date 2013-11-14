package Controller.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Comando
 * Interface que representa um comando
 * @author Rodrigo Zanella Ribeiro
 */
public interface Comando{
    /**
     * Comando
     * Executa a funcionalidade do comando
     * @param request Servlet Request
     * @param response Servlet Response
     * @author Rodrigo Zanella Ribeiro
     */
    public void executar(HttpServletRequest request, HttpServletResponse response);
    
}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Rodrigo Zanella Ribeiro
 * @since 13/10/2013
 * 
 * Classe controladora das ações de um usuário professor
 */
public abstract class ControladorProf extends ControladorUsuario {
    /**
    * Métodos do controlador
    */
    
    /**
     * @author Rodrigo Zanella Ribeiro
     * @since 13/10/2013
     * 
     * Método para visualizar turmas de um determinado professor
     * @param request Dados da requisição ao servlet
     * @param response Dados da resposta do servlet
     */
    public void visualizarTurmas(HttpServletRequest request, HttpServletResponse response){
        
    }
}

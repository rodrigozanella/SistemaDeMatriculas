/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.ControllerEstado;

import Model.Persistence.OperadorBD;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Rodrigo Zanella Ribeiro
 * @since 12/10/2013
 * 
 * Classe controladora das ações de um usuário qualquer
 */
public class ControladorUsuario extends Controlador {
    public static String nomeUsuarioLogado;
    public static String senhaUsuarioLogado;
    /**
     * Métodos do controlador
     */
    
    /**
     * @author Rodrigo Zanella Ribeiro
     * @since 12/10/2013
     * 
     * Método para a visualização de uma árvore curricular de algum curso
     * @param request Dados da requisição ao servlet
     * @param response Dados da resposta do servlet
     */
    public void arvoreCurricular(HttpServletRequest request, HttpServletResponse response){
        
    }
    
    /**
     * @author Rodrigo Zanella Ribeiro
     * @since 12/10/2013
     * 
     * Método para a visualizar informações sobre alguma disciplina
     * @param request Dados da requisição ao servlet
     * @param response Dados da resposta do servlet
     */
    public void infoDisciplinas(HttpServletRequest request, HttpServletResponse response){
        
    }
    /**
     * @author Rodrigo Zanella Ribeiro
     * @since 12/10/2013
     * 
     * Método para a visualizar informações sobre algum professor
     * @param request Dados da requisição ao servlet
     * @param response Dados da resposta do servlet
     */
    public void infoProfessores(HttpServletRequest request, HttpServletResponse response){
        
    }
    
     public void login(HttpServletRequest request, HttpServletResponse response){
        try {
            try{
                String nomeUsuario = request.getParameter("name");
                String senhaUsuario = request.getParameter("password");
                if(!OperadorBD.existeAluno(nomeUsuario, senhaUsuario)){
                    response.sendRedirect("login.jsp");
                }
                else{
                   //buscar as informações de usuario
                    response.sendRedirect("indexAluno.jsp");
                    HttpSession session = request.getSession();
                    session.setAttribute("usuario_autenticado", nomeUsuario);
                    session.setAttribute("id_usuario_autenticado", senhaUsuario);
                    nomeUsuarioLogado = nomeUsuario;
                    senhaUsuarioLogado = senhaUsuario;
                }
            } catch(Exception e){
                response.sendRedirect("login.jsp");
                throw new IOException();
            }
        } catch (IOException ex) {
            Logger.getLogger(ControladorUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

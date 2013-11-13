/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.Command.Comando;
import Controller.ControllerConta.AdminEstado;
import Controller.ControllerConta.AlunoEstado;
import Controller.ControllerConta.ProfEstado;
import Controller.ControllerConta.UsuarioEstado;
import Controller.ControllerEstado.FeriasEstado;
import Controller.ControllerEstado.LetivoEstado;
import Controller.ControllerEstado.MatriculaEstado;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Zanella
 */
@WebServlet(name = "ControladorContext", urlPatterns = {"/ControladorContext"})
public class ControladorContext extends HttpServlet {
    private Estado estadoSistema;
    private Estado estadoUsuario;
    private HashMap<String,Comando> comandosInt;
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.getSistemaEstado();
        this.getUsuarioEstado(request);
        this.getComandosEstado();
        Comando usuarioComando = this.getComando(request);
        if(usuarioComando==null){
            //vai para a página de erro
        }
        else{
            usuarioComando.executar(request, response);
        }     
    }
    
     protected void getSistemaEstado(){
        //instanciar um estado do estado do sistema
        String nomeEstadoSistema = "matricula"; // @todo: Fazer método que retorna o estado do sistema
        
        if(nomeEstadoSistema.equals("matricula")){
            estadoSistema = new MatriculaEstado();
        }
        if(nomeEstadoSistema.equals("letivo")){
            estadoSistema = new LetivoEstado();
        }
        if(nomeEstadoSistema.equals("ferias")){
            estadoSistema = new FeriasEstado();
        }
    }
    
    protected void getUsuarioEstado(HttpServletRequest request){
        HttpSession session = request.getSession();
        String role =(String) session.getAttribute("role");
        estadoUsuario = new UsuarioEstado();
        if(role!=null){
            if(role.equals("aluno")){
                estadoUsuario = new AlunoEstado();
            }
            if(role.equals("professor")){
                estadoUsuario = new ProfEstado();
            }
            if(role.equals("administrador")){
                estadoUsuario = new AdminEstado();
            }
        }
    }
    
    protected void getComandosEstado(){
        comandosInt = new HashMap<String,Comando>();
        
        HashMap<String,Comando> comandosEstado = estadoSistema.getComandos();
        HashMap<String,Comando> comandosUsuario = estadoUsuario.getComandos();
        
        Set<String> keysEstado = comandosEstado.keySet();
        Set<String> keysUsuario = comandosUsuario.keySet();
        
        Set<String> keysInt = keysEstado;
        keysInt.retainAll(keysUsuario);
        
        Iterator<String> itKeys = keysInt.iterator();
        while(itKeys.hasNext()){
            String atKey = itKeys.next();
            comandosInt.put(atKey, comandosEstado.get(atKey));
        }
    }
    
    protected Comando getComando(HttpServletRequest request){
        String nomeEvento = (String) request.getParameter("evento");
        Comando tmp = comandosInt.get(nomeEvento);
        return tmp;
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
}

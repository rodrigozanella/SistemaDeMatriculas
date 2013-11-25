/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Command;

import Model.Logic.Administrador;
import Model.Logic.Usuario;
import Model.Persistence.DAOs.AdministradorDAO;
import Model.Persistence.DAOs.UsuarioDAO;
import Model.Persistence.FactoryDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Zanella
 */
public class CadastrarAdministradorComando implements Comando{

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();
            Usuario usuario =(Usuario) session.getAttribute("novoUsuario");
            session.removeAttribute("novoUsuario");
            
            Administrador administrador = new Administrador(usuario.getNome(), 
                    usuario.getCpf(), usuario.getNomeDeUsuario(), usuario.getSenha(), 
                    usuario.getEmail(), usuario.getDataDeNascimento());
            
            FactoryDAO factory = new FactoryDAO();
            UsuarioDAO usuarioDAO = factory.criarUsuarioDAO();
            AdministradorDAO administradorDAO = factory.criarAdministradorDAO();
            
            if(usuarioDAO.adicionarUsuario(usuario)){
               administradorDAO.adicionarAdministrador(administrador);
            }
            
            RequestDispatcher reqDis= request.getRequestDispatcher("index.jsp");
            reqDis.forward(request,response);
        } catch (ServletException ex) {
            Logger.getLogger(CadastrarAdministradorComando.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CadastrarAdministradorComando.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

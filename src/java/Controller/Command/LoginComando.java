
package Controller.Command;

import Model.Logic.Usuario;
import Model.Persistence.FactoryDAO;
import Model.Persistence.DAOs.UsuarioDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Faz o login de algum usuário no sistema
 * @author Rodrigo Zanella Ribeiro
 */

public class LoginComando implements Comando {
    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response){
        try{
            String name = request.getParameter("name");
            String pass = request.getParameter("password");
            
            FactoryDAO novoFactoryDAO = new FactoryDAO();
            UsuarioDAO novoUsuarioDAO = novoFactoryDAO.criarUsuarioDAO();
            
            Usuario newUser = novoUsuarioDAO.getUsuario(name, pass);
            
            if(newUser!=null){   
                String tipo = newUser.getRole();
                HttpSession newSession = request.getSession();
                newSession.setAttribute("usuario", newUser);
            }
            RequestDispatcher reqDis= request.getRequestDispatcher("index.jsp");      
            reqDis.forward(request,response);

       } catch (ServletException ex) {
        Logger.getLogger(LoginComando.class.getName()).log(Level.SEVERE, null, ex);
       } catch (IOException ex) {
        Logger.getLogger(LoginComando.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
}
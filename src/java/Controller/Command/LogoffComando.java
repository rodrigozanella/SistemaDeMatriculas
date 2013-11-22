package Controller.Command;

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
public class LogoffComando implements Comando{

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();
            session.removeAttribute("usuario");
            RequestDispatcher reqDis= request.getRequestDispatcher("index.jsp");
            reqDis.forward(request,response);
        } catch (ServletException ex) {
            Logger.getLogger(LogoffComando.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LogoffComando.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

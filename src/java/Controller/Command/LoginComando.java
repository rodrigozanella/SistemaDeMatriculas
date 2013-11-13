
package Controller.Command;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginComando implements Comando {
    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response){
        String name = request.getParameter("name");
        String pass = request.getParameter("password");
        
        /*
         * VERIFICAR USUARIO E SENHA, RETORNANDO O TIPO DE USUARIO
         */
        
        //CRIAR UMA INSTANCIA DE ALUNO NA SESSION AINDA N CRIEI, PRECISO DA RECUPERAÇÃO AINDA
        
        String tipo = "aluno";
        HttpSession newSession = request.getSession();
        newSession.setAttribute("role", tipo);
        //redirecionar para algum index
        try {
            if(tipo.equalsIgnoreCase("aluno")){
                 RequestDispatcher reqDis= request.getRequestDispatcher("indexAluno.jsp");      
                 reqDis.forward(request,response);       
            }
            if(tipo.equalsIgnoreCase("administrador")){

            }
            if(tipo.equalsIgnoreCase("professor")){

            }
            RequestDispatcher reqDis= request.getRequestDispatcher("index.jsp");      
            reqDis.forward(request,response);
        } catch (IOException ex) {    
            Logger.getLogger(LoginComando.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(LoginComando.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

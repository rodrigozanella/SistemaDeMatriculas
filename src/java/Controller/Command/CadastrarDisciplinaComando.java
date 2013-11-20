
package Controller.Command;

import Model.Logic.Administrador;
import Model.Logic.Aluno;
import Model.Logic.Disciplina;
import Model.Logic.Professor;
import Model.Persistence.DisciplinaDAO;
import Model.Persistence.FactoryDAO;
import Model.Persistence.UsuarioDAO;
import Model.Validation.Validador;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 */
public class CadastrarDisciplinaComando implements Comando{
    @Override
     public void executar(HttpServletRequest request, HttpServletResponse response){
         try {
             String nome = request.getParameter("nome");
             String codigo = request.getParameter("codigo");
             String creditos = request.getParameter("creditos");

             
             RequestDispatcher reqDis = request.getRequestDispatcher("index.jsp");
             reqDis.forward(request,response); 
         } catch (Exception ex) {
             Logger.getLogger(CadastrarUsuarioComando.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
}

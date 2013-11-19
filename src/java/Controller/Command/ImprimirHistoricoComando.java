
package Controller.Command;

import Model.Logic.Aluno;
import Model.Logic.HistoricoEscolar;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ImprimirHistoricoComando implements Comando {
     public void executar(HttpServletRequest request, HttpServletResponse response){
         try {
             HttpSession session = request.getSession();
             
             Aluno oAluno = (Aluno) session.getAttribute("usuario");
             HistoricoEscolar novoHistorico = oAluno.getHistorico();
             
             session.setAttribute("historico", novoHistorico);
             
             RequestDispatcher reqDis= request.getRequestDispatcher("../historicoEscolar.jsp");
             reqDis.forward(request,response);
             
         } catch (IOException ex) {
             Logger.getLogger(ImprimirHistoricoComando.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ServletException ex) {
             Logger.getLogger(ImprimirHistoricoComando.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
}

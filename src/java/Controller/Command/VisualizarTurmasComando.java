package Controller.Command;

import Model.Logic.Professor;
import Model.Logic.Turma;
import Model.Persistence.DAOs.ProfessorDAO;
import Model.Persistence.FactoryDAO;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * Comando para visualizar turmas matriculadas e já cursadas por um aluno
 * @author Rodrigo Zanella Ribeiro
 */
public class VisualizarTurmasComando implements Comando {

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();
            Professor umProfessor = (Professor) session.getAttribute("usuario");
            FactoryDAO factory = new FactoryDAO();
            ProfessorDAO professorDAO = factory.criarProfessorDAO();
            
            String cpfProf = umProfessor.getCpf();
            List<Turma> turmas = professorDAO.getTurmas(cpfProf);
            session.setAttribute("turmas", turmas);
            
            RequestDispatcher reqDis= request.getRequestDispatcher("turmasAnteriores.jsp");
            reqDis.forward(request,response);
        } catch (ServletException ex) {
            Logger.getLogger(VisualizarTurmasComando.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VisualizarTurmasComando.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

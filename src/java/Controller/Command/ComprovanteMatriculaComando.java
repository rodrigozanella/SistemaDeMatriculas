package Controller.Command;

import Model.Logic.Aluno;
import Model.Logic.Turma;
import Model.Persistence.DAOs.SistemaDAO;
import Model.Persistence.DAOs.TurmaDAO;
import Model.Persistence.FactoryDAO;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ComprovanteMatriculaComando
 * Obtém oa turmas nas quais o aluno está matriculado no semestre atual
 * @author Tiago Covolan
 */
public class ComprovanteMatriculaComando implements Comando{
    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response){
        try {
            //Obtém uma instância do usuário logado
            HttpSession session = request.getSession();
            Aluno aluno = (Aluno)session.getAttribute("usuario");
            
            //Obtém o semestre atual
            FactoryDAO factoryDAO = new FactoryDAO();
            SistemaDAO sistemaDAO = factoryDAO.criarSistemaDAO();
            String semestre = sistemaDAO.getSemestre();
            
            //Obtém as turmas sendo cursadas pelo aluno
            TurmaDAO turmaDAO = factoryDAO.criarTurmaDAO();
            Set<Turma> turmasMatriculadas = turmaDAO.getTurmasMatriculadas(aluno, semestre);
            
            //Associa os lances ao usuário logado
            aluno.setTurmasMatriculadas(turmasMatriculadas);
            session.setAttribute("usuario", aluno);

            //Redireciona usuário a página de resultado de encomenda
            RequestDispatcher reqDis= request.getRequestDispatcher("comprovanteMatricula.jsp");       
            reqDis.forward(request,response);
        } catch (Exception ex) {
            Logger.getLogger(PossibilidadeMatriculaComando.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
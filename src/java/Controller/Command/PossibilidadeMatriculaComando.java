package Controller.Command;

import Model.Logic.Aluno;
import Model.Logic.Turma;
import Model.Persistence.FactoryDAO;
import Model.Persistence.SistemaDAO;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * PossibilidadeMatriculaComando
 * Gera as possibilidades de matrículas de um usuário
 * @author Rodrigo Zanella Ribeiro
 */
public class PossibilidadeMatriculaComando implements Comando {
    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response){
        try {
            HttpSession session = request.getSession();
            
            FactoryDAO novoFactoryDAO = new FactoryDAO();
            SistemaDAO novoSistemaDAO = novoFactoryDAO.criarSistemaDAO();
            String semestre = novoSistemaDAO.getSemestre();
            
            Aluno aluno =(Aluno) session.getAttribute("usuario");
            Set<Turma> possibilidades = aluno.getPossibilidadesDeMatricula(semestre);
            aluno.setPossibilidadesMatricula(possibilidades);
            
            session.setAttribute("usuario", aluno);
            
            RequestDispatcher reqDis= request.getRequestDispatcher("possibilidadesMatricula.jsp");       
            reqDis.forward(request,response);
        } catch (Exception ex) {
            Logger.getLogger(PossibilidadeMatriculaComando.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

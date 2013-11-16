package Controller.Command;

import Model.Logic.Aluno;
import Model.Persistence.FactoryDAO;
import Model.Persistence.SistemaDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * PossibilidadeMatriculaComando
 * Gera as possibilidades de matrículas de um usuário
 * @author Rodrigo Zanella Ribeiro
 */
public class PossibilidadeMatriculaComando implements Comando {
    public void executar(HttpServletRequest request, HttpServletResponse response){
        try {
            HttpSession session = request.getSession();
            
            FactoryDAO novoFactoryDAO = new FactoryDAO();
            SistemaDAO novoSistemaDAO = novoFactoryDAO.criarSistemaDAO();
            String semestre = novoSistemaDAO.getSemestre();
            
            Aluno aluno =(Aluno) session.getAttribute("usuario");
            aluno.getPossibilidadesDeMatricula(semestre);
            
        } catch (Exception ex) {
            Logger.getLogger(PossibilidadeMatriculaComando.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

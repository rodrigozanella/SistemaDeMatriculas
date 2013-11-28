package Controller.Command;

import Model.Logic.Aluno;
import Model.Logic.Lance;
import Model.Persistence.DAOs.LanceDAO;
import Model.Persistence.FactoryDAO;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Obtém os lances de um determinado usuário
 * @author Tiago Covolan
 */
public class ResultadoEncomendaComando implements Comando{
    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response){
        try {
            //Obtém uma instância do usuário logado
            HttpSession session = request.getSession();
            Aluno aluno = (Aluno)session.getAttribute("usuario");
            
            //Obtém os lances do usuário
            FactoryDAO factoryDAO = new FactoryDAO();
            LanceDAO lanceDAO = factoryDAO.criarLanceDAO();
            Set<Lance> lances = lanceDAO.getLances(aluno);
            
            //Associa os lances ao usuário logado
            aluno.setLances(lances);
            session.setAttribute("usuario", aluno);

            //Redireciona usuário a página de resultado de encomenda
            RequestDispatcher reqDis= request.getRequestDispatcher("resultadoEncomenda.jsp");       
            reqDis.forward(request,response);
        } catch (Exception ex) {
            Logger.getLogger(PossibilidadeMatriculaComando.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
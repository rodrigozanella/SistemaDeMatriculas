package Controller.Command;

import Model.Logic.Aluno;
import Model.Logic.Lance;
import Model.Persistence.DAOs.LanceDAO;
import Model.Persistence.FactoryDAO;
import java.util.HashMap;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * EncomendarMatriculaComando
 * Cria uma instância de um lance e o insere no BD.
 * @author Tiago Covolan
 */
public class EncomendarMatriculaComando implements Comando{
    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response){
        try {
            //obtém uma tabela com os valores de lances inseridos
            HashMap<Integer, Integer> lances = new HashMap<Integer, Integer>();;
            Set<String> parameterNames = request.getParameterMap().keySet();
            int totalPontos = 0;
            for(String parameter : parameterNames){
                if(parameter.charAt(0) != 'l') continue;
                String input = request.getParameter(parameter);
                if(input.length() == 0) continue;
                lances.put(Integer.parseInt(parameter.substring(1)), Integer.parseInt(input));
                totalPontos += Integer.parseInt(input);
            }

            //Obtém uma instância do usuário logado
            HttpSession session = request.getSession();
            Aluno aluno = (Aluno)session.getAttribute("usuario");
            
            if(aluno.getPontuacao() >= totalPontos){
                //Insere os lances no BD
                FactoryDAO factoryDAO = new FactoryDAO();
                LanceDAO lanceDAO = factoryDAO.criarLanceDAO();
                for(Integer codigoTurma : lances.keySet()){
                    Lance lance = new Lance(codigoTurma, aluno.getCpf(), lances.get(codigoTurma), "pendente");
                    if(!lanceDAO.adicionaLance(lance)){
                        //lance não pode ser inserido
                        //trata o erro
                    }else{
                        //lance inserido
                    }
                }
            }
            
            RequestDispatcher reqDis= request.getRequestDispatcher("index.jsp");       
            reqDis.forward(request,response);
        } catch (Exception ex) {
            Logger.getLogger(PossibilidadeMatriculaComando.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

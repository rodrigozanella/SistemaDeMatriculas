
package Controller.Command;

import Model.Logic.Disciplina;
import Model.Persistence.DAOs.DisciplinaDAO;
import Model.Persistence.FactoryDAO;
import Model.Validation.DisciplinaValidador;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Comando para cadastrar uma disciplina
 * @author Tiago Covolan
 */
public class CadastrarDisciplinaComando implements Comando{
    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response){
         try {
             //obtém os atributos da disciplina do formulário
             String nome = request.getParameter("nome");
             String codigo = request.getParameter("codigo");
             int creditos = Integer.parseInt(request.getParameter("creditos"));
             boolean ehEletiva = request.getParameter("tipo").equalsIgnoreCase("eletiva");
             int creditosMnimos = Integer.parseInt(request.getParameter("creditos_minimos"));
             
             //obtém uma lista com os pré-requisitos
             String[] preRequisitos = request.getParameterValues("prerequisitos");
             ArrayList<String> requisitos = new ArrayList<String>();
             if(preRequisitos != null){
                 requisitos.addAll(Arrays.asList(preRequisitos));
             }
             
             //valida a disciplina
             Disciplina novaDisciplina = new Disciplina(codigo, nome, creditos, ehEletiva, creditosMnimos, requisitos);
             DisciplinaValidador disciplinaValidador = new DisciplinaValidador();
             disciplinaValidador.setDisciplina(novaDisciplina);
             if(disciplinaValidador.validaTudo()){
                 //insere a disciplina no BD
                 FactoryDAO factoryDAO = new FactoryDAO();
                 DisciplinaDAO disciplinaDAO = factoryDAO.criarDisciplinaDAO();
                 disciplinaDAO.adicionarDisciplina(novaDisciplina);
             }
             
             RequestDispatcher reqDis = request.getRequestDispatcher("index.jsp");
             reqDis.forward(request,response); 
         } catch (Exception ex) {
             Logger.getLogger(CadastrarUsuarioComando.class.getName()).log(Level.SEVERE, null, ex);
         }
     }

}

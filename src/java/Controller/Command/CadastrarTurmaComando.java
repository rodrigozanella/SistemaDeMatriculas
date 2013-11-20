
package Controller.Command;

import Model.Logic.Turma;
import Model.Persistence.FactoryDAO;
import Model.Persistence.TurmaDAO;
import Model.Validation.Validador;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CadastrarTurmaComando implements Comando{
    @Override
     public void executar(HttpServletRequest request, HttpServletResponse response){
        try {
            //obtém os atributos da turma do formulário
            String cpfProfessor = request.getParameter("professor");
            int vagas = Integer.parseInt(request.getParameter("vagas"));
            String semestre = request.getParameter("semestre");
            String codigoDisciplina = request.getParameter("disciplina");
            String horario = request.getParameter("horario");
             
            //obtém o código da turma. Se for a primeira do semestre recebe o código 'U',
            //se for a segunda recebe 'A', terceira recebe 'B' e assim por diante
            int codigo = (int)'U';
            FactoryDAO factoryDAO = new FactoryDAO();
            TurmaDAO turmaDAO = factoryDAO.criarTurmaDAO();
            Set<Turma> turmas = turmaDAO.getTurmasSemestre(codigoDisciplina, semestre);
            if(turmas.size() > 0) codigo = (int)'A' + turmas.size() - 1;

            //valida a turma
            Turma novaTurma = new Turma(codigo, codigoDisciplina, horario, semestre, vagas, cpfProfessor);
            Validador validador = new Validador();
            if(validador.validaTurma(novaTurma)){
                 
                //insere a turma no BD
                turmaDAO.adicionaTurma(novaTurma);
            }
             
            RequestDispatcher reqDis = request.getRequestDispatcher("index.jsp");
            reqDis.forward(request,response); 
        } catch (Exception ex) {
            Logger.getLogger(CadastrarUsuarioComando.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

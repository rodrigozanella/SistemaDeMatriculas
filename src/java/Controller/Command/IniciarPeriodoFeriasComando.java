package Controller.Command;

import Model.Logic.Aluno;
import Model.Persistence.DAOs.AlunoDAO;
import Model.Persistence.DAOs.SistemaDAO;
import Model.Persistence.FactoryDAO;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Comando para iniciar o periodo de férias no sistema
 * @author Rodrigo Zanella Ribeiro
 */
public class IniciarPeriodoFeriasComando implements Comando{

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) {  
        try {
            FactoryDAO factory = new FactoryDAO();
            SistemaDAO sistemaDAO = factory.criarSistemaDAO();
            String estadoAtual = sistemaDAO.getEstado();
            if(estadoAtual.equalsIgnoreCase("letivo")){
                AlunoDAO alunoDAO = factory.criarAlunoDAO();
                if(sistemaDAO.setEstado("ferias")){
                    //expulsa alunos com 10 ou mais FF
                    Set<Aluno> alunosIrregulares = alunoDAO.getAlunosIrregulares();
                    Iterator<Aluno> itAlunosIr = alunosIrregulares.iterator();
                    while(itAlunosIr.hasNext()){
                        Aluno aluno = itAlunosIr.next();
                        alunoDAO.expulsarAluno(aluno);
                    }
                    //expulsa alunos com 10 ou mais anos de curso
                    Set<Aluno> alunos = alunoDAO.getAlunos();
                    Iterator<Aluno> itAlunos = alunos.iterator();
                    while(itAlunos.hasNext()){
                        Aluno novoAluno = itAlunos.next();
                        if(novoAluno.getSerializacao(sistemaDAO.getSemestre())>=10){
                            alunoDAO.expulsarAluno(novoAluno);
                        }
                    }
                    //gradua alunos que completaram os creditos obrigatorios e eletivos
                }
            }
            RequestDispatcher reqDis= request.getRequestDispatcher("index.jsp");      
            reqDis.forward(request,response);
        } catch (ServletException ex) {
            Logger.getLogger(IniciarPeriodoFeriasComando.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(IniciarPeriodoFeriasComando.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

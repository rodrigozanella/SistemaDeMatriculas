/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Command;

import Model.Logic.Aluno;
import Model.Persistence.DAOs.AlunoDAO;
import Model.Persistence.DAOs.SistemaDAO;
import Model.Persistence.DAOs.TurmaDAO;
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
 *
 * @author Zanella
 */
public class IniciarPeriodoEncomendaComando implements Comando{

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) {
        try {
            FactoryDAO factory = new FactoryDAO();
            SistemaDAO sistemaDAO = factory.criarSistemaDAO();
            TurmaDAO turmaDAO = factory.criarTurmaDAO();
            AlunoDAO alunoDAO = factory.criarAlunoDAO();
            String estadoAtual = sistemaDAO.getEstado();
            if(estadoAtual.equalsIgnoreCase("ferias")){
                if(turmaDAO.existeTurmas(sistemaDAO.getSemestre())){
                    if(sistemaDAO.setEstado("matricula")){
                        //calcula pontos de ordenamento dos alunos
                        Set<Aluno> alunos = alunoDAO.getAlunos();
                        Iterator<Aluno> itAluno = alunos.iterator();
                        while(itAluno.hasNext()){
                            Aluno aluno = itAluno.next();
                            int pontucao = aluno.pontuacaoSemestre();
                            alunoDAO.atualizaPontuacao(aluno, pontucao);
                        }
                    }
                }
            }      
            RequestDispatcher reqDis= request.getRequestDispatcher("index.jsp");      
            reqDis.forward(request,response);
        } catch (ServletException ex) {
            Logger.getLogger(IniciarPeriodoEncomendaComando.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(IniciarPeriodoEncomendaComando.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

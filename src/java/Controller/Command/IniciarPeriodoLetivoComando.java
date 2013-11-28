
package Controller.Command;

import Model.Logic.Aluno;
import Model.Logic.Lance;
import Model.Logic.Turma;
import Model.Persistence.DAOs.LanceDAO;
import Model.Persistence.DAOs.SistemaDAO;
import Model.Persistence.DAOs.TurmaDAO;
import Model.Persistence.DAOs.UsuarioDAO;
import Model.Persistence.FactoryDAO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Inicia o periodo letivo no sistema
 * @author Rodrigo Zanella Ribeiro
 * @version 1.0
 * Modificações:
 * Adicionando funcionalidade de matricular alunos nas cadeiras
 * @author Tiago Covolan
 * @version 2.0
 */
public class IniciarPeriodoLetivoComando implements Comando{

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) {
        try {
            FactoryDAO factory = new FactoryDAO();
            SistemaDAO sistemaDAO = factory.criarSistemaDAO();
            String estadoAtual = sistemaDAO.getEstado();
            
            //o sistema deve estar em matrícula
            if(estadoAtual.equalsIgnoreCase("matricula")){
                if(sistemaDAO.setEstado("letivo")){

                    
                    //Obtém todas turmas disponíveis para o semestre
                    String semestre = sistemaDAO.getSemestre();
                    TurmaDAO turmaDAO = factory.criarTurmaDAO();
                    Set<Turma> turmasDisponiveis = turmaDAO.getTurmasSemestre(semestre);

                    //Para cada turma disponivel, obtém seus lances
                    LanceDAO lanceDAO = factory.criarLanceDAO();
                    for(Turma turma : turmasDisponiveis){
                        ArrayList<Lance> lances = new ArrayList<Lance>(lanceDAO.getLances(turma));
                        Collections.sort(lances, new Comparator() {  
                            @Override
                            public int compare(Object o1, Object o2) {  
                                Lance l1 = (Lance)o1;  
                                Lance l2 = (Lance)o2;  
                                return l1.getValor() < l2.getValor() ? -1 : (l1.getValor() > l2.getValor() ? +1 : 0);  
                            }  
                        }); 

                        //Seleciona os x primeiros alunos, onde x é o número de vagas
                        int contador = 0;
                        UsuarioDAO usuarioDAO = factory.criarUsuarioDAO();
                        for(Lance lance : lances){
                            if(contador >= turma.getNumeroDeVagas()){
                                lance.setSituacao("recusado");
                                lanceDAO.atualizaLance(lance);
                            }
                            //Matricula o aluno
                            Aluno aluno = (Aluno)usuarioDAO.getUsuario(lance.getCpfAluno());
                            turmaDAO.matriculaAluno(turma, aluno);
                            lance.setSituacao("aceito");
                            lanceDAO.atualizaLance(lance);

                            contador++;
                        }
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

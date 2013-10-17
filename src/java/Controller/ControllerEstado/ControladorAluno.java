/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.ControllerEstado;

import Model.Logic.Aluno;
import Model.Logic.Turma;
import Model.Persistence.OperadorBD;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.ControllerEstado.ControladorUsuario;
import Model.Logic.HistoricoEscolar;

/**
 * @author Rodrigo Zanella Ribeiro
 * @since 12/10/2013
 * 
 * Classe controladora das ações de um usuário aluno
 */
public class ControladorAluno extends ControladorUsuario {
    /**
     * Métodos do controlador
     */
    
    /**
     * @author Rodrigo Zanella Ribeiro
     * @since 12/10/2013
     * 
     * Método para visualizar as possibilidades de matrícula
     * @param request Dados da requisição ao servlet
     * @param response Dados da resposta do servlet
     */
    public void possibilidadeMatricula(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        try {
            Aluno umAluno = OperadorBD.obtemAluno(ControladorUsuario.nomeUsuarioLogado, ControladorUsuario.senhaUsuarioLogado);
            //Aluno umAluno = OperadorBD.obtemAluno(session.getAttribute("nome").toString(), session.getAttribute("senha").toString());
            List<Turma> umaPossib = umAluno.getPossibilidadesDeMatricula("2013/2");
            getServletContext().setAttribute("lista", umaPossib);
            response.sendRedirect("possibilidadesMatricula.jsp");
        } catch (Exception ex) {
            Logger.getLogger(ControladorAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * @author Rodrigo Zanella Ribeiro
     * @since 12/10/2013
     * 
     * Método para imprimir histórico escolar
     * @param request Dados da requisição ao servlet
     * @param response Dados da resposta do servlet
     */
    public void imprimirHistorico(HttpServletRequest request, HttpServletResponse response){
        try {
            Aluno umAluno = OperadorBD.obtemAluno(ControladorUsuario.nomeUsuarioLogado, ControladorUsuario.senhaUsuarioLogado);
            HistoricoEscolar historico = umAluno.getHistorico();
            getServletContext().setAttribute("historico", historico);
            response.sendRedirect("historicoEscolar.jsp");
        } catch (Exception ex) {
            Logger.getLogger(ControladorAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * @author Rodrigo Zanella Ribeiro
     * @since 12/10/2013
     * 
     * Método para visualizar o resultado de encomenda
     * @param request Dados da requisição ao servlet
     * @param response Dados da resposta do servlet
     */
    public void resultadoEncomenda(HttpServletRequest request, HttpServletResponse response){
        
    }
    
}

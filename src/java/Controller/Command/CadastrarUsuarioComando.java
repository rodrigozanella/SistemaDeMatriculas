
package Controller.Command;

import Model.Logic.Administrador;
import Model.Logic.Aluno;
import Model.Logic.Professor;
import Model.Logic.Usuario;
import Model.Persistence.FactoryDAO;
import Model.Persistence.DAOs.UsuarioDAO;
import Model.Validation.Validador;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Tiago
 */
public class CadastrarUsuarioComando implements Comando{
    @Override
     public void executar(HttpServletRequest request, HttpServletResponse response){
         try {
             String tipo = request.getParameter("tipo");
             String nome = request.getParameter("nome");
             String email = request.getParameter("email");
             String cpf = request.getParameter("cpf");
             String nascimento = request.getParameter("nascimento");
             String username = request.getParameter("username");
             String senha = request.getParameter("senha");
             DateFormat formatter = new SimpleDateFormat("YYYY-MM-DD"); 
             Date dataNascimento = (Date)formatter.parse(nascimento);
             
             
             Usuario novoUsuario = new Usuario(nome, cpf, username, senha, email, dataNascimento);
             novoUsuario.setRole(tipo);
             
             HttpSession session = request.getSession();
             session.setAttribute("tipo", tipo);
             session.setAttribute("novoUsuario", novoUsuario);
             
             RequestDispatcher reqDis = request.getRequestDispatcher("cadastroUsuario.jsp");
             reqDis.forward(request,response); 
         } catch (Exception ex) {
             Logger.getLogger(CadastrarUsuarioComando.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
}

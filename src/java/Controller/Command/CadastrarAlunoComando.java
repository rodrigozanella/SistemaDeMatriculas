package Controller.Command;

import Model.Logic.Aluno;
import Model.Logic.Usuario;
import Model.Persistence.DAOs.AlunoDAO;
import Model.Persistence.DAOs.UsuarioDAO;
import Model.Persistence.FactoryDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Comando para cadastrar um aluno
 * @author Rodrigo Zanella Ribeiro
 */
public class CadastrarAlunoComando implements Comando{

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) {
        try {
            String metodo = request.getParameter("metodo");
            String pontuacao = request.getParameter("vestibular");
            String semestre = request.getParameter("semestre");
            String matricula = request.getParameter("matricula");
            HttpSession session = request.getSession();
            Usuario usuario =(Usuario) session.getAttribute("novoUsuario");
            session.removeAttribute("novoUsuario");
            Aluno aluno = new Aluno (usuario.getNome(), usuario.getCpf(), 
                    usuario.getNomeDeUsuario(), usuario.getSenha(), usuario.getEmail(), 
                    usuario.getDataDeNascimento(), metodo, Integer.valueOf(pontuacao) , 
                    semestre, Integer.valueOf(matricula));
            
            FactoryDAO factory = new FactoryDAO();
            UsuarioDAO usuarioDAO = factory.criarUsuarioDAO();
            AlunoDAO alunoDAO = factory.criarAlunoDAO();
            
            if(usuarioDAO.adicionarUsuario(usuario)){
                alunoDAO.adicionarAluno(aluno);
            }
            
            RequestDispatcher reqDis= request.getRequestDispatcher("index.jsp");      
            reqDis.forward(request,response);
        } catch (ServletException ex) {
            Logger.getLogger(CadastrarAlunoComando.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CadastrarAlunoComando.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

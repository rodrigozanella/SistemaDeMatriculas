
package Controller.Command;

import Model.Logic.Administrador;
import Model.Logic.Aluno;
import Model.Logic.Professor;
import Model.Persistence.FactoryDAO;
import Model.Persistence.DAOs.UsuarioDAO;
import Model.Validation.Validador;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
  
             FactoryDAO novoFactoryDAO = new FactoryDAO();
             UsuarioDAO novoUsuarioDAO = novoFactoryDAO.criarUsuarioDAO();
             Validador validador = new Validador();
             if(tipo.equalsIgnoreCase("aluno")){
                 String metodoDeIngresso = request.getParameter("metodo");
                 int pontuacaoVestibular = Integer.parseInt(request.getParameter("vestibular"));
                 String semestre = request.getParameter("semestre");
                 int matricula = Integer.parseInt(request.getParameter("matricula"));
                 Aluno novoAluno = new Aluno(nome, cpf, username, senha, email, null, metodoDeIngresso, pontuacaoVestibular, semestre, matricula);
                 if(validador.validaAluno(novoAluno)){
                    novoUsuarioDAO.adicionarUsuario(novoAluno);
                 }
                 
             }else if(tipo.equalsIgnoreCase("professor")){
                 String areaDeInteresse = request.getParameter("interesse");
                 Professor novoProfessor = new Professor(nome, cpf, nome, senha, email, null, areaDeInteresse);
                 if(validador.validaProfessor(novoProfessor)){
                    novoUsuarioDAO.adicionarUsuario(novoProfessor);
                 }
                 
             }else if(tipo.equalsIgnoreCase("administrador")){
                 Administrador novoAdministrador = new Administrador(nome, cpf, nome, senha, email, null);
                 if(validador.validaAdministrador(novoAdministrador)){
                    novoUsuarioDAO.adicionarUsuario(novoAdministrador);
                 }
             }
             
             RequestDispatcher reqDis = request.getRequestDispatcher("index.jsp");
             reqDis.forward(request,response); 
         } catch (Exception ex) {
             Logger.getLogger(CadastrarUsuarioComando.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Rodrigo Zanella Ribeiro
 * @since 12/10/2013
 * 
 * Classe controladora das ações de um usuário aluno
 */
public abstract class ControladorAluno extends ControladorUsuario {
    /**
     * Métodos do controlador
     */
    
    /**
     * @author Rodrigo Zanella Ribeiro
     * @since 12/10/2013
     * 
     * Método para visualizar as possibilidades de matrícula
     */
    public void possibilidadeMatricula(){
        
    }
    
    /**
     * @author Rodrigo Zanella Ribeiro
     * @since 12/10/2013
     * 
     * Método para imprimir histórico escolar
     */
    public void imprimirHistorico(){
        
    }
    
    /**
     * @author Rodrigo Zanella Ribeiro
     * @since 12/10/2013
     * 
     * Método para visualizar o resultado de encomenda
     */
    public void resultadoEncomenda(){
        
    }
}

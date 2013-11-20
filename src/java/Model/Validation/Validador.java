/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Validation;

import Model.Logic.Administrador;
import Model.Logic.Aluno;
import Model.Logic.Disciplina;
import Model.Logic.Professor;
import Model.Logic.Usuario;

/**
 * Todas as operações sobre o banco de dados terão que passar por aqui.
 * Ele verifica se os registros que serão inseridos no BD estão de acordo com
 * o formato definido dos dados
 */
public class Validador {
    
    public boolean validaAluno(Aluno aluno){
        if(!validaUsuario(aluno)) return false;
        
        //if(aluno.getPontuacaoVestibular() < 0 || aluno.getPontuacaoVestibular() > 100) return false;
        //if(aluno.getNumeroDeMatricula() < 0) return false;
        
        return true;
    }
    
    public boolean validaUsuario(Usuario usuario){
        if(usuario.getSenha().length() < 3) return false;
        
        if(!usuario.getRole().equals("aluno")){
            if(!usuario.getRole().equals("professor")){
                if (!usuario.getRole().equals("administrador")) return false;
            }
        }

        return true;
    }
    
    public boolean validaProfessor(Professor professor){
        if(!validaUsuario(professor)) return false;
        
        return true;
    }
    
    public boolean validaAdministrador(Administrador administrador){
        if(!validaUsuario(administrador)) return false;

        return true;
    }
    
    public boolean validaDisciplina(Disciplina disciplina){
        if(disciplina.getNumeroDeCreditos() <= 0) return false;
        if(disciplina.getNumeroDeCreditosMinimos() < 0) return false;
        
        return true;
    }
}

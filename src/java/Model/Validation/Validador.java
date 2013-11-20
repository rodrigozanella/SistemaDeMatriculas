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
import Model.Persistence.DisciplinaDAO;
import Model.Persistence.FactoryDAO;

/**
 * Todas as operações sobre o banco de dados terão que passar por aqui.
 * Ele verifica se os registros que serão inseridos no BD estão de acordo com
 * o formato definido dos dados
 */
public class Validador {
    
    /*
     * Verifica se os dados de um aluno estão corretos.
     */
    public boolean validaAluno(Aluno aluno){
        if(!validaUsuario(aluno)) return false;
        
        if(aluno.getPontuacaoVestibular() < 0 || aluno.getPontuacaoVestibular() > 100) return false;
        if(aluno.getNumeroDeMatricula() < 0) return false;
        
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
    
    /*
     * Verifica se os dados de uma disciplina estão corretos.
     */
    public boolean validaDisciplina(Disciplina disciplina){
        //nome deve ter pelo menos 3 caracteres
        if(disciplina.getNome().length() < 3) return false;
        //código deve ter pelo menos 3 caracteres
        if(disciplina.getCodigo().length() < 3) return false;
        
        //código da disciplina não deve existir no BD
        FactoryDAO factoryDAO = new FactoryDAO();
        DisciplinaDAO disciplinaDAO = factoryDAO.criarDisciplinaDAO();
        if(disciplinaDAO.existeCodigo(disciplina.getCodigo())) return false;
        
        //os códigos dos pré-requisitos devem existir no BD
        for(String preRequisito : disciplina.getPreRequisitos()){
            if(!disciplinaDAO.existeCodigo(preRequisito)) return false;
        }
        
        //o número de créditos deve ser maior que 0
        if(disciplina.getNumeroDeCreditos() <= 0) return false;
        
        //o número de créditos mínimos não deve ser negativo
        if(disciplina.getNumeroDeCreditosMinimos() < 0) return false;
        
        return true;
    }
}

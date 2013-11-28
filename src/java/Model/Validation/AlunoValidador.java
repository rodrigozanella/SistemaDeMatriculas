/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Validation;

import Model.Logic.Aluno;

/**
 *
 * @author Zanella
 */
public class AlunoValidador {
    private Aluno aluno;
    
    public AlunoValidador(){
        aluno = null;
    }
    
    public void setAluno(Aluno novoAluno){
        aluno = novoAluno;
    }
    
    public boolean validaTipoIngresso(){
        return false;
    }
    
    public boolean validaPontuacaoVestibular(){
        return false;
    }
    
    public boolean validaSemestreDeIngresso(){
        return false;
    }
    
    public boolean validaNumeroDeMatricula(){
        return false;
    }
    
    public boolean validaPossibilidadesDeMatriculas(){
        return false;
    }
    
    public boolean validaLances(){
        return false;
    }
    
    public boolean validaTurmasMatriculadas(){
        return false;
    }
    
    public boolean validaPontuacao(){
        return false;
    }
}

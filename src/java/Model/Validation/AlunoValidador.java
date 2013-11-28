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
        return true;
    }
    
    public boolean validaPontuacaoVestibular(){
        return aluno.getPontuacaoVestibular()>=0 &&
                aluno.getPontuacaoVestibular()<=100;
    }
    
    public boolean validaSemestreDeIngresso(){
        return aluno.getSemestreDeIngresso().matches("20[0-9][0-9]/(1|2)");
    }
    
    public boolean validaNumeroDeMatricula(){
        return aluno.getNumeroDeMatricula()>0;
    }
    
    public boolean validaPossibilidadesDeMatriculas(){
        return true;
    }
    
    public boolean validaLances(){
        return true;
    }
    
    public boolean validaTurmasMatriculadas(){
        return true;
    }
    
    public boolean validaPontuacao(){
        return aluno.getPontuacao()>0;
    }
    
    public boolean validaTudo(){
        return this.validaLances() &&
                this.validaNumeroDeMatricula() &&
                this.validaPontuacao() &&
                this.validaPontuacaoVestibular() &&
                this.validaPossibilidadesDeMatriculas() &&
                this.validaSemestreDeIngresso() &&
                this.validaTurmasMatriculadas() &&
                this.validaTipoIngresso();
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Validation;

import Model.Persistence.OperadorBD;
import Model.Logic.Aluno;
import Model.Logic.Disciplina;
import Model.Logic.Turma;

/**
 *
 * @author Tiago
 * Todas as operações sobre o banco de dados terão que passar por aqui.
 * Ele verifica se os registros que serão inseridos no BD estão de acordo com
 * o formato definido dos dados
 */
public class Validador {
    
    /*
     * Para inserir um novo aluno:
     * O semestre de ingresso deve estar no formato "xxxx/x"
     * A pontuação do vestibular é um número inteiro entre 0 e 100
     * A senha deve ter no mínimo 10 caracteres
     */
    public void insereAluno(Aluno novoAluno) throws Exception{
        if(novoAluno.getSemestreDeIngresso().length() != 6){
            throw new Exception();
        }
        if(novoAluno.getPontuacaoVestibular() < 0 || novoAluno.getPontuacaoVestibular() > 100){
            throw new Exception();
        }
        if(novoAluno.getSenha().length() < 10){
            throw new Exception();
        }

        OperadorBD.insereRegistroAluno(novoAluno);
    }
    
    /*
     * Para inserir uma disciplina:
     * O seu código não deve existir no BD
     * O número de créditos deve ser maior que 0
     * O número do semestre recomendado deve ser maior que 0
     * O número de créditos mínimos não deve ser negativo
     * Todos os códigos das disciplinas pré-requisitos devem existir
     */
    public void insereDisciplina(Disciplina novaDisciplina) throws Exception{
        if(OperadorBD.existeDisciplina(novaDisciplina.getCodigo())){
            throw new Exception();
        }
        if(novaDisciplina.getNumeroDeCreditos() <= 0){
            throw new Exception();
        }
        if(novaDisciplina.getSemestreRecomendado() <= 0){
            throw new Exception();
        }
        if(novaDisciplina.getNumeroDeCreditosMinimos() < 0){
            throw new Exception();
        }
        for(String codigoDisciplina : novaDisciplina.getPreRequisitos()){
            if(!OperadorBD.existeDisciplina(codigoDisciplina)){
                throw new Exception();
            }
        }
        
        OperadorBD.insereRegistroDisciplina(novaDisciplina);
    }
    
    /*
     * Para inserir uma nova turma:
     * A disciplina correspondente deve existir
     * O semestre deve estar no formato "xxxx/x"
     * O horário deve estar no formato "xx:xx"
     * O número de vagas deve ser maior que 0
     */
    public void insereTurma(Turma novaTurma) throws Exception{
        if(OperadorBD.existeDisciplina(novaTurma.getDisciplina().getCodigo())){
            throw new Exception();
        }
        if(novaTurma.getSemestre().length() != 6){
            throw new Exception();
        }
        if(novaTurma.getHorario().length() != 5){
            throw new Exception();
        }
        if(novaTurma.getNumeroDeVagas() <= 0){
            throw new Exception();
        }
        
        OperadorBD.insereRegistroTurma(novaTurma);
    }
    
    /*
     * Para obter um aluno:
     * A senha deve possuir mais que 10 caracteres
     */
    public Aluno getAluno(String nomeDeUsuario, String senha) throws Exception{
        if(senha.length() < 10){
            throw new Exception();
        }
        
        return OperadorBD.getAluno(nomeDeUsuario, senha);
    }
}

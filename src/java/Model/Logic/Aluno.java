/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Logic;

import Model.Persistence.OperadorBD;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Tiago
 */
public class Aluno extends Usuario{

    public enum TipoDeIngresso {
        regular,
        convenio,
        ordemJudicial,
        transferenciaInterna,
        transferenciaVoluntaria,
        transferenciaCompulsoria;
    }
    
    private TipoDeIngresso tipoDeIngresso;
    private int pontuacaoVestibular; //entre 0 e 100
    private String semestreDeIngresso; //no formato "20xx/x"
    private int numeroDeMatricula;
    private static List<Turma> possibilidadesMatricula;

    public Aluno(String nome, String cpf, String nomeUsuario, String senha){
        super(nome, cpf, nomeUsuario, senha);
    }
    
    public List<Turma> getPossibilidadesMatricula() {
        return possibilidadesMatricula;
    }

    public void setPossibilidadesMatricula(List<Turma> possibilidadesMatricula) {
        this.possibilidadesMatricula = possibilidadesMatricula;
    }
    
    public ArrayList<Turma> getPossibilidadesDeMatricula(String semestreAtual) throws Exception{
        ArrayList<String> possibilidadesDisciplinas = new ArrayList<String>();
        ArrayList<Turma> possibilidadesTurmas = new ArrayList<Turma>();
        
        //Algoritmo:
        //B <- vazio
        //C <- Disciplinas cursadas
        //D <- Disciplinas não cursadas
        //Para cada disciplina d de D
        //  E <- Pré-requisitos de d
        //  Se todas disciplinas em E estão em C então
        //      insere d em B
        //  Senão
        //      pula para a próxima disciplina
        //B contém as possibilidades de matrícula
        
        try{
            ArrayList<String> disciplinasCursadas = OperadorBD.obtemDisciplinasCursadas(this);
            ArrayList<String> disciplinasNaoCursadas = OperadorBD.obtemDisciplinasNaoCursadas(this);
            for(String disciplinaNaoCursada : disciplinasNaoCursadas){
                ArrayList<String> preRequisitos = OperadorBD.obtemPreRequisitos(disciplinaNaoCursada);
                if(disciplinasCursadas.containsAll(preRequisitos)){
                    possibilidadesDisciplinas.add(disciplinaNaoCursada);
                }
            }
            
            for(String possibilidadeDisciplina : possibilidadesDisciplinas){
                possibilidadesTurmas.addAll(OperadorBD.obtemTurmasDeDisciplina(possibilidadeDisciplina, semestreAtual));
            }
            
        } catch(Exception e){
            throw new Exception();
        }
        
        
        return possibilidadesTurmas;
    }
    
    public HistoricoEscolar getHistorico() throws Exception{
        HistoricoEscolar historico;
        try{
            historico = OperadorBD.obtemHistóricoEscolar(this);
        } catch(Exception e){
            throw new Exception();
        }
        
        return historico;
    }

    public void setTipoDeIngresso(TipoDeIngresso tipoDeIngresso) {
        this.tipoDeIngresso = tipoDeIngresso;
    }

    public void setPontuacaoVestibular(int pontuacaoVestibular) {
        this.pontuacaoVestibular = pontuacaoVestibular;
    }

    public void setSemestreDeIngresso(String semestreDeIngresso) {
        this.semestreDeIngresso = semestreDeIngresso;
    }

    public void setNumeroDeMatricula(int numeroDeMatricula) {
        this.numeroDeMatricula = numeroDeMatricula;
    }

    public TipoDeIngresso getTipoDeIngresso() {
        return tipoDeIngresso;
    }

    public int getPontuacaoVestibular() {
        return pontuacaoVestibular;
    }

    public String getSemestreDeIngresso() {
        return semestreDeIngresso;
    }

    public int getNumeroDeMatricula() {
        return numeroDeMatricula;
    }
}

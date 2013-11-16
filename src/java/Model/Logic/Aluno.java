/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Logic;

import Model.Persistence.DisciplinaDAO;
import Model.Persistence.FactoryDAO;
import Model.Persistence.HistoricoDAO;
import Model.Persistence.TurmaDAO;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


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
    private static Set<Turma> possibilidadesMatricula;

    public Aluno(String nome, String cpf, String nomeUsuario, String senha){
        super(nome, cpf, nomeUsuario, senha);
        this.setRole("aluno");
    }
    
    public Set<Turma> getPossibilidadesMatricula() {
        return possibilidadesMatricula;
    }

    public void setPossibilidadesMatricula(Set<Turma> possibilidadesMatricula) {
        this.possibilidadesMatricula = possibilidadesMatricula;
    }
    
    public Set<Turma> getPossibilidadesDeMatricula(String semestreAtual){
        Set<Disciplina> possibilidadesDisciplinas = new HashSet<Disciplina>();
        Set<Turma> possibilidadesTurmas = new HashSet<Turma>();
        FactoryDAO novoFactory = new FactoryDAO();
        HistoricoDAO historicoDAO = novoFactory.criarHistoricoDAO();
        DisciplinaDAO disciplinaDAO = novoFactory.criarDisciplinaDAO();
          
        Set<Disciplina> disciplinasCursadas = historicoDAO.getDisciplinasCursadas(this);
        Set<Disciplina> disciplinasNaoCursadas = historicoDAO.getDisciplinasNaoCursadas(this);
        for(Disciplina disciplinaNaoCursada : disciplinasNaoCursadas){
            Set<Disciplina> preRequisitos = disciplinaDAO.getPreRequisitos(disciplinaNaoCursada);
            boolean nAchou = true;
            for(Disciplina preRequisito : preRequisitos){
                String codigo = preRequisito.getCodigo();
                nAchou = true;
                Iterator<Disciplina> itDiscCurs = disciplinasCursadas.iterator();
                while(nAchou && itDiscCurs.hasNext()){
                if(itDiscCurs.next().getCodigo().equalsIgnoreCase(codigo)){
                    nAchou = false;
                    break;
                }
                }
                if(nAchou){
                    break;
                }
           }
           if(!nAchou){
               possibilidadesDisciplinas.add(disciplinaNaoCursada);
           }
        }
        TurmaDAO turmaDAO = novoFactory.criarTurmaDAO();
        Iterator<Disciplina> itPossibilidades = possibilidadesDisciplinas.iterator();
        while(itPossibilidades.hasNext()){
            possibilidadesTurmas.addAll(turmaDAO.getTurmasSemestre(itPossibilidades.next().getCodigo(), semestreAtual));
        }
        return possibilidadesTurmas;
    }
    
    public HistoricoEscolar getHistorico(){
        HistoricoEscolar historico;
        FactoryDAO novaFactoryDAO = new FactoryDAO();
        HistoricoDAO novoHistoricoDAO = novaFactoryDAO.criarHistoricoDAO();
        historico = novoHistoricoDAO.getHistorico(this);
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

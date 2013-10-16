/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Logic;


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
    private String senha;
    private HistoricoEscolar historico;

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

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setHistorico(HistoricoEscolar historico) {
        this.historico = historico;
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

    public String getSenha() {
        return senha;
    }

    public HistoricoEscolar getHistorico() {
        return historico;
    }
}

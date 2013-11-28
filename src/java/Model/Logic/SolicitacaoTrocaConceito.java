/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Logic;

import java.util.Date;

/**
 * Representa uma solicitação de troca de conceito que o professor pode fazer
 * para um aluno, requer autorização de um administrador
 * @author Tiago Covolan
 */
public class SolicitacaoTrocaConceito {
    private Date dataDeSolicitacao;
    private String nomeProfessor;
    private Turma turma;
    private char conceitoAntigo;
    private char conceitoNovo;

    public void setDataDeSolicitacao(Date dataDeSolicitacao) {
        this.dataDeSolicitacao = dataDeSolicitacao;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public void setConceitoAntigo(char conceitoAntigo) {
        this.conceitoAntigo = conceitoAntigo;
    }

    public void setConceitoNovo(char conceitoNovo) {
        this.conceitoNovo = conceitoNovo;
    }

    public Date getDataDeSolicitacao() {
        return dataDeSolicitacao;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public Turma getTurma() {
        return turma;
    }

    public char getConceitoAntigo() {
        return conceitoAntigo;
    }

    public char getConceitoNovo() {
        return conceitoNovo;
    }
}

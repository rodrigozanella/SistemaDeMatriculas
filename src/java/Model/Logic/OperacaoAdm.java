/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Logic;

import java.util.Date;

/**
 *
 */
public class OperacaoAdm {
    
    public enum TipoDeOperacao {
        trocaDeEstadoDoSistema,
        CadastroDeUsuario,
        CadastroDeDisciplina,
        CadastroDeTurma,
        SolicitacaoDeTrocaDeConceito,
        ExpulsamentoDeUsuario;
    }
    
    private Date dataDeExecucao;
    private TipoDeOperacao tipoDeOperacao;

    public void setDataDeExecucao(Date dataDeExecucao) {
        this.dataDeExecucao = dataDeExecucao;
    }

    public void setTipoDeOperacao(TipoDeOperacao tipoDeOperacao) {
        this.tipoDeOperacao = tipoDeOperacao;
    }

    public Date getDataDeExecucao() {
        return dataDeExecucao;
    }

    public TipoDeOperacao getTipoDeOperacao() {
        return tipoDeOperacao;
    }
}

package Model.Logic;

import java.util.Date;

/**
 * Representa uma operação do administrador, que é qualquer ação que o
 * administrador faz, que será gravada em um log
 * @author Tiago Covolan
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

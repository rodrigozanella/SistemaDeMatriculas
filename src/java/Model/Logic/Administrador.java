/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Logic;

import java.util.ArrayList;

/**
 *
 * @author Tiago
 */
public class Administrador extends Usuario {        
    private String nomeDeUsuario;
    private String senha;
    private ArrayList<OperacaoAdm> historicoDeOperacoes;

    public void setNomeDeUsuario(String nomeDeUsuario) {
        this.nomeDeUsuario = nomeDeUsuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void adicionaOperacao(OperacaoAdm operacao) {
        historicoDeOperacoes.add(operacao);
    }

    public String getNomeDeUsuario() {
        return nomeDeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public ArrayList<OperacaoAdm> getHistoricoDeOperacoes() {
        return historicoDeOperacoes;
    }
}

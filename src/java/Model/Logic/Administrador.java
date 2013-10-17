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
    private ArrayList<OperacaoAdm> historicoDeOperacoes;

    public Administrador(String nome, String cpf, String nomeUsuario, String senha){
        super(nome, cpf, nomeUsuario, senha);
    }
    
    public void adicionaOperacao(OperacaoAdm operacao) {
        historicoDeOperacoes.add(operacao);
    }

    public ArrayList<OperacaoAdm> getHistoricoDeOperacoes() {
        return historicoDeOperacoes;
    }
}

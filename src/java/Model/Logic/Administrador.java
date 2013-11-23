/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Logic;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Tiago
 */
public class Administrador extends Usuario {        
    private ArrayList<OperacaoAdm> historicoDeOperacoes;

    public Administrador(String nome, String cpf, String nomeUsuario, String senha, String email, Date dataDeNascimento){
        super(nome, cpf, nomeUsuario, senha, email, dataDeNascimento);
        this.setRole("administrador");
    }
    
    public void adicionaOperacao(OperacaoAdm operacao) {
        historicoDeOperacoes.add(operacao);
    }

    public ArrayList<OperacaoAdm> getHistoricoDeOperacoes() {
        return historicoDeOperacoes;
    }
}

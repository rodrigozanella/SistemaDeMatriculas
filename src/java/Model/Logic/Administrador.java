package Model.Logic;

import java.util.ArrayList;
import java.util.Date;

/**
 * Classe que representa um administrador no sistema
 * @author Tiago Covolan
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

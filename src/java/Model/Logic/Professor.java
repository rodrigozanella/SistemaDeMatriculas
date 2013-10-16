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
public class Professor extends Usuario{
    private String areaDeInteresse;
    private String nomeDeUsuario;
    private String senha; //a senha tem as mesmas restricoes que as senhas dos alunos
    private ArrayList<Turma> turmasLecionadas; //turmas nas quais o professor lecionou

    public void setAreaDeInteresse(String areaDeInteresse) {
        this.areaDeInteresse = areaDeInteresse;
    }

    public void setNomeDeUsuario(String nomeDeUsuario) {
        this.nomeDeUsuario = nomeDeUsuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void adicionaTurmaLecionada(Turma turma) {
        turmasLecionadas.add(turma);
    }

    public String getAreaDeInteresse() {
        return areaDeInteresse;
    }

    public String getNomeDeUsuario() {
        return nomeDeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public ArrayList<Turma> getTurmasLecionadas() {
        return turmasLecionadas;
    }
}

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
    private ArrayList<Turma> turmasLecionadas; //turmas nas quais o professor lecionou
    
    public Professor(String nome, String cpf, String nomeUsuario, String senha, String areaDeInteresse){
        super(nome, cpf, nomeUsuario, senha);
        this.areaDeInteresse = areaDeInteresse;
        this.setRole("professor");
    }

    public void setAreaDeInteresse(String areaDeInteresse) {
        this.areaDeInteresse = areaDeInteresse;
    }

    public void adicionaTurmaLecionada(Turma turma) {
        turmasLecionadas.add(turma);
    }

    public String getAreaDeInteresse() {
        return areaDeInteresse;
    }

    public ArrayList<Turma> getTurmasLecionadas() {
        return turmasLecionadas;
    }
}

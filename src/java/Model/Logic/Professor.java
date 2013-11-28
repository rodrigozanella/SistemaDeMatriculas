package Model.Logic;

import java.util.ArrayList;
import java.util.Date;

/**
 * A classe que representa um professor
 * @author Tiago Covolan
 */
public class Professor extends Usuario{
    private String areaDeInteresse;
    private ArrayList<Turma> turmasLecionadas; //turmas nas quais o professor lecionou
    
    public Professor(String nome, String cpf, String nomeUsuario, String senha, String email, Date dataDeNascimento, String areaDeInteresse){
        super(nome, cpf, nomeUsuario, senha, email, dataDeNascimento);
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

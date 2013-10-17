/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Logic;


/**
 *
 * @author Tiago
 */
public class Turma {
    private Disciplina disciplina;
    private char codigo; //'A', 'B', etc...
    private String semestre; //no formato "20xx/x"
    private String horario; //no formato "13:30"
    private String nomeProfessor;
    private int numeroDeVagas;

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public void setCodigo(char codigo) {
        this.codigo = codigo;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public void setNumeroDeVagas(int numeroDeVagas) {
        this.numeroDeVagas = numeroDeVagas;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public char getCodigo() {
        return codigo;
    }

    public String getSemestre() {
        return semestre;
    }

    public String getHorario() {
        return horario;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public int getNumeroDeVagas() {
        return numeroDeVagas;
    }
}


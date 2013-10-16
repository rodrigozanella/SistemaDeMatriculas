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
public class Turma {
    private Disciplina disciplina;
    private char codigo; //'A', 'B', etc...
    private String semestre; //no formato "20xx/x"
    private ArrayList<Integer> alunosMatriculados; //contém número de matrícula de todos os alunos matrículados
    private String horario; //no formato "13:30"
    private String nomeProfessor;
    private int numeroDeVagas;
    
    public void matriculaAluno(int numeroDeMatricula) {
        alunosMatriculados.add(numeroDeMatricula);
    }

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
    
    public ArrayList<Integer> getAlunosMatriculados() {
        return alunosMatriculados;
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


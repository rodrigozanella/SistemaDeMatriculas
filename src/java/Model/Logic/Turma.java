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
    private String codigoDisciplina;
    private char codigo; //'A', 'B', etc...
    private String semestre; //no formato "20xx/x"
    private String horario; //no formato "13:30"
    private String nomeProfessor;
    private int numeroDeVagas;

    public Turma(String codigoDisciplina, char codigo, String semestre, int vagas){
        this.codigoDisciplina = codigoDisciplina;
        this.codigo = codigo;
        this.semestre = semestre;
        this.numeroDeVagas = vagas;
    }
    
    public void setCodigoDisciplina(String codigoDisciplina) {
        this.codigoDisciplina = codigoDisciplina;
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

    public String getCodigoDisciplina() {
        return codigoDisciplina;
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


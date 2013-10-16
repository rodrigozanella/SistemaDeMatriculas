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
public class Disciplina {
    private String nome;
    private String codigo; //o código é alfanumérico
    private int numeroDeCreditos;
    private int semestreRecomendado; //número do semestre no qual a disciplina é recomendada (estranho isso, pois podem haver mais cursos)
    private boolean eletiva; //indica se a disciplina é eletiva ou não
    private int numeroDeCreditosMinimos; //indica o número de créditos necessários para cursar esta disciplina
    private ArrayList<String> preRequisitos; //codigo das disciplinas pré-requisitos

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNumeroDeCreditos(int numeroDeCreditos) {
        this.numeroDeCreditos = numeroDeCreditos;
    }

    public void setSemestreRecomendado(int semestreRecomendado) {
        this.semestreRecomendado = semestreRecomendado;
    }

    public void setEletiva(boolean eletiva) {
        this.eletiva = eletiva;
    }

    public void setNumeroDeCreditosMinimos(int numeroDeCreditosMinimos) {
        this.numeroDeCreditosMinimos = numeroDeCreditosMinimos;
    }

    public void setPreRequisitos(ArrayList<String> preRequisitos) {
        this.preRequisitos = preRequisitos;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getNumeroDeCreditos() {
        return numeroDeCreditos;
    }

    public int getSemestreRecomendado() {
        return semestreRecomendado;
    }

    public boolean isEletiva() {
        return eletiva;
    }

    public int getNumeroDeCreditosMinimos() {
        return numeroDeCreditosMinimos;
    }

    public ArrayList<String> getPreRequisitos() {
        return preRequisitos;
    }
}

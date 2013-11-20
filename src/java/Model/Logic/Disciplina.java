/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Logic;

import java.util.HashSet;


/**
 *
 */
public class Disciplina {
    private String nome;
    private String codigo;
    private int numeroDeCreditos;
    private boolean eletiva;
    private int numeroDeCreditosMinimos;
    private HashSet<String> preRequisitos;
    
    public Disciplina(String codigo, String nome, boolean eletiva, int numCreditos){
        this.nome = nome;
        this.codigo = codigo;
        this.eletiva = eletiva;
        this.numeroDeCreditos = numCreditos;
    }
    
    public HashSet<String> getPreRequisitos(){
        return preRequisitos;
    }
    
    public void setPreRequisitos(HashSet<String> preRequisitos){
        this.preRequisitos = preRequisitos;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNumeroDeCreditos(int numeroDeCreditos) {
        this.numeroDeCreditos = numeroDeCreditos;
    }

    public void setEletiva(boolean eletiva) {
        this.eletiva = eletiva;
    }

    public void setNumeroDeCreditosMinimos(int numeroDeCreditosMinimos) {
        this.numeroDeCreditosMinimos = numeroDeCreditosMinimos;
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

    public boolean isEletiva() {
        return eletiva;
    }

    public int getNumeroDeCreditosMinimos() {
        return numeroDeCreditosMinimos;
    }
}

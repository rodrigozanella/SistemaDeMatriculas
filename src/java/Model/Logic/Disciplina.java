/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Logic;


/**
 *
 * @author Tiago
 */
public class Disciplina {
    private String nome;
    private String codigo; //o código é alfanumérico
    private int numeroDeCreditos;
    private boolean eletiva; //indica se a disciplina é eletiva ou não
    private int numeroDeCreditosMinimos; //indica o número de créditos necessários para cursar esta disciplina

    public Disciplina(String codigo, String nome, boolean eletiva, int numCreditos){
        this.nome = nome;
        this.codigo = codigo;
        this.eletiva = eletiva;
        this.numeroDeCreditos = numCreditos;
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

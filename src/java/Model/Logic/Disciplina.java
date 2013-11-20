
package Model.Logic;

import java.util.ArrayList;


/**
 * Disciplinas do INF.
 */
public class Disciplina {
    private String nome;
    private String codigo;
    private int numeroDeCreditos;
    private boolean eletiva;
    private int numeroDeCreditosMinimos;
    private ArrayList<String> preRequisitos;
    
    public Disciplina(String codigo, String nome, int numCreditos, boolean eletiva, int numCreditosMinimos, ArrayList<String> preRequisitos){
        this.nome = nome;
        this.codigo = codigo;
        this.numeroDeCreditos = numCreditos;
        this.eletiva = eletiva;
        this.numeroDeCreditosMinimos = numCreditosMinimos;
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
    
    public void setPreRequisitos(ArrayList<String> preRequisitos){
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

    public boolean isEletiva() {
        return eletiva;
    }

    public int getNumeroDeCreditosMinimos() {
        return numeroDeCreditosMinimos;
    }
    
     public ArrayList<String> getPreRequisitos(){
        return preRequisitos;
    }
}

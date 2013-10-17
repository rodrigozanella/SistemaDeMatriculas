/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Logic;

import java.util.ArrayList;
import java.util.Dictionary;

/**
 *
 * @author Tiago
 */
public class HistoricoEscolar {
    private ArrayList<Turma> turmasAnteriores;
    private ArrayList<Character> conceitosObtidos;

    public void setTurmasAnteriores(ArrayList<Turma> turmasAnteriores) {
        this.turmasAnteriores = turmasAnteriores;
    }

    public void setConceitosObtidos(ArrayList<Character> conceitosObtidos) {
        this.conceitosObtidos = conceitosObtidos;
    }

    public ArrayList<Turma> getTurmasAnteriores() {
        return turmasAnteriores;
    }

    public ArrayList<Character> getConceitosObtidos() {
        return conceitosObtidos;
    }
    
    public double calculaMedia() {
        
        return 0.0;
    }
}

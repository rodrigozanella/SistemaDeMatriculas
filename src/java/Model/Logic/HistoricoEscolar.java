/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Logic;

import java.util.Dictionary;

/**
 *
 * @author Tiago
 */
public class HistoricoEscolar {
    private Dictionary<Turma, Character> disciplinasCursadas; //Mapeamento de turma para conceito

    public void adicionaDisciplinaCursada(Turma turma, char conceito) {
        disciplinasCursadas.put(turma, conceito);
    }

    public Dictionary<Turma, Character> getDisciplinasCursadas() {
        return disciplinasCursadas;
    }
    
    public double calculaMedia() {
        
        return 0.0;
    }
}

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
public class HistoricoEscolar {
    private ArrayList<HistoricoEscolarElemento> elementos;
    private ArrayList<Turma> turmasAnteriores;
    private ArrayList<Character> conceitosObtidos;
    
    public HistoricoEscolar(){
        elementos = new ArrayList<HistoricoEscolarElemento>();
    }

    public void addElemento(Turma novaTurma, char novoConceito){
        HistoricoEscolarElemento novoElemento = new HistoricoEscolarElemento(
                novaTurma, novoConceito);
        elementos.add(novoElemento);
    }
    
    public ArrayList<HistoricoEscolarElemento> getHistorico(){
        return elementos;
    }
    
    public double calculaMedia() {
        
        return 0.0;
    }
}

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
    
    public double calculaMediaHarmonica() {
        double somatorio = 0;
        
        for(HistoricoEscolarElemento elemento : elementos){
            switch(elemento.getConceito()){
                case 'A': case 'a': somatorio += 1.0/100.0;
                case 'B': case 'b': somatorio += 1.0/80.0;
                case 'C': case 'c': somatorio += 1.0/60.0;
                case 'D': case 'd': somatorio += 1.0/10.0;
                default: somatorio += 1.0/1.0;
            }
        }
        
        return elementos.size()/somatorio;
    }
}

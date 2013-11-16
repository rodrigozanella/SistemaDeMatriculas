
package Model.Logic;

public class HistoricoEscolarElemento{
    private Turma turma;
    private char conceito;
    
    public HistoricoEscolarElemento(Turma novaTurma, char novoConceito){
        turma = novaTurma;
        conceito = novoConceito;
    }
    
    public Turma getTurma(){
        return turma;
    }
    
    public char getConceito(){
        return conceito;
    }
}

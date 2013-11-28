
package Model.Logic;
/**
 * Um elemento do histórico escolar, composto por uma turma, cursada por um aluno
 * e o conceito que ele obteve ao cursa-la
 * @author Rodrigo Zanella Ribeiro
 */
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

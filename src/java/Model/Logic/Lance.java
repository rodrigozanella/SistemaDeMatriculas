
package Model.Logic;


public class Lance {
    private int idTurma;
    private String cpfAluno;
    private int valor;

    public Lance(int idTurma, String cpfAluno, int valor){
        this.idTurma = idTurma;
        this.cpfAluno = cpfAluno;
        this.valor = valor;
    }
    
    public int getIdTurma(){
        return idTurma;
    }
    
    public String getCpfAluno(){
        return cpfAluno;
    }
   
    public int getValor(){
        return valor;
    }
    
    public void setIdTurma(int idTurma){
        this.idTurma = idTurma;
    }
    
    public void setCpfAluno(String cpfAluno){
        this.cpfAluno = cpfAluno;
    }
   
    public void setValor(int valor){
        this.valor = valor;
    }

}

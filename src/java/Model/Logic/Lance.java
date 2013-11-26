
package Model.Logic;


public class Lance {
    private int idTurma;
    private String cpfAluno;
    private int valor;
    private String situacao;

    public Lance(int idTurma, String cpfAluno, int valor, String situacao){
        this.idTurma = idTurma;
        this.cpfAluno = cpfAluno;
        this.valor = valor;
        this.situacao = situacao;
    }
    
    public String getSituacao(){
        return situacao;
    }
    
    public void setSituacao(String situacao){
        this.situacao = situacao;
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


package Model.Logic;

/**
 * Classe que representa uma turma no sistema
 * @author Tiago Covolan
 */
public class Turma {
    private String codigoDisciplina;
    private int codigoUnico; //identificador único da turma
    private int codigo; //'A', 'B', etc...
    private String semestre; //no formato "20xx/x"
    private String horario; //no formato "13:30"
    private String cpfProfessor;
    private int numeroDeVagas;

    public Turma(int codigo, String codigoDisciplina, String horario, String semestre, int vagas, String cpfProfessor){
        this.codigo = codigo;
        this.codigoDisciplina = codigoDisciplina;
        this.horario = horario;
        this.semestre = semestre;
        this.numeroDeVagas = vagas;
        this.cpfProfessor = cpfProfessor;
    }
    
    public void setCodigoUnico(int codigoUnico) {
        this.codigoUnico = codigoUnico;
    }
    
    public int getCodigoUnico() {
        return codigoUnico;
    }
        
    public void setCodigoDisciplina(String codigoDisciplina) {
        this.codigoDisciplina = codigoDisciplina;
    }

    public void setCodigo(char codigo) {
        this.codigo = codigo;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public void setCpfProfessor(String cpfProfessor) {
        this.cpfProfessor = cpfProfessor;
    }

    public void setNumeroDeVagas(int numeroDeVagas) {
        this.numeroDeVagas = numeroDeVagas;
    }

    public String getCodigoDisciplina() {
        return codigoDisciplina;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getSemestre() {
        return semestre;
    }

    public String getHorario() {
        return horario;
    }

    public String getCpfProfessor() {
        return cpfProfessor;
    }

    public int getNumeroDeVagas() {
        return numeroDeVagas;
    }
}


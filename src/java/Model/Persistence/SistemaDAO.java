package Model.Persistence;

public interface SistemaDAO {
    public String getEstado();
    public String getSemestre();
    public boolean setEstado(String novoEstado);
    public boolean setSemestre(String novoSemestre);
    
}
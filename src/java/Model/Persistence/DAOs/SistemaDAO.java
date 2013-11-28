package Model.Persistence.DAOs;
/**
 * Interface necessária para criar um DAO para o Sistema
 * @author Zanella
 */
public interface SistemaDAO {
    public String getEstado();
    public String getSemestre();
    public boolean setEstado(String novoEstado);
    public boolean setSemestre(String novoSemestre);
    
}

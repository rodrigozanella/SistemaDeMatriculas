package Model.Persistence.DAOs;

import Model.Logic.Administrador;
/**
 * Interface necessária para criar um DAO para o Administrador
 * @author Rodrigo Zanella Ribeiro
 */
public interface AdministradorDAO {
    public Administrador getAdministrador(String usuario, String password);
    public boolean adicionarAdministrador(Administrador administrador);
}

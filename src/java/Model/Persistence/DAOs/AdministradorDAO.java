package Model.Persistence.DAOs;

import Model.Logic.Administrador;

public interface AdministradorDAO {
    public Administrador getAdministrador(String usuario, String password);
}

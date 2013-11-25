package Model.Persistence.DAOs;

import Model.Logic.Usuario;

/**
 *
 * @author Zanella
 */
public interface UsuarioDAO {
    public Usuario getUsuario(String name, String password);
    public boolean excluirUsuario(Usuario user);
    public boolean adicionarUsuario(Usuario user);
    public Usuario getUsuario(String cpf);
}

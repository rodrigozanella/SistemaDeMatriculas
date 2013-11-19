package Model.Persistence;

import Model.Logic.Usuario;

/**
 *
 * @author Zanella
 */
public interface UsuarioDAO {
    public Usuario getUsuario(String name, String password);
    public boolean excluirUsuario(Usuario user);
    public boolean adicionarUsuario(Usuario user);
    public String getNomeUsuario(String cpf);
    
}

package Model.Persistence.DAOs;

import Model.Logic.Professor;
import Model.Logic.Usuario;
import java.util.ArrayList;

/**
 *
 * @author Zanella
 */
public interface UsuarioDAO {
    public Usuario getUsuario(String name, String password);
    public boolean excluirUsuario(Usuario user);
    public boolean adicionarUsuario(Usuario user);
    public ArrayList<Professor> getProfessores();
    public Usuario getUsuario(String cpf);
}

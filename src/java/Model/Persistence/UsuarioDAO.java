package Model.Persistence;

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
    public String getNomeUsuario(String cpf);
    public ArrayList<Professor> getProfessores();
    public boolean ehProfessor(String cpf);
}

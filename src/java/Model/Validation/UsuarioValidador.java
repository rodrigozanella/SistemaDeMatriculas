
package Model.Validation;

import Model.Logic.Usuario;
import Model.Persistence.DAOs.UsuarioDAO;
import Model.Persistence.FactoryDAO;

/**
 * Classe usada para validar um usuário
 * @author Rodrigo Zanella Ribeiro
 */

public class UsuarioValidador {
    private Usuario usuario;
    
    public UsuarioValidador(){
        usuario = null;
    }
    
    public void setUsuario(Usuario novoUsuario){
        usuario = novoUsuario;
    }
    
    public boolean validaNome(){
        return usuario.getNome().length() > 3;
    }
    
    public boolean validaDataNascimento(){
        return true;
    }
    
    public boolean validaEmail(){
        return usuario.getEmail().matches("^[a-zA-Z0-9_\\.-]+@([a-zA-Z0-9]\\.)*([a-zA-Z0-9])*\\.");
    }
    
    public boolean validaCPF(){
        if(!usuario.getCpf().matches("[0-9][0-9][0-9].[0-9][0-9][0-9].[0-9][0-9][0-9]-[0-9][0-9]")){
            return false;
        }
        
        FactoryDAO factoryDAO = new FactoryDAO();
        UsuarioDAO usuarioDAO = factoryDAO.criarUsuarioDAO();
        if(usuarioDAO.getUsuario(usuario.getCpf()) != null){
            return false;
        }
        
        return true;
    }
    
    public boolean validaUserName(){
        return usuario.getNomeDeUsuario().length() > 3;
    }
    
    public boolean validaSenha(){
        return usuario.getSenha().length() > 3;
    }
    
    public boolean validaRole(){
        return usuario.getRole().equalsIgnoreCase("aluno")||
                usuario.getRole().equalsIgnoreCase("administrador")||
                usuario.getRole().equalsIgnoreCase("professor");
    }
    
    public boolean validarTudo(){
        return this.validaCPF() &&
                this.validaDataNascimento() &&
                this.validaEmail() &&
                this.validaNome() &&
                this.validaRole() &&
                this.validaSenha() &&
                this.validaUserName();
    }
}

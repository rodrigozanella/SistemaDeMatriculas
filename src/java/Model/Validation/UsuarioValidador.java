/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Validation;

import Model.Logic.Usuario;

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
        return false;
    }
    
    public boolean validaDataNascimento(){
        return false;
    }
    
    public boolean validaEmail(){
        return false;
    }
    
    public boolean validaCPF(){
        return false;
    }
    
    public boolean validaUserName(){
        return false;
    }
    
    public boolean validaSenha(){
        return false;
    }
    
    public boolean validaRole(){
        return false;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Logic;

import java.util.Date;

/**
 *
 * @author Tiago
 */
public class Usuario {
    private String nome;
    private Date dataDeNascimento;
    private String email;
    private String cpf;
    private String nomeDeUsuario;
    private String senha;
    private String role;
    
    public Usuario(String nome, String cpf, String nomeUsuario, String senha, String email, Date dataDeNascimento){
        this.nome = nome;
        this.cpf = cpf;
        this.nomeDeUsuario = nomeUsuario;
        this.senha = senha;
        this.email = email;
        this.dataDeNascimento = dataDeNascimento;
    }
    
    
    public String getRole(){
        return role;
    }
    
    public String getNomeDeUsuario() {
        return nomeDeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setRole(String newRole){
        role = newRole;
    }
    
    public void setNomeDeUsuario(String nomeDeUsuario) {
        this.nomeDeUsuario = nomeDeUsuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }
}

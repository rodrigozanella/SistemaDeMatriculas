/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.ControllerConta;

import Controller.Command.LogoffComando;

/**
 * ProfEstado
 * Representa o estado, quando o usuário está logado como professor
 * @author Rodrigo Zanella Ribeiro
 */
public class ProfEstado extends UsuarioEstado{ 
    public ProfEstado(){
        super();
        comandos.put("logoff", new LogoffComando());
    }
}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.ControllerConta;

import Controller.Estado;
import Controller.Command.Comando;
import Controller.Command.LoginComando;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author Zanella
 */
public class UsuarioEstado implements Estado {
    private HashMap<String,Comando> comandos;
    
    public UsuarioEstado(){
        //gerar comandos possíveis
        comandos = new HashMap<String,Comando>();
        comandos.put("login", new LoginComando());
    }
    
    @Override
    public HashMap<String, Comando> getComandos() {
        return comandos;
    }

}
package Controller.ControllerConta;

import Controller.Estado;
import Controller.Command.Comando;
import Controller.Command.LoginComando;
import java.util.HashMap;

/**
 * UsuarioEstado
 * Representa o estado, quando o usuário não está logado.
 * @author Rodrigo Zanella Ribeiro
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
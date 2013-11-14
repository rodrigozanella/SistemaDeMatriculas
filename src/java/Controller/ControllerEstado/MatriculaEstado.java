package Controller.ControllerEstado;

import Controller.Estado;
import Controller.Command.Comando;
import Controller.Command.LoginComando;
import java.util.HashMap;

/**
 * MatriculaEstado
 * Representa o estado, quando o sistema está em estado de matrícula
 * @author Rodrigo Zanella Ribeiro
 */

public class MatriculaEstado implements Estado {
    private HashMap<String,Comando> comandos;
    
    public MatriculaEstado(){
        //gerar comandos possíveis
        comandos = new HashMap<String,Comando>();
        comandos.put("login", new LoginComando());
    }
    
    @Override
    public HashMap<String, Comando> getComandos() {
        return comandos;
    }

}

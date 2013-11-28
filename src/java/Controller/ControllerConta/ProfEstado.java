package Controller.ControllerConta;

import Controller.Command.LogoffComando;
import Controller.Command.VisualizarTurmasComando;

/**
 * Representa o estado, quando o usuário está logado como professor
 * @author Rodrigo Zanella Ribeiro
 */
public class ProfEstado extends UsuarioEstado{ 
    public ProfEstado(){
        super();
        comandos.put("logoff", new LogoffComando());
        comandos.put("visualizarTurmas", new VisualizarTurmasComando());
    }
}
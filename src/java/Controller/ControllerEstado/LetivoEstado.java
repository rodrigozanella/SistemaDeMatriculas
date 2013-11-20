package Controller.ControllerEstado;

import Controller.Command.CadastrarDisciplinaComando;
import Controller.Command.CadastrarUsuarioComando;
import Controller.Estado;
import Controller.Command.Comando;
import Controller.Command.ImprimirHistoricoComando;
import Controller.Command.LoginComando;
import Controller.Command.PossibilidadeMatriculaComando;
import java.util.HashMap;

/**
 * LetivoEstado
 * Representa o estado, quando o sistema está em estado letivo
 * @author Rodrigo Zanella Ribeiro
 */

public class LetivoEstado implements Estado {
    private HashMap<String,Comando> comandos;
    
    public LetivoEstado(){
        //gerar comandos possíveis
        comandos = new HashMap<String,Comando>();
        comandos.put("login", new LoginComando());
        comandos.put("possibilidadeMatricula", new PossibilidadeMatriculaComando());
        comandos.put("imprimirHistorico", new ImprimirHistoricoComando());
        comandos.put("cadastrarUsuario", new CadastrarUsuarioComando());
        comandos.put("cadastrarDisciplina", new CadastrarDisciplinaComando());
    }
    
    @Override
    public HashMap<String, Comando> getComandos() {
        return comandos;
    }

}
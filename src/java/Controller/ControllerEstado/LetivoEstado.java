package Controller.ControllerEstado;

import Controller.Command.CadastrarAdministradorComando;
import Controller.Command.CadastrarAlunoComando;
import Controller.Command.CadastrarDisciplinaComando;
import Controller.Command.CadastrarProfessorComando;
import Controller.Command.CadastrarTurmaComando;
import Controller.Command.CadastrarUsuarioComando;
import Controller.Estado;
import Controller.Command.Comando;
import Controller.Command.ImprimirHistoricoComando;
import Controller.Command.LoginComando;
import Controller.Command.LogoffComando;
import Controller.Command.PossibilidadeMatriculaComando;
import Controller.Command.VisualizarTurmasComando;
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
        comandos.put("cadastrarAluno", new CadastrarAlunoComando());
        comandos.put("cadastrarProfessor", new CadastrarProfessorComando());
        comandos.put("cadastrarAdministrador", new CadastrarAdministradorComando());
        comandos.put("cadastrarDisciplina", new CadastrarDisciplinaComando());
        comandos.put("cadastrarTurma", new CadastrarTurmaComando());
        comandos.put("logoff", new LogoffComando());
        comandos.put("visualizarTurmas", new VisualizarTurmasComando());
    }
    
    @Override
    public HashMap<String, Comando> getComandos() {
        return comandos;
    }

}
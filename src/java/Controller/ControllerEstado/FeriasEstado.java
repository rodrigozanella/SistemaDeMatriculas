package Controller.ControllerEstado;

import Controller.Command.CadastrarAdministradorComando;
import Controller.Command.CadastrarAlunoComando;
import Controller.Command.CadastrarDisciplinaComando;
import Controller.Command.CadastrarProfessorComando;
import Controller.Command.CadastrarTurmaComando;
import Controller.Command.CadastrarUsuarioComando;
import Controller.Estado;
import Controller.Command.Comando;
import Controller.Command.ComprovanteMatriculaComando;
import Controller.Command.ImprimirHistoricoComando;
import Controller.Command.IniciarPeriodoEncomendaComando;
import Controller.Command.LoginComando;
import Controller.Command.LogoffComando;
import Controller.Command.PossibilidadeMatriculaComando;
import Controller.Command.ResultadoEncomendaComando;
import Controller.Command.VisualizarTurmasComando;
import java.util.HashMap;

/**
 * FeriasEstado
 * Representa o estado, quando o sistema está em estado de férias
 * @author Rodrigo Zanella Ribeiro
 */
public class FeriasEstado implements Estado {
    private HashMap<String,Comando> comandos;
    
    public FeriasEstado(){
        //gerar comandos possíveis
        comandos = new HashMap<String,Comando>();
        comandos.put("login", new LoginComando());
        comandos.put("comprovanteMatricula", new ComprovanteMatriculaComando());
        comandos.put("resultadoEncomenda", new ResultadoEncomendaComando());
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
        comandos.put("iniciarPeriodoEncomenda", new IniciarPeriodoEncomendaComando());
    }
    
    @Override
    public HashMap<String, Comando> getComandos() {
        return comandos;
    }

}
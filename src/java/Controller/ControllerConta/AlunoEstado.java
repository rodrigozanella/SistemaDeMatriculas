package Controller.ControllerConta;

import Controller.Command.EncomendarMatriculaComando;
import Controller.Command.ImprimirHistoricoComando;
import Controller.Command.LogoffComando;
import Controller.Command.PossibilidadeMatriculaComando;
import Controller.Command.ResultadoEncomendaComando;

/**
 * AlunoEstado
 * Representa o estado, quando o usuário está logado como aluno
 * @author Rodrigo Zanella Ribeiro
 */
public class AlunoEstado extends UsuarioEstado {

    public AlunoEstado(){
        super();
        //gerar comandos possíveis
        comandos.put("resultadoEncomenda", new ResultadoEncomendaComando());
        comandos.put("encomendaMatricula", new EncomendarMatriculaComando());
        comandos.put("possibilidadeMatricula", new PossibilidadeMatriculaComando());
        comandos.put("imprimirHistorico", new ImprimirHistoricoComando());
        comandos.put("logoff", new LogoffComando());
    }

}
package Controller.ControllerConta;

import Controller.Command.ImprimirHistoricoComando;
import Controller.Command.PossibilidadeMatriculaComando;

/**
 * AlunoEstado
 * Representa o estado, quando o usuário está logado como aluno
 * @author Rodrigo Zanella Ribeiro
 */
public class AlunoEstado extends UsuarioEstado {

    public AlunoEstado(){
        super();
        //gerar comandos possíveis
        comandos.put("possibilidadeMatricula", new PossibilidadeMatriculaComando());
        comandos.put("imprimirHistorico", new ImprimirHistoricoComando());
    }

}
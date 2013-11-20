package Controller.ControllerConta;

import Controller.Command.CadastrarDisciplinaComando;
import Controller.Command.CadastrarTurmaComando;
import Controller.Command.CadastrarUsuarioComando;

/**
 * AdminEstado
 * Representa o estado, quando o usuário está logado como administrador
 * @author Rodrigo Zanella Ribeiro
 */
public class AdminEstado extends UsuarioEstado {
    public AdminEstado(){
        super();
        //gerar comandos possíveis
        comandos.put("cadastrarUsuario", new CadastrarUsuarioComando());
        comandos.put("cadastrarDisciplina", new CadastrarDisciplinaComando());
        comandos.put("cadastrarTurma", new CadastrarTurmaComando());
    }
   

}
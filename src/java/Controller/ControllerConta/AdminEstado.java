package Controller.ControllerConta;

import Controller.Command.CadastrarAdministradorComando;
import Controller.Command.CadastrarAlunoComando;
import Controller.Command.CadastrarDisciplinaComando;
import Controller.Command.CadastrarProfessorComando;
import Controller.Command.CadastrarTurmaComando;
import Controller.Command.CadastrarUsuarioComando;
import Controller.Command.IniciarPeriodoLetivoComando;
import Controller.Command.LogoffComando;

/**
 * AdminEstado
 * Representa o estado, quando o usuário está logado como administrador
 * @author Rodrigo Zanella Ribeiro
 */
public class AdminEstado extends UsuarioEstado {
    public AdminEstado(){
        super();
        //gerar comandos possíveis
        comandos.put("iniciarPeriodoLetivo", new IniciarPeriodoLetivoComando());
        comandos.put("cadastrarUsuario", new CadastrarUsuarioComando());
        comandos.put("cadastrarAluno", new CadastrarAlunoComando());
        comandos.put("cadastrarProfessor", new CadastrarProfessorComando());
        comandos.put("cadastrarAdministrador", new CadastrarAdministradorComando());
        comandos.put("cadastrarDisciplina", new CadastrarDisciplinaComando());
        comandos.put("cadastrarTurma", new CadastrarTurmaComando());
        comandos.put("logoff", new LogoffComando());
    }
   

}
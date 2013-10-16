/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Validation;

import Model.Persistence.OperadorBD;
import Model.Logic.Usuario;
import Model.Logic.Aluno;
import Model.Logic.Disciplina;
import Model.Logic.Turma;

/**
 *
 * @author Tiago
 * Todas as operações sobre o banco de dados terão que passar por aqui.
 * Ele verifica se os registros que serão inseridos no BD estão de acordo com
 * o formato definido dos dados
 */
public class Validador {
    
    public void insereRegistroUsuario(Usuario novoUsuario) throws Exception{
        
    }
    
    public void insereRegistroDisciplina(Disciplina novaDisciplina) throws Exception{
        
    }
    
    public void insereRegistroTurma(Turma novaTurma) throws Exception{
        
    }
    
    public Aluno getAluno(String nomeDeUsuario, String senha) throws Exception{
        if(senha.length() > 10){
            throw new Exception();
        }
        return OperadorBD.getAluno(nomeDeUsuario, senha);
    }
}

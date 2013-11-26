/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Validation;

import Model.Logic.Administrador;
import Model.Logic.Aluno;
import Model.Logic.Disciplina;
import Model.Logic.Lance;
import Model.Logic.Professor;
import Model.Logic.Turma;
import Model.Logic.Usuario;
import Model.Persistence.DAOs.DisciplinaDAO;
import Model.Persistence.FactoryDAO;
import Model.Persistence.DAOs.TurmaDAO;
import Model.Persistence.DAOs.UsuarioDAO;
import java.util.HashSet;
import java.util.Set;

/**
 * Todas as operações sobre o banco de dados terão que passar por aqui.
 * Ele verifica se os registros que serão inseridos no BD estão de acordo com
 * o formato definido dos dados
 */
public class Validador {
    
    /*
     * Verifica se os dados de um aluno estão corretos.
     */
    public boolean validaAluno(Aluno aluno){
        if(!validaUsuario(aluno)) return false;
        
        //a pontuacao do vestibular deve estar entre 0 e 100
        if(aluno.getPontuacaoVestibular() < 0 || aluno.getPontuacaoVestibular() > 100) return false;
        
        //o número de matrícula deve ser maior ou igual a zero
        if(aluno.getNumeroDeMatricula() < 0) return false;
        
        return true;
    }
    
    public boolean validaUsuario(Usuario usuario){
        //nome de usário deve ter pelo menos 3 caracteres
        if(usuario.getNomeDeUsuario().length() < 3) return false;
        
        //senha deve ter pelo menos 3 caracteres
        if(usuario.getSenha().length() < 3) return false;
        
        //nome deve ter pelo menos 3 caracteres
        if(usuario.getNome().length() < 3) return false;
        
        //verifica se o cpf casa com o padrão
        if(!usuario.getCpf().matches("[0-9][0-9][0-9].[0-9][0-9][0-9].[0-9][0-9][0-9]-[0-9][0-9]"))
            return false;
            
        if(!usuario.getRole().equals("aluno")){
            if(!usuario.getRole().equals("professor")){
                if (!usuario.getRole().equals("administrador")) return false;
            }
        }

        return true;
    }
    
    public boolean validaProfessor(Professor professor){
        if(!validaUsuario(professor)) return false;
        
        return true;
    }
    
    public boolean validaAdministrador(Administrador administrador){
        if(!validaUsuario(administrador)) return false;

        return true;
    }
    
    /*
     * Verifica se os dados de uma disciplina estão corretos.
     */
    public boolean validaDisciplina(Disciplina disciplina){
        //nome deve ter pelo menos 3 caracteres
        if(disciplina.getNome().length() < 3) return false;
        //código deve ter pelo menos 3 caracteres
        if(disciplina.getCodigo().length() < 3) return false;
        
        //código da disciplina não deve existir no BD
        FactoryDAO factoryDAO = new FactoryDAO();
        DisciplinaDAO disciplinaDAO = factoryDAO.criarDisciplinaDAO();
        if(disciplinaDAO.getDisciplina(disciplina.getCodigo()) != null) return false;
        
        //os códigos dos pré-requisitos devem existir no BD
        for(String preRequisito : disciplina.getPreRequisitos()){
            if(disciplinaDAO.getDisciplina(preRequisito) == null) return false;
        }
        
        //o número de créditos deve ser maior que 0
        if(disciplina.getNumeroDeCreditos() <= 0) return false;
        
        //o número de créditos mínimos não deve ser negativo
        if(disciplina.getNumeroDeCreditosMinimos() < 0) return false;
        
        return true;
    }
    
    /*
     * Verifica se os dados de uma turma estão corretos.
     */
    public boolean validaTurma(Turma turma){
        //o semestre deve estar no formato "20xx/x"
        if(!turma.getSemestre().matches("20[0-9][0-9]/(1|2)")) return false;
        
        //o horario deve estar no formato "xx:xx"
        if(!turma.getHorario().matches("[0-9][0-9]:[0-9][0-9]")) return false;
        
        //o número de vagas deve ser maior que zero
        if(turma.getNumeroDeVagas() <= 0) return false;
        
        //verifica se o professor existe
        FactoryDAO factoryDAO = new FactoryDAO();
        UsuarioDAO usuarioDAO = factoryDAO.criarUsuarioDAO();
        if(!usuarioDAO.getUsuario(turma.getCpfProfessor()).getRole().equalsIgnoreCase("professor")) return false;
        
        //verifica se a disciplina existe
        DisciplinaDAO disciplinaDAO = factoryDAO.criarDisciplinaDAO();
        if(disciplinaDAO.getDisciplina(turma.getCodigoDisciplina()) == null) return false;
        
        //verifica quantas turmas da disciplina existem no semestre
        TurmaDAO turmaDAO = factoryDAO.criarTurmaDAO();
        Set<Turma> turmas = turmaDAO.getTurmasSemestre(turma.getCodigoDisciplina(), turma.getSemestre());
        if(turmas.size() == 21) return false;
        if(turmas.size() == 0){
            if(turma.getCodigo() != (int)'U') return false;
        }
        else{
            if(turma.getCodigo() != ((int)'A' + turmas.size() - 1)) return false;
        }
        
        return true;
    }
    
    public boolean validaLance(Lance lance){
        if(lance.getValor() <= 0) return false;
        
        /* VERIFICA SE O ALUNO TEM PONTOS PARA REALIZAR ESTE LANCE
        FactoryDAO factoryDAO = new FactoryDAO();
        UsuarioDAO usuarioDAO = factoryDAO.criarUsuarioDAO();
        Aluno aluno = (Aluno)usuarioDAO.getUsuario(lance.getCpfAluno());
        ...
        */
                
        return true;
    }
}

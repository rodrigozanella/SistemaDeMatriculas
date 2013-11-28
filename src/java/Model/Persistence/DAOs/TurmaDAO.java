
package Model.Persistence.DAOs;

import Model.Logic.Aluno;
import Model.Logic.Turma;
import java.util.Set;
/**
 * Interface necessária para criar um DAO para Turmas
 * @author Rodrigo Zanella Ribeiro
 * @version 1.0
 * Modificações:
 * Adição de funcionalidades: getAlunos, existeTurmas e matriculaAluno
 * @author Tiago Covolan
 * @version 2.0
 */
public interface TurmaDAO{
    public Turma getTurma(int id);
    public boolean adicionaTurma(Turma turma);
    public boolean excluirTurma(Turma turma);
    public Set<Turma> getTurmasSemestre(String codDisciplina, String semestre);
    public Set<Aluno> getAlunos(int id);
    public Set<Turma> getTurmasSemestre(String semestre);
    public boolean matriculaAluno(Turma turma, Aluno aluno);
    public boolean existeTurmas(String semestre);
    public Set<Turma> getTurmasMatriculadas(Aluno aluno, String semestre);
}
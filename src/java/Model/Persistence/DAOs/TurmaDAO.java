
package Model.Persistence.DAOs;

import Model.Logic.Aluno;
import Model.Logic.Turma;
import java.util.Set;

public interface TurmaDAO{
    public Turma getTurma(int id);
    public boolean adicionaTurma(Turma turma);
    public boolean excluirTurma(Turma turma);
    public Set<Turma> getTurmasSemestre(String codDisciplina, String semestre);
    public Set<Aluno> getAlunos(int id);
    public boolean existeTurmas(String semestre);
}

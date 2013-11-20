
package Model.Persistence;

import Model.Logic.Disciplina;
import java.util.Set;

public interface DisciplinaDAO {
    public Disciplina getDisciplina(String id);
    public Set<Disciplina> getPreRequisitos(Disciplina disciplina);
    public Set<String> getNomesDisciplinas();
    public String getCodigo(String nomeDisciplina);
    public boolean adicionarDisciplina(Disciplina disciplina);
}

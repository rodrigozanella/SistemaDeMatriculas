
package Model.Persistence;

import Model.Logic.Disciplina;
import java.util.ArrayList;
import java.util.Set;

public interface DisciplinaDAO {
    public Disciplina getDisciplina(String id);
    public Set<Disciplina> getPreRequisitos(Disciplina disciplina);
    public ArrayList<Disciplina> getDisciplinas();
    public String getCodigo(String nomeDisciplina);
    public boolean adicionarDisciplina(Disciplina disciplina);
    public boolean existeCodigo(String codigo);
}

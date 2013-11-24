
package Model.Persistence.DAOs;

import Model.Logic.Disciplina;
import java.util.ArrayList;
import java.util.Set;

public interface DisciplinaDAO {
    public Disciplina getDisciplina(String id);
    public Set<Disciplina> getPreRequisitos(Disciplina disciplina);
    public ArrayList<Disciplina> getDisciplinas();
    public boolean adicionarDisciplina(Disciplina disciplina);
}

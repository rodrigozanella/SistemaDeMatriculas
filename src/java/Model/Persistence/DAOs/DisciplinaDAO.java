
package Model.Persistence.DAOs;

import Model.Logic.Disciplina;
import java.util.ArrayList;
import java.util.Set;
/**
 * Interface necessária para criar um DAO para uma Disciplina
 * @author Zanella
 */
public interface DisciplinaDAO {
    public Disciplina getDisciplina(String id);
    public Set<Disciplina> getPreRequisitos(Disciplina disciplina);
    public ArrayList<Disciplina> getDisciplinas();
    public boolean adicionarDisciplina(Disciplina disciplina);
}

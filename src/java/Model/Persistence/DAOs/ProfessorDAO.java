package Model.Persistence.DAOs;

import Model.Logic.Professor;
import Model.Logic.Turma;
import java.util.List;

public interface ProfessorDAO {
    public List<Turma> getTurmas(String cpfProfessor);
    public Professor getProfessor(String usuario, String password);
    
}

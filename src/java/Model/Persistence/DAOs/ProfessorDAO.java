package Model.Persistence.DAOs;

import Model.Logic.Professor;
import Model.Logic.Turma;
import java.util.List;
/**
 * Interface necessária para criar um DAO para professor
 * @author Rodrigo Zanella Ribeiro
 */
public interface ProfessorDAO {
    public List<Turma> getTurmas(String cpfProfessor);
    public Professor getProfessor(String usuario, String password);
    public boolean adicionarProfessor(Professor professor);
    public List<Professor> getProfessores();
    
}

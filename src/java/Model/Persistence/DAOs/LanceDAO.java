package Model.Persistence.DAOs;

import Model.Logic.Aluno;
import Model.Logic.Lance;
import Model.Logic.Turma;
import java.util.Set;

public interface LanceDAO{
    public boolean adicionaLance(Lance lance);
    public Set<Lance> getLances(Aluno aluno);
    public boolean atualizaLance(Lance lance);
    public Set<Lance> getLances(Turma turma);
}

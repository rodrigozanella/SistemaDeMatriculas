package Model.Persistence.DAOs;

import Model.Logic.Aluno;
import Model.Logic.Disciplina;
import Model.Logic.HistoricoEscolar;
import Model.Logic.HistoricoEscolarElemento;
import java.util.Set;

/**
 * Interface necessária para criar um DAO para um HistoricoEscolar
 * @author Rodrigo Zanella Ribeiro
 */
public interface HistoricoDAO{
    public HistoricoEscolar getHistorico(Aluno aluno);
    public boolean salvarElemento(HistoricoEscolarElemento novoElemento);
    public Set<Disciplina> getDisciplinasCursadas(Aluno aluno);
    public Set<Disciplina> getDisciplinasNaoCursadas(Aluno aluno);
}

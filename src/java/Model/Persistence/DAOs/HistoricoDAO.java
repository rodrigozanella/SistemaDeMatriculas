package Model.Persistence;

import Model.Logic.Aluno;
import Model.Logic.Disciplina;
import Model.Logic.HistoricoEscolar;
import Model.Logic.HistoricoEscolarElemento;
import java.util.Set;

/**
 *
 * @author Rodrigo Zanella Ribeiro
 */
public interface HistoricoDAO{
    public HistoricoEscolar getHistorico(Aluno aluno);
    public boolean salvarElemento(HistoricoEscolarElemento novoElemento);
    public Set<Disciplina> getDisciplinasCursadas(Aluno aluno);
    public Set<Disciplina> getDisciplinasNaoCursadas(Aluno aluno);
}

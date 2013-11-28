package Model.Persistence.DAOs;

import Model.Logic.Aluno;
import java.util.Set;

/**
 * Interface necessária para criar um DAO para o Aluno
 * @author Rodrigo Zanella Ribeiro
 */
public interface AlunoDAO {
    public Aluno getAluno(String usuario, String password);
    public boolean adicionarAluno(Aluno aluno);
    public Set<Aluno> getAlunosIrregulares();
    public boolean expulsarAluno(Aluno aluno);
    public boolean situacao(Aluno aluno);
    public Set<Aluno> getAlunos();
    public boolean atualizaPontuacao(Aluno aluno, int pontuacao);
}

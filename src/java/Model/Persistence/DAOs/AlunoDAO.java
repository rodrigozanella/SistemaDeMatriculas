/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Persistence.DAOs;

import Model.Logic.Aluno;
import java.util.Set;

/**
 *
 * @author Zanella
 */
public interface AlunoDAO {
    public Aluno getAluno(String usuario, String password);
    public boolean adicionarAluno(Aluno aluno);
    public Set<Aluno> getAlunosIrregulares();
    public boolean expulsarAluno(Aluno aluno);
    public boolean situacao(Aluno aluno);
}

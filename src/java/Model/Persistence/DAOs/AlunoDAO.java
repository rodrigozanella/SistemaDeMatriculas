/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Persistence.DAOs;

import Model.Logic.Aluno;

/**
 *
 * @author Zanella
 */
public interface AlunoDAO {
    public Aluno getAluno(String usuario, String password);
    
}

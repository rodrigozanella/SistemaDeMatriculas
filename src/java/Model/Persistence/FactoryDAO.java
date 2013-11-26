package Model.Persistence;

import Model.Persistence.JDBC.JDBCAdministradorDAO;
import Model.Persistence.JDBC.JDBCHistoricoDAO;
import Model.Persistence.JDBC.JDBCDisciplinaDAO;
import Model.Persistence.JDBC.JDBCSistemaDAO;
import Model.Persistence.JDBC.JDBCProfessorDAO;
import Model.Persistence.JDBC.JDBCUsuarioDAO;
import Model.Persistence.JDBC.JDBCTurmaDAO;
import Model.Persistence.DAOs.SistemaDAO;
import Model.Persistence.DAOs.ProfessorDAO;
import Model.Persistence.DAOs.UsuarioDAO;
import Model.Persistence.DAOs.TurmaDAO;
import Model.Persistence.DAOs.HistoricoDAO;
import Model.Persistence.DAOs.DisciplinaDAO;
import Model.Persistence.DAOs.AdministradorDAO;
import Model.Persistence.DAOs.AlunoDAO;
import Model.Persistence.DAOs.LanceDAO;
import Model.Persistence.JDBC.JDBCAlunoDAO;
import Model.Persistence.JDBC.JDBCLanceDAO;

public class FactoryDAO {
    public UsuarioDAO criarUsuarioDAO(){
        return new JDBCUsuarioDAO();
    }
    
    public SistemaDAO criarSistemaDAO(){
        return new JDBCSistemaDAO();
    }
    
    public HistoricoDAO criarHistoricoDAO(){
        return new JDBCHistoricoDAO();
    }
    
    public TurmaDAO criarTurmaDAO(){
        return new JDBCTurmaDAO();
    }
    
    public DisciplinaDAO criarDisciplinaDAO(){
        return new JDBCDisciplinaDAO();
    }
    
    public ProfessorDAO criarProfessorDAO(){
        return new JDBCProfessorDAO();
    }
    
    public AdministradorDAO criarAdministradorDAO(){
        return new JDBCAdministradorDAO();
    }
    
    public AlunoDAO criarAlunoDAO(){
        return new JDBCAlunoDAO();
    }
    
    public LanceDAO criarLanceDAO(){
        return new JDBCLanceDAO();
    }
}

package Model.Persistence;

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
}

package Controller;

import Controller.Command.Comando;
import java.util.HashMap;
/**
 * Interface que representa um estado, que representa as possíveis interações 
 * que o usuário pode realizar naquele estado
 * @author Rodrigo Zanella Ribeiro
 */
public interface Estado{
    /**
     * Captura os comandos possíveis no estado
     * @author Rodrigo Zanella Ribeiro
     * @return Comandos que são possíveis no estado
     */
    public HashMap<String,Comando> getComandos();
    
}
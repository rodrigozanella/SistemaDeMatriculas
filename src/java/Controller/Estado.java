package Controller;

import java.util.Map;
import Controller.Command.Comando;
import java.util.HashMap;

public interface Estado{
    public HashMap<String,Comando> getComandos();
    
}
package Controller.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Comando{
    public void executar(HttpServletRequest request, HttpServletResponse response);
    
}
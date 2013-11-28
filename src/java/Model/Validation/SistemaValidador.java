/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Validation;

/**
 *
 * @author Zanella
 */
public class SistemaValidador {
    
    public boolean validaEstado(String estado){
        return estado.equalsIgnoreCase("matricula")||
                estado.equalsIgnoreCase("letivo")||
                estado.equalsIgnoreCase("ferias");       
    }
    
    public boolean validaSemestre(String semestre){
        return semestre.matches("20[0-9][0-9]/(1|2)");
    }
}

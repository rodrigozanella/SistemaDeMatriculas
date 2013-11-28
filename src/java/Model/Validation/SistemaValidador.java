
package Model.Validation;


/**
 * Classe utilizada para a validação de dados de um sistema
 * @author Rodrigo Zanella Ribeiro
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

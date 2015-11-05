/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.entities;

/**
 *
 * @author Zacarias
 */
public class ClMedidas {
    private int idMedida;
    private String medida;

    public ClMedidas() {

    }
    
    public ClMedidas(String medida) {
        setMedida(medida);
    }
    
    public ClMedidas(int idMedida, String medida) {
        setIdMedida(idMedida);
        setMedida(medida);
    }

    public int getIdMedida() {
        return idMedida;
    }

    public void setIdMedida(int idMedida) {
        this.idMedida = idMedida;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }
    
}

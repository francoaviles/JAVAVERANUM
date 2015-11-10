/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.entities;

/**
 *
 * @author Zacarias
 */
public class ClHabitacionEstados {
    private int idHabitacionEstado;
    private String estado;

    public ClHabitacionEstados(int idHabitacionEstado) {
        setIdHabitacionEstado(idHabitacionEstado);
    }
    
    public ClHabitacionEstados(int idHabitacionEstado, String estado) {
        setIdHabitacionEstado(idHabitacionEstado);
        setEstado(estado);
    }

    public ClHabitacionEstados() {
    }
    public ClHabitacionEstados(String estado) {
        setEstado(estado);
    }
    
    public int getIdHabitacionEstado() {
        return idHabitacionEstado;
    }

    public void setIdHabitacionEstado(int idHabitacionEstado) {
        this.idHabitacionEstado = idHabitacionEstado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}

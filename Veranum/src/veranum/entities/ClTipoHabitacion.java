/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.entities;

/**
 *
 * @author Zacarias
 */
public class ClTipoHabitacion {
    private int idTipoHabit;
    private String nombre;

    public ClTipoHabitacion() {

    }
    
    public ClTipoHabitacion(int idTipoHabit) {
        setIdTipoHabit(idTipoHabit);
    }
    
    public ClTipoHabitacion(String nombre) {
        setNombre(nombre);
    }
    
    public ClTipoHabitacion(int idTipoHabit, String nombre) {
        setIdTipoHabit(idTipoHabit);
        setNombre(nombre);
    }

    public int getIdTipoHabit() {
        return idTipoHabit;
    }

    public void setIdTipoHabit(int idTipoHabit) {
        this.idTipoHabit = idTipoHabit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public String toString(){
        return getNombre();
    }
    
}

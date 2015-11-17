/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.entities;

/**
 *
 * @author Zacarias
 */
public class ClHabitacionCaract {
    private int idHabitacion;
    private int idCaract;
    private String nombreHotel;
    
    public ClHabitacionCaract() {
    }
    
    public ClHabitacionCaract(int idHabitacion) {
        setIdHabitacion(idHabitacion);
    }   
    
    public ClHabitacionCaract(int idHabitacion, int idCaract) {
        setIdHabitacion(idHabitacion);
        setIdCaract(idCaract);
    }
    
    public ClHabitacionCaract(int idHabitacion, int idCaract, String nombreHotel) {
        setIdHabitacion(idHabitacion);
        setIdCaract(idCaract);
        setNombreHotel(nombreHotel);
    }
    
    public String getNombreHotel() {
        return nombreHotel;
    }

    public void setNombreHotel(String nombreHotel) {
        this.nombreHotel = nombreHotel;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public int getIdCaract() {
        return idCaract;
    }

    public void setIdCaract(int idCaract) {
        this.idCaract = idCaract;
    }
}

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
    private int ubicacion;
    private int cantPersonas;
    private String tipo;
    
    
    public ClHabitacionCaract() {
    }
    
    public ClHabitacionCaract(int idHabitacion) {
        setIdHabitacion(idHabitacion);
    }   
    
    public ClHabitacionCaract(int idHabitacion, int idCaract) {
        setIdHabitacion(idHabitacion);
        setIdCaract(idCaract);
    }
    
    public ClHabitacionCaract(int idHabitacion, int idCaract, String nombreHotel,int ubicacion, int cantPersonas, String tipo) {
        setIdHabitacion(idHabitacion);
        setIdCaract(idCaract);
        setNombreHotel(nombreHotel);
        setUbicacion(ubicacion);
        setCantPersonas(cantPersonas);
        setTipo(tipo);
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
    
    public int getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(int ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getCantPersonas() {
        return cantPersonas;
    }

    public void setCantPersonas(int cantPersonas) {
        this.cantPersonas = cantPersonas;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}

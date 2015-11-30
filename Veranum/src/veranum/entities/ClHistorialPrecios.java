/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.entities;

import java.util.Date;

/**
 *
 * @author Zacarias
 */
public class ClHistorialPrecios {
    private int idHistorialPrecios;
    private int idHabitacion;
    private int precio;
    private int nuevo_precio;
    private String hotel;
    private int ubicacion;
    private Date fecha;

    public ClHistorialPrecios(int idHabitacion, int precio, Date fecha) {
        setIdHbitacion(idHabitacion);
        setPrecio(precio);
        setFecha(fecha);
    }
    public ClHistorialPrecios() {
    }
    
    public ClHistorialPrecios(int idHistorialPrecios) {
        setIdHistorialPrecios(idHistorialPrecios);
    }
    
    public ClHistorialPrecios(int idHistorialPrecios, int idHabitacion, int precio, Date fecha) {
        setIdHistorialPrecios(idHistorialPrecios);
        setIdHbitacion(idHabitacion);
        setPrecio(precio);
        setFecha(fecha);
    }

    public ClHistorialPrecios(int idHistorialPrecios, int idHabitacion, int precio, int nuevo_precio, String hotel, int ubicacion, Date fecha) {
        setIdHistorialPrecios(idHistorialPrecios);
        setIdHbitacion(idHabitacion);
        setPrecio(precio);
        setFecha(fecha);
        setHotel(hotel);
        setNuevo_precio(nuevo_precio);
        setUbicacion(ubicacion);
    }

    
    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public int getNuevo_precio() {
        return nuevo_precio;
    }

    public void setNuevo_precio(int nuevo_precio) {
        this.nuevo_precio = nuevo_precio;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public int getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(int ubicacion) {
        this.ubicacion = ubicacion;
    }

    
    public int getIdHistorialPrecios() {
        return idHistorialPrecios;
    }

    public void setIdHistorialPrecios(int idHistorialPrecios) {
        this.idHistorialPrecios = idHistorialPrecios;
    }

    public int getIdHbitacion() {
        return idHabitacion;
    }

    public void setIdHbitacion(int idHbitacion) {
        this.idHabitacion = idHbitacion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
}

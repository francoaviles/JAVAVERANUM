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

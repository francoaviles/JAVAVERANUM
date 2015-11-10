/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.entities;

/**
 *
 * @author Zacarias
 */
public class ClServicios {
    private int idServicio;
    private String nombre;
    private int precio;

    public ClServicios() {
    }
    public ClServicios(String nombre) {
        setNombre(nombre);
    }
  
    public ClServicios(String nombre, int precio) {
        setNombre(nombre);
        setPrecio(precio);
    }
    
    public ClServicios(int idServicio, String nombre, int precio) {
        setIdServicio(idServicio);
        setNombre(nombre);
        setPrecio(precio);
    }

    public ClServicios(int idServicio) {
        setIdServicio(idServicio);
    }
    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.entities;

/**
 *
 * @author Zacarias
 */
public class ClRol {
    private int idRol;
    private String nombre;
    private String descripcion;

    public ClRol(int idRol, String nombre, String descripcion) {
        setIdRol(idRol);
        setNombre(nombre);
        setDescripcion(descripcion);
    }
    
     public ClRol(String nombre, String descripcion) {
        setNombre(nombre);
        setDescripcion(descripcion);
    }
    
    public ClRol() {
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}

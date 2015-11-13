/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.entities;

/**
 *
 * @author Zacarias
 */
public class ClTipoCaracteristicas {
    private int idTipoCaract;
    private String nombre;
    private String descripcion;

    public ClTipoCaracteristicas() {
    }
    
     public ClTipoCaracteristicas(int idTipoCaract) {
        setIdTipoCaract(idTipoCaract);
    }
     
     public ClTipoCaracteristicas(String nombre) {
        setNombre(nombre);
    }
     
    public ClTipoCaracteristicas(String nombre, String descripcion) {
        setNombre(nombre);
        setDescripcion(descripcion);
    }
    
    public ClTipoCaracteristicas(int idTipoCaract, String nombre, String descripcion) {
        setIdTipoCaract(idTipoCaract);
        setNombre(nombre);
        setDescripcion(descripcion);
    }

    public int getIdTipoCaract() {
        return idTipoCaract;
    }

    public void setIdTipoCaract(int idTipoCaract) {
        this.idTipoCaract = idTipoCaract;
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
    
    @Override
    public String toString(){
        return getNombre();
    }
}

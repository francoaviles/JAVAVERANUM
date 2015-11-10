/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.entities;

/**
 *
 * @author Zacarias
 */
public class ClTipoReportes {
    private int idTipoReporte;
    private String nombre;
    private String descripcion;

    public ClTipoReportes() {

    }
    
    public ClTipoReportes(int idTipoReporte) {
        setIdTipoReporte(idTipoReporte);
    }
    
    public ClTipoReportes(String nombre) {
        setNombre(nombre);
    }
    
    public ClTipoReportes(String nombre, String descripcion) {
        setNombre(nombre);
        setDescripcion(descripcion);
    }
    
    public ClTipoReportes(int idTipoReporte, String nombre, String descripcion) {
        setIdTipoReporte(idTipoReporte);
        setNombre(nombre);
        setDescripcion(descripcion);
    }

    public int getIdTipoReporte() {
        return idTipoReporte;
    }

    public void setIdTipoReporte(int idTipoReporte) {
        this.idTipoReporte = idTipoReporte;
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

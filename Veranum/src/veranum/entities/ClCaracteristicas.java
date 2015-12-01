/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.entities;

/**
 *
 * @author Zacarias
 */
public class ClCaracteristicas {
    private int idCaracteristica;
    private int idTipoCaract;
    private int cantidad;
    private String tipo;
    private String nombre;
    private String descripcion;
    
    public ClCaracteristicas(int idCaracteristica) {
        setIdCaracteristica(idCaracteristica);
    }
    
    public ClCaracteristicas(int idCaracteristica, int idTipoCaract, int cantidad, String tipo) {
        setIdCaracteristica(idCaracteristica);
        setIdTipoCaract(idTipoCaract);
        setCantidad(cantidad);
        setTipo(tipo);
    }
    public ClCaracteristicas(int idTipoCaract, int cantidad, String tipo) {
        setIdTipoCaract(idTipoCaract);
        setCantidad(cantidad);
        setTipo(tipo);
    }
    public ClCaracteristicas() {
    }

    public ClCaracteristicas(int idCaracteristica, int idTipoCaract, int cantidad, String tipo, String nombre, String descripcion) {
        setIdCaracteristica(idCaracteristica);
        setIdTipoCaract(idTipoCaract);
        setCantidad(cantidad);
        setTipo(tipo);
        setNombre(nombre);
        setDescripcion(descripcion);
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

    
    public int getIdCaracteristica() {
        return idCaracteristica;
    }

    public void setIdCaracteristica(int idCaracteristica) {
        this.idCaracteristica = idCaracteristica;
    }

    public int getIdTipoCaract() {
        return idTipoCaract;
    }

    public void setIdTipoCaract(int idTipoCaract) {
        this.idTipoCaract = idTipoCaract;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    @Override
    public String toString(){
        return getNombre();
    }
}

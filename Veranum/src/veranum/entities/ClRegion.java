/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.entities;

/**
 *
 * @author Zacarias
 */
public class ClRegion {

    private int idRegion;
    private String nombre;
    private String ordinal;
    
    public ClRegion() {

    }
    
    public ClRegion(String nombre, String ordinal) {
        setNombre(nombre);
        setOrdinal(ordinal);
    }
    
    public ClRegion(int idRegion, String nombre, String ordinal) {
        setIdRegion(idRegion);
        setNombre(nombre);
        setOrdinal(ordinal);
    }

    public String getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(String ordinal) {
        this.ordinal = ordinal;
    }
    
    public ClRegion( String nombre) {
        setNombre(nombre);
    }
    
    public ClRegion(int idRegion) {
        this.idRegion = idRegion;        
    }
    
    public int getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(int idRegion) {
        this.idRegion = idRegion;
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

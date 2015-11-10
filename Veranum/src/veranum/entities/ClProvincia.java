/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.entities;

/**
 *
 * @author Zacarias
 */
public class ClProvincia {

    private int idProvincia;
    private String nombre;
    private int idRegion;
    
    public ClProvincia() {

    }
    
    public ClProvincia(int idRegion) {
        setIdRegion(idRegion);
    }
    
    public ClProvincia(String nombre, int idRegion) {
        setNombre(nombre);
        setIdRegion(idRegion);
    }
    
    public ClProvincia(String nombre) {
        setNombre(nombre);
    }
    
    public ClProvincia(int idProvincia, String nombre, int idRegion) {
        setIdProvincia(idProvincia);
        setNombre(nombre);
        setIdRegion(idRegion);
    }
    
    
    public int getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(int idProvincia) {
        this.idProvincia = idProvincia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(int idRegion) {
        this.idRegion = idRegion;
    }

    @Override
    public String toString(){
        return getNombre();
    }
    
    
}

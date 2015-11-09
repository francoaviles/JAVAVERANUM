/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.entities;

/**
 *
 * @author Zacarias
 */
public class ClComuna {
    private int idComuna;
    private String nombre;
    private int idProvincia;

    public ClComuna() {

    }
    
    public ClComuna(String nombre, int idProvincia) {
        setNombre(nombre);
        setIdProvincia(idProvincia);
    }
    
    public ClComuna(String nombre) {
        setNombre(nombre);
    }
    
    public ClComuna(int idComuna, String nombre, int idProvincia) {
        setIdComuna(idComuna);
        setNombre(nombre);
        setIdProvincia(idProvincia);
    }

    public int getIdComuna() {
        return idComuna;
    }

    public void setIdComuna(int idComuna) {
        this.idComuna = idComuna;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(int idProvincia) {
        this.idProvincia = idProvincia;
    }
    
    @Override
    public String toString(){
        return getNombre();
    }
    
}

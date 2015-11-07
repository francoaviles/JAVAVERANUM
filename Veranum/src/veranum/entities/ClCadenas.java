/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.entities;

/**
 *
 * @author Zacarias
 */
public class ClCadenas {
    private int idCadena;
    private String nombre;

    public ClCadenas(int idCadena, String nombre) {
        setIdCadena(idCadena);
        setNombre(nombre);
    }
    public ClCadenas() {

    }
    public ClCadenas(String nombre) {
    }

    public int getIdCadena() {
        return idCadena;
    }

    public void setIdCadena(int idCadena) {
        this.idCadena = idCadena;
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

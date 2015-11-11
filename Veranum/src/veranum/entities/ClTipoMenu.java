/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.entities;

/**
 *
 * @author Zacarias
 */
public class ClTipoMenu {
    private int idTipoMenu;
    private String nombre;

    public ClTipoMenu() {

    }
    
    public ClTipoMenu(int idTipoMenu) {
        setIdTipoMenu(idTipoMenu);
    }
    
    public ClTipoMenu(String nombre) {
        setNombre(nombre);
    }
    
    public ClTipoMenu(int idTipoMenu, String nombre) {
        setIdTipoMenu(idTipoMenu);
        setNombre(nombre);
    }

    public int getIdTipoMenu() {
        return idTipoMenu;
    }

    public void setIdTipoMenu(int idTipoMenu) {
        this.idTipoMenu = idTipoMenu;
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

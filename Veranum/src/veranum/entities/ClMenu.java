/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.entities;

/**
 *
 * @author Zacarias
 */
public class ClMenu {
    private int idMenu;
    private int tipoMenu;
    private String nombre;
    private int precio;

    public ClMenu() {

    }
    
    public ClMenu(int idMenu) {
        setIdMenu(idMenu);
    }
    
    public ClMenu(String nombre) {
        setNombre(nombre);
    }
    
    public ClMenu(int tipoMenu, String nombre, int precio) {
        setTipoMenu(tipoMenu);
        setNombre(nombre);
        setPrecio(precio);
    }
    
    public ClMenu(int idMenu, int tipoMenu, String nombre,int precio) {
        setIdMenu(idMenu);
        setTipoMenu(tipoMenu);
        setNombre(nombre);
        setPrecio(precio);
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public int getTipoMenu() {
        return tipoMenu;
    }

    public void setTipoMenu(int tipoMenu) {
        this.tipoMenu = tipoMenu;
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

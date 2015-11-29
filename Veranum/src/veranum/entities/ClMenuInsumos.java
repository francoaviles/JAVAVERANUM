/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.entities;

/**
 *
 * @author Zacarias
 */
public class ClMenuInsumos {

    private int idMenuInsumo;
    private int idInsumo;
    private int idMenu;
    private int idMedida;
    private int cantidad;

    public ClMenuInsumos() {
    }    
    
    public ClMenuInsumos(int idMenuInsumo) {
        setIdMenuInsumo(idMenuInsumo);
    }

 public ClMenuInsumos(int idInsumo, int idMenu, int idMedida, int cantidad) {
        setIdInsumo(idInsumo);
        setIdMenu(idMenu);
        setIdMedida(idMedida);
        setCantidad(cantidad);
    }      
        
    public ClMenuInsumos(int idMenuInsumo, int idInsumo, int idMenu, int idMedida, int cantidad) {
        setIdMenuInsumo(idMenuInsumo);
        setIdInsumo(idInsumo);
        setIdMenu(idMenu);
        setIdMedida(idMedida);
        setCantidad(cantidad);
    }    
    
    public int getIdMenuInsumo() {
        return idMenuInsumo;
    }

    public void setIdMenuInsumo(int idMenuInsumo) {
        this.idMenuInsumo = idMenuInsumo;
    }

    public int getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(int idInsumo) {
        this.idInsumo = idInsumo;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public int getIdMedida() {
        return idMedida;
    }

    public void setIdMedida(int idMedida) {
        this.idMedida = idMedida;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
                
}

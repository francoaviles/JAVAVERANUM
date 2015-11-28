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
public class ClHotelTipoMenu {
    private int idHotel;
    private int idMenu;

    public ClHotelTipoMenu() {
    }
    
    public ClHotelTipoMenu(int idHotel) {
        setIdHotel(idHotel);
    }
    
    public ClHotelTipoMenu(int idHotel, int idMenu) {
        setIdHotel(idHotel);
        setIdMenu(idMenu);
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }
    
}

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
    private int idTipoMenu;

    public ClHotelTipoMenu() {
    }
    
    public ClHotelTipoMenu(int idHotel) {
        setIdHotel(idHotel);
    }
    
    public ClHotelTipoMenu(int idHotel, int idTipoMenu) {
        setIdHotel(idHotel);
        setIdTipoMenu(idTipoMenu);
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    public int getIdTipoMenu() {
        return idTipoMenu;
    }

    public void setIdTipoMenu(int idTipoMenu) {
        this.idTipoMenu = idTipoMenu;
    }
    
}

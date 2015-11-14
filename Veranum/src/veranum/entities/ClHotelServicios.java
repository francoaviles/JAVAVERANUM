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
public class ClHotelServicios {
    private int idHotel;
    private int idServicio;

    public ClHotelServicios() {
    }

    public ClHotelServicios(int idHotel) {
        setIdHotel(idHotel);
    }

    public ClHotelServicios(int idHotel, int idServicio) {
        setIdHotel(idHotel);
        setIdServicio(idServicio);
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }
    
    
}

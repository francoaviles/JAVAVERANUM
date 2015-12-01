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
public class ClHotelCaract {
    private int id_hotel;
    private int id_caract;
    private String tipo;
    private String hotel;

    public ClHotelCaract() {
    }
    public ClHotelCaract(int id_hotel) {
        setId_hotel(id_hotel);
    }
    
    public ClHotelCaract(int id_hotel, int id_caract) {
        setId_hotel(id_hotel);
        setId_caract(id_caract);
    }

    public ClHotelCaract(int id_hotel, int id_caract, String tipo, String hotel) {
        setId_hotel(id_hotel);
        setId_caract(id_caract);
        setHotel(hotel);
        setTipo(tipo);
    }

    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }
    
    

    public int getId_hotel() {
        return id_hotel;
    }

    public void setId_hotel(int id_hotel) {
        this.id_hotel = id_hotel;
    }

    public int getId_caract() {
        return id_caract;
    }

    public void setId_caract(int id_caract) {
        this.id_caract = id_caract;
    }
    
    
}

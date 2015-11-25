/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.entities;

import veranum.DAO.DAOServicios;

/**
 *
 * @author Zacarias
 */
public class ClHotelServicios {
    private int idHotel;
    private int idServicio;
    private String nombreServicio;
    private int precioServicio;

    public ClHotelServicios() {
    }

    public ClHotelServicios(int idHotel) {
        setIdHotel(idHotel);
    }

    public ClHotelServicios(int idHotel, int idServicio) {
        setIdHotel(idHotel);
        setIdServicio(idServicio);
    }

    public ClHotelServicios(int idHotel, int idServicio, String nombreServicio, int precioServicio) {
        setIdHotel(idHotel);
        setIdServicio(idServicio);
        setNombreServicio(nombreServicio);
        setPrecioServicio(precioServicio);
    }

    
    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public int getPrecioServicio() {
        return precioServicio;
    }

    public void setPrecioServicio(int precioServicio) {
        this.precioServicio = precioServicio;
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
    
    @Override
    public String toString(){
        ClServicios servicio = DAOServicios.sqlLeer(this.idServicio);
        return servicio.getNombre() + " - $"+servicio.getPrecio();
    }
    
    
}

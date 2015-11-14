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
public class ClHotelInsumos {
    private int idInsumoHotel;
    private int idInsumo;
    private int idHotel;
    private int idMedida;
    private int stock;

    public ClHotelInsumos() {
    }
    
    public ClHotelInsumos(int idInsumoHotel) {
        setIdInsumoHotel(idInsumoHotel);
    }
    
    public ClHotelInsumos(int idInsumo, int idHotel, int idMedida, int stock) {
        setIdInsumo(idInsumo);
        setIdHotel(idHotel);
        setIdMedida(idMedida);
        setStock(stock);
    }
    
    public ClHotelInsumos(int idInsumoHotel, int idInsumo, int idHotel, int idMedida, int stock) {
        setIdInsumoHotel(idInsumoHotel);
        setIdInsumo(idInsumo);
        setIdHotel(idHotel);
        setIdMedida(idMedida);
        setStock(stock);
    }

    public int getIdInsumoHotel() {
        return idInsumoHotel;
    }

    public void setIdInsumoHotel(int idInsumoHotel) {
        this.idInsumoHotel = idInsumoHotel;
    }

    public int getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(int idInsumo) {
        this.idInsumo = idInsumo;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    public int getIdMedida() {
        return idMedida;
    }

    public void setIdMedida(int idMedida) {
        this.idMedida = idMedida;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    
}

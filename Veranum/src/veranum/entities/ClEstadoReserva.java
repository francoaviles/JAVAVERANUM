/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.entities;

/**
 *
 * @author carlosdlg
 */
public class ClEstadoReserva {
    private int idReserva;
    private String nombre;

    public ClEstadoReserva() {
    }

    public ClEstadoReserva(int idReserva, String nombre) {
        setIdReserva(idReserva);
        setNombre(nombre);
    }

    public ClEstadoReserva(int idReserva) {
        setIdReserva(idReserva);
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
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

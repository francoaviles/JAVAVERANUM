/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.entities;

import java.util.Date;

/**
 *
 * @author carlosdlg
 */
public class ClConsultarReserva {
    private String rut;
    private int id_reserva;
    private Date fechaIngreso;
    private Date fechaSalida;
    private int precioTotal;
    private String estado;
    private int cantServicios;
    private int cantHabs;

    public ClConsultarReserva(String rut, int id_reserva, Date fechaIngreso, Date fechaSalida, int precioTotal, String estado, int cantServicios, int cantHabs) {
        setCantHabs(cantHabs);
        setCantServicios(cantServicios);
        setEstado(estado);
        setFechaIngreso(fechaIngreso);
        setFechaSalida(fechaSalida);
        setId_reserva(id_reserva);
        setPrecioTotal(precioTotal);
        setRut(rut);
    }

    
    
    
    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public int getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(int precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCantServicios() {
        return cantServicios;
    }

    public void setCantServicios(int cantServicios) {
        this.cantServicios = cantServicios;
    }

    public int getCantHabs() {
        return cantHabs;
    }

    public void setCantHabs(int cantHabs) {
        this.cantHabs = cantHabs;
    }
    
    
}

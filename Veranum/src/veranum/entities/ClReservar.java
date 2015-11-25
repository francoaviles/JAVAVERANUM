/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.entities;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author carlosdlg
 */
public class ClReservar {
    private ClPasajeros usuario;
    private ArrayList<ClHabitaciones> reservas = new ArrayList<>(); 
    private ArrayList<ClServicios> servicios = new ArrayList<>(); 
    private ClEstadoReserva estado;
    private Date fechaIngreso;
    private Date fechaSalida;
    private long dias;
    private long totalxnoche;
    private long total;

    public ClReservar(ClPasajeros usuario, ArrayList<ClHabitaciones> reservas, ArrayList<ClServicios> servicios, Date fechaIngreso, Date fechaSalida, long dias, long totalxnoche, long total) {
        setUsuario(usuario);
        setFechaIngreso(fechaIngreso);
        setFechaSalida(fechaSalida);
        setTotal(total);
        setDias(dias);
        setTotalxnoche(totalxnoche);
        setServicios(servicios);
        setReservas(reservas);
    }

    public ClReservar(ClPasajeros usuario, ArrayList<ClHabitaciones> reservas, Date fechaIngreso, Date fechaSalida, long dias, long totalxnoche, long total) {
        setUsuario(usuario);
        setFechaIngreso(fechaIngreso);
        setFechaSalida(fechaSalida);
        setTotal(total);
        setDias(dias);
        setTotalxnoche(totalxnoche);
        setReservas(reservas);
    }

    public ClEstadoReserva getEstado() {
        return estado;
    }

    public void setEstado(ClEstadoReserva estado) {
        this.estado = estado;
    }

    
    public ClReservar() {
    }

    public ArrayList<ClHabitaciones> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<ClHabitaciones> reservas) {
        this.reservas = reservas;
    }

    public ArrayList<ClServicios> getServicios() {
        return servicios;
    }

    public void setServicios(ArrayList<ClServicios> servicios) {
        this.servicios = servicios;
    }
    
    
    
    public ClPasajeros getUsuario() {
        return usuario;
    }

    public void setUsuario(ClPasajeros usuario) {
        this.usuario = usuario;
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

    public long getDias() {
        return dias;
    }

    public void setDias(long dias) {
        this.dias = dias;
    }

    public long getTotalxnoche() {
        return totalxnoche;
    }

    public void setTotalxnoche(long totalxnoche) {
        this.totalxnoche = totalxnoche;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
    
}

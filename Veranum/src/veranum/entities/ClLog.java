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
public class ClLog {
    private int idLog;
    private int idPasajero;
    private Date fecha;
    private String tipo;
    private String consulta;
    private String nombre;
    private String rut;
    private String rol;

    public ClLog(int idLog, int idPasajero, Date fecha, String tipo, String consulta, String nombre, String rut, String rol) {
        setConsulta(consulta);
        setFecha(fecha);
        setIdLog(idLog);
        setIdPasajero(idPasajero);
        setNombre(nombre);
        setRol(rol);
        setRut(rut);
        setTipo(tipo);
    }

        
    public int getIdLog() {
        return idLog;
    }

    public void setIdLog(int idLog) {
        this.idLog = idLog;
    }

    public int getIdPasajero() {
        return idPasajero;
    }

    public void setIdPasajero(int idPasajero) {
        this.idPasajero = idPasajero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getConsulta() {
        return consulta;
    }

    public void setConsulta(String consulta) {
        this.consulta = consulta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    
}

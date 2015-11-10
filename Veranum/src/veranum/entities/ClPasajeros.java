/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.entities;

import java.util.Date;

/**
 *
 * @author Zacarias
 */
public class ClPasajeros {
    private int idPasajero;
    private String rut;
    private String nombre;
    private String contrasena;
    private String apellido_pa;
    private String apellido_ma;
    private String telefono;
    private String email;
    private int idRegion;
    private int idProvincia;
    private int idComuna;
    private String direccion;
    private Date fechaNacimiento;
    private int idRol;

    //vacio 
    public ClPasajeros() { 

    }
    
    public ClPasajeros(int idPasajero) {
        setIdPasajero(idPasajero);
    }
    
    // usuarios insert
    public ClPasajeros(String rut, String nombre, String contrasena, String apellido_pa, String apellido_ma, String telefono, String email, String direccion, Date fechaNacimiento, int idRol) {
        setRut(rut);
        setNombre(nombre);
        setContrasena(contrasena);
        setApellido_pa(apellido_pa);
        setApellido_ma(apellido_ma);
        setTelefono(telefono);
        setEmail(email);
        setDireccion(direccion);
        setFechaNacimiento(fechaNacimiento);
        setIdRol(idRol);
    }
    
    public ClPasajeros(int idPasajero, String rut, String nombre, String contrasena, String apellido_pa, String apellido_ma, String telefono, String email, String direccion, Date fechaNacimiento, int idRol) {
        setIdPasajero(idPasajero);
        setRut(rut);
        setNombre(nombre);
        setContrasena(contrasena);
        setApellido_pa(apellido_pa);
        setApellido_ma(apellido_ma);
        setTelefono(telefono);
        setEmail(email);
        setDireccion(direccion);
        setFechaNacimiento(fechaNacimiento);
        setIdRol(idRol);
    }
    
    // clientes
    public ClPasajeros(int idPasajero, String rut, String nombre,String apellido_pa, String apellido_ma, String telefono, String email, String direccion, Date fechaNacimiento) {
        setIdPasajero(idPasajero);
        setRut(rut);
        setNombre(nombre);
        setApellido_pa(apellido_pa);
        setApellido_ma(apellido_ma);
        setTelefono(telefono);
        setEmail(email);
        setDireccion(direccion);
        setFechaNacimiento(fechaNacimiento);
    }
    
    public ClPasajeros(String rut, String contrasena) {
        setRut(rut);
        setContrasena(contrasena);
    }

    public int getIdPasajero() {
        return idPasajero;
    }

    public void setIdPasajero(int idPasajero) {
        this.idPasajero = idPasajero;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getApellido_pa() {
        return apellido_pa;
    }

    public void setApellido_pa(String apellido_pa) {
        this.apellido_pa = apellido_pa;
    }

    public String getApellido_ma() {
        return apellido_ma;
    }

    public void setApellido_ma(String apellido_ma) {
        this.apellido_ma = apellido_ma;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(int idRegion) {
        this.idRegion = idRegion;
    }

    public int getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(int idProvincia) {
        this.idProvincia = idProvincia;
    }

    public int getIdComuna() {
        return idComuna;
    }

    public void setIdComuna(int idComuna) {
        this.idComuna = idComuna;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }
    
    @Override
    public String toString(){
        return getNombre();
    }
}

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
public class ClEmpresa {
    private int idEmpresa;
    private String nombre;
    private int descuento;

    
    public ClEmpresa(){
    }
        
    public ClEmpresa(int idEmpresa) {
        setIdEmpresa(idEmpresa);
    }
    
    public ClEmpresa(String nombre, int descuento) {
        setNombre(nombre);
        setDescuento(descuento);
    }
    
    public ClEmpresa(int idEmpresa, String nombre, int descuento) {
        setIdEmpresa(idEmpresa);
        setNombre(nombre);
        setDescuento(descuento);
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String noombre) {
        this.nombre = noombre;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }
    
    
    
}

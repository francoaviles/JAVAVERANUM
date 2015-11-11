/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.entities;

/**
 *
 * @author Zacarias
 */
public class ClHoteles {
    private int idHotel;
    private int idCadena;
    private int idRegion;
    private int idProvincia;
    private int idComuna;
    private String nombre;
    private String direccion;

    public ClHoteles() {

    }
    
    public ClHoteles(int idHotel) {
        setIdHotel(idHotel);
    }
    
    public ClHoteles(int idCadena, int idRegion, int idProvincia, int idComuna, String nombre, String direccion) {
        setIdCadena(idCadena);
        setIdRegion(idRegion);
        setIdProvincia(idProvincia);
        setIdComuna(idComuna);
        setNombre(nombre);
        setDireccion(direccion);
    }
    
    public ClHoteles(int idHotel, int idCadena, int idRegion, int idProvincia, int idComuna, String nombre, String direccion) {
        setIdHotel(idHotel);
        setIdCadena(idCadena);
        setIdRegion(idRegion);
        setIdProvincia(idProvincia);
        setIdComuna(idComuna);
        setNombre(nombre);
        setDireccion(direccion);
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    public int getIdCadena() {
        return idCadena;
    }

    public void setIdCadena(int idCadena) {
        this.idCadena = idCadena;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    @Override
    public String toString(){
        return getNombre();
    }
}

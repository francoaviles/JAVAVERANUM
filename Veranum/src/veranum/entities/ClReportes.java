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
public class ClReportes {
    private int idReporte;
    private int idTipoReporte;
    private Date fechaCreacion;
    private String archivo;
    private String comentario;

    public ClReportes() {

    }
    
    public ClReportes(int idReporte) {
        setIdReporte(idReporte);
    }
    
    public ClReportes( Date fechaCreacion, int idTipoReporte, String archivo, String comentario) {
        setFechaCreacion(fechaCreacion);
        setIdTipoReporte(idTipoReporte);
        setArchivo(archivo);
        setComentario(comentario);
    }
    
    
    
    public ClReportes(int idReporte, Date fechaCreacion, int idTipoReporte, String archivo, String comentario) {
        setIdReporte(idReporte);
        setFechaCreacion(fechaCreacion);
        setIdTipoReporte(idTipoReporte);
        setArchivo(archivo);
        setComentario(comentario);
    }

    public int getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(int idReporte) {
        this.idReporte = idReporte;
    }

    public int getIdTipoReporte() {
        return idTipoReporte;
    }

    public void setIdTipoReporte(int idTipoReporte) {
        this.idTipoReporte = idTipoReporte;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
    
}

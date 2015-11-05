/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.DAO;

import java.util.ArrayList;
import veranum.entities.ClReportes;
import veranum.utilidades.OracleConection;

/**
 *
 * @author Zacarias
 */
public class DAOReportes {
    private static final OracleConection bd = new OracleConection().Conectar();
    
    public static boolean sqlInsert(ClReportes reportes){
        String sql="INSERT INTO \"reportes\" (\"id_tipo_reporte\", \"fecha_creacion\", \"archivo\", \"comentario\" ) VALUES ('"+reportes.getIdTipoReporte()+"','"+reportes.getFechaCreacion()+"','"+reportes.getArchivo()+"','"+reportes.getComentario()+"')";
        bd.sqlEjecutar(sql);
        return true;
    }
    
    public static boolean sqlDelete(ClReportes reportes){
        String sql="DELETE FROM \"reportes\" WHERE \"id_reporte\" = '"+reportes.getIdReporte()+"'";
        bd.sqlEjecutar(sql);   
        return true;
    }
    
    public static boolean sqlUpdate(ClReportes reportes){
        String sql="UPDATE \"reportes\" SET \"id_tipo_reporte\" = '"+reportes.getIdTipoReporte()+"' AND \"fecha_creacion\" = '"+reportes.getFechaCreacion()+"' AND \"archivo\" = '"+reportes.getArchivo()+"' AND \"comentario\" = '"+reportes.getComentario()+"' WHERE \"id_reporte\" = '"+reportes.getIdReporte()+"'";
        bd.sqlEjecutar(sql);   
        return true;
    }
    
    public ClReportes sqlLeer(int id){     
        ClReportes reportes = new ClReportes();        
        if(!bd.sqlSelect("SELECT * FROM \"reportes\" WHERE \"id_reporte\" = "+id+" ")){
            return null;
        }        
        if(!bd.sqlFetch()){
            return null;
        }        
        reportes.setIdReporte(bd.getInt("id_reporte"));
        reportes.setIdTipoReporte(bd.getInt("id_tipo_reporte"));
        //reportes.setFechaCreacion(bd.getString("fecha_creacion"));
        reportes.setArchivo(bd.getString("archivo"));
        reportes.setComentario(bd.getString("comentario"));
        return reportes;
    }
    /*
    public static ArrayList sqlLeerTodos(){
        ArrayList<ClReportes> reportes = new ArrayList<>();        
        if(!bd.sqlSelect("SELECT * FROM \"reportes\"")){
            return null;
        }
        while(bd.sqlFetch()){
            reportes.add(new ClReportes(bd.getInt("id_reporte")
                                    , bd.getString("id_tipo_reporte")
                                    //, bd.getString("fecha_creacion")
                                    , bd.getString("archivo")
                                    , bd.getString("comentario")
                                ));
            
        }     
        return reportes;
    }  
    * */
}

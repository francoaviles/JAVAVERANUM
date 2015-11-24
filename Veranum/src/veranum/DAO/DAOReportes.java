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
    public static boolean sqlInsert(ClReportes reportes){
        String sql="INSERT INTO \"reportes\" (\"id_tipo_reporte\", \"fecha_creacion\", \"archivo\", \"comentario\" ) VALUES ('"+reportes.getIdTipoReporte()+"','"+reportes.getFechaCreacion()+"','"+reportes.getArchivo()+"','"+reportes.getComentario()+"')";
        OracleConection.getInstance().sqlEjecutar(sql);
        return true;
    }
    
    public static boolean sqlDelete(ClReportes reportes){
        String sql="DELETE FROM \"reportes\" WHERE \"id_reporte\" = "+reportes.getIdReporte()+"";
        OracleConection.getInstance().sqlEjecutar(sql);   
        return true;
    }
    
    public static boolean sqlUpdate(ClReportes reportes){
        String sql="UPDATE \"reportes\" SET \"id_tipo_reporte\" = '"+reportes.getIdTipoReporte()+"', \"fecha_creacion\" = '"+reportes.getFechaCreacion()+"', \"archivo\" = '"+reportes.getArchivo()+"', \"comentario\" = '"+reportes.getComentario()+"' WHERE \"id_reporte\" = "+reportes.getIdReporte()+"";
        OracleConection.getInstance().sqlEjecutar(sql);   
        return true;
    }
    
    public static ClReportes sqlLeer(int id){     
        ClReportes reportes = new ClReportes();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"reportes\" WHERE \"id_reporte\" ='"+id+"'")){
            return null;
        }        
        if(!OracleConection.getInstance().sqlFetch()){
            return null;
        }        
        reportes.setIdReporte(OracleConection.getInstance().getInt("id_reporte"));
        reportes.setIdTipoReporte(OracleConection.getInstance().getInt("id_tipo_reporte"));
        reportes.setFechaCreacion(OracleConection.getInstance().getDate("fecha_creacion"));
        reportes.setArchivo(OracleConection.getInstance().getString("archivo"));
        reportes.setComentario(OracleConection.getInstance().getString("comentario"));
        return reportes;
    }
    
    public static ArrayList sqlLeerTodos(){
        ArrayList<ClReportes> reportes = new ArrayList<>();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"reportes\"")){
            return null;
        }
        while(OracleConection.getInstance().sqlFetch()){
            reportes.add(new ClReportes(OracleConection.getInstance().getInt("id_reporte")
                                    , OracleConection.getInstance().getDate("fecha_creacion")
                                    , OracleConection.getInstance().getInt("id_tipo_reporte")
                                    , OracleConection.getInstance().getString("archivo")
                                    , OracleConection.getInstance().getString("comentario")
                                ));
            
        }     
        return reportes;
    }
    
    public static ArrayList sqlBuscarByNombre(String archivo){
        ArrayList<ClReportes> reportes = new ArrayList<>();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"reportes\" WHERE \"archivo\" LIKE '%"+archivo+"%'")){
            return null;
        }
        while(OracleConection.getInstance().sqlFetch()){
            reportes.add(new ClReportes(OracleConection.getInstance().getInt("id_reporte")
                                    , OracleConection.getInstance().getDate("fecha_creacion")
                                    , OracleConection.getInstance().getInt("id_tipo_reporte")
                                    , OracleConection.getInstance().getString("archivo")
                                    , OracleConection.getInstance().getString("comentario")
                                ));
            
        }     
        return reportes;
    }
    
    
}

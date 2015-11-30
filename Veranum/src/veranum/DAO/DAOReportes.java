/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import veranum.entities.ClReportes;
import veranum.utilidades.OracleConection;

/**
 *
 * @author Zacarias
 */
public class DAOReportes {
    public static boolean sqlInsert(ClReportes reportes) throws SQLException{
        String sql="INSERT INTO \"reportes\" (\"id_tipo_reporte\", \"fecha_creacion\", \"archivo\", \"comentario\" ) VALUES (?,?,?,?)";
        PreparedStatement a = OracleConection.getInstance().sqlPreparar(sql);
        a.setInt(1, reportes.getIdTipoReporte());
        a.setDate(2, (new java.sql.Date(reportes.getFechaCreacion().getTime())));
        a.setString(3, reportes.getArchivo());
        a.setString(4, reportes.getComentario());
        
        return OracleConection.getInstance().sqlEjecutarPreparacion();
    }
    
    public static boolean sqlDelete(ClReportes reportes){
        String sql="DELETE FROM \"reportes\" WHERE \"id_reporte\" = "+reportes.getIdReporte()+"";
         
        return OracleConection.getInstance().sqlEjecutar(sql);  
    }
    
    public static boolean sqlUpdate(ClReportes reportes) throws SQLException{
        String sql="UPDATE \"reportes\" SET \"id_tipo_reporte\" = ?, \"fecha_creacion\" = ?, \"archivo\" = ?, \"comentario\" = ? WHERE \"id_reporte\" = ?";
        PreparedStatement a = OracleConection.getInstance().sqlPreparar(sql);
        a.setInt(1, reportes.getIdTipoReporte());
        a.setDate(2, (new java.sql.Date(reportes.getFechaCreacion().getTime())));
        a.setString(3, reportes.getArchivo());
        a.setString(4, reportes.getComentario());
        a.setInt(5, reportes.getIdReporte());
        
        return OracleConection.getInstance().sqlEjecutarPreparacion(); 
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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import veranum.entities.ClHabitacionInspecciones;
import veranum.utilidades.OracleConection;

/**
 *
 * @author Zacarias
 */
public class DAOInspecciones {
    public static boolean sqlInsert(ClHabitacionInspecciones inspecciones) throws SQLException{
        String sql="INSERT INTO \"habitacion_inspecciones\" (\"id_habitacion\", \"fecha_inicio\", \"comentario\", \"nombre_inspector\" ) VALUES (?,?,?,?)";
        PreparedStatement a = OracleConection.getInstance().sqlPreparar(sql);
        a.setInt(1, inspecciones.getIdHabitacion());
        a.setDate(2, (new java.sql.Date(inspecciones.getFechaInicio().getTime())));
        a.setString(3, inspecciones.getComentario());
        a.setString(4, inspecciones.getNombreInspector());
        
        return OracleConection.getInstance().sqlEjecutarPreparacion();
    }
    
    public static boolean sqlDelete(ClHabitacionInspecciones inspecciones){
        String sql="DELETE FROM \"habitacion_inspecciones\" WHERE \"id_habitacion_inspeccion\" = "+inspecciones.getIdHabitacionInspeccion()+"";
         
        return OracleConection.getInstance().sqlEjecutar(sql);  
    }
    
    public static boolean sqlUpdate(ClHabitacionInspecciones inspecciones) throws SQLException{
        String sql="UPDATE \"habitacion_inspecciones\" SET \"id_habitacion\" = ?, \"fecha_inicio\" = ?, \"comentario\" = ?, \"nombre_inspector\" = ? WHERE \"id_habitacion_inspeccion\" = ?";
        PreparedStatement a = OracleConection.getInstance().sqlPreparar(sql);
        a.setInt(1, inspecciones.getIdHabitacion());
        a.setDate(2, (new java.sql.Date(inspecciones.getFechaInicio().getTime())));
        a.setString(3, inspecciones.getComentario());
        a.setString(4, inspecciones.getNombreInspector());
        a.setInt(5, inspecciones.getIdHabitacionInspeccion());
        
        return OracleConection.getInstance().sqlEjecutarPreparacion();
    }
    
    public static ClHabitacionInspecciones sqlLeer(int id){     
        ClHabitacionInspecciones inspecciones = new ClHabitacionInspecciones();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"habitacion_inspecciones\" WHERE \"id_habitacion\" ='"+id+"'")){
            return null;
        }        
        if(!OracleConection.getInstance().sqlFetch()){
            return null;
        }        
        inspecciones.setIdHabitacionInspeccion(OracleConection.getInstance().getInt("id_habitacion_inspeccion"));
        inspecciones.setIdHabitacion(OracleConection.getInstance().getInt("id_habitacion"));
        inspecciones.setFechaInicio(OracleConection.getInstance().getDate("fecha_inicio"));
        inspecciones.setComentario(OracleConection.getInstance().getString("comentario"));
        inspecciones.setNombreInspector(OracleConection.getInstance().getString("nombre_inspector"));
        return inspecciones;
    }
    
    public static ArrayList sqlLeerTodos(){
        ArrayList<ClHabitacionInspecciones> inspecciones = new ArrayList<>();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"habitacion_inspecciones\"")){
            return null;
        }
        while(OracleConection.getInstance().sqlFetch()){
            inspecciones.add(new ClHabitacionInspecciones(OracleConection.getInstance().getInt("id_habitacion_inspeccion")
                                    , OracleConection.getInstance().getInt("id_habitacion")
                                    , OracleConection.getInstance().getDate("fecha_inicio")
                                    , OracleConection.getInstance().getString("comentario")
                                    , OracleConection.getInstance().getString("nombre_inspector")
                                ));
        }     
        return inspecciones;
    }
    
    public static ArrayList sqlBuscarByNombre(String nombre){
        ArrayList<ClHabitacionInspecciones> inspecciones = new ArrayList<>();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"habitacion_inspecciones\" WHERE \"nombre_inspector\" LIKE '%"+nombre+"%'")){
            return null;
        }
        while(OracleConection.getInstance().sqlFetch()){
            inspecciones.add(new ClHabitacionInspecciones(OracleConection.getInstance().getInt("id_habitacion_inspeccion")
                                    , OracleConection.getInstance().getInt("id_habitacion")
                                    , OracleConection.getInstance().getDate("fecha_inicio")
                                    , OracleConection.getInstance().getString("comentario")
                                    , OracleConection.getInstance().getString("nombre_inspector")
                                ));
            
        }     
        return inspecciones;
    }
    
}

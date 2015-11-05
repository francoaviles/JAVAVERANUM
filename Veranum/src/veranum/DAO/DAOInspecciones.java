/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.DAO;

import veranum.entities.ClHabitacionInspecciones;
import veranum.utilidades.OracleConection;

/**
 *
 * @author Zacarias
 */
public class DAOInspecciones {
    private static final OracleConection bd = new OracleConection().Conectar();
    
    public static boolean sqlInsert(ClHabitacionInspecciones inspecciones){
        String sql="INSERT INTO \"habitacion_inspecciones\" (\"id_habitacion\", \"fecha_inicio\", \"comentario\", \"nombre_inspector\" ) VALUES ('"+inspecciones.getIdHabitacion()+"','"+inspecciones.getFechaInicio()+"','"+inspecciones.getComentario()+"','"+inspecciones.getNombreInspector()+"')";
        bd.sqlEjecutar(sql);
        return true;
    }
    
    public static boolean sqlDelete(ClHabitacionInspecciones inspecciones){
        String sql="DELETE FROM \"habitacion_inspecciones\" WHERE \"id_habitacion_inspeccion\" = '"+inspecciones.getIdHabitacionInspeccion()+"'";
        bd.sqlEjecutar(sql);   
        return true;
    }
    
    public static boolean sqlUpdate(ClHabitacionInspecciones inspecciones){
        String sql="UPDATE \"habitacion_inspecciones\" SET \"id_habitacion\" = '"+inspecciones.getIdHabitacion()+"' AND \"fecha_inicio\" = '"+inspecciones.getFechaInicio()+"' AND \"comentario\" = '"+inspecciones.getComentario()+"' AND \"nombre_inspector\" = '"+inspecciones.getNombreInspector()+"' WHERE \"id_habitacion_inspeccion\" = '"+inspecciones.getIdHabitacionInspeccion()+"'";
        bd.sqlEjecutar(sql);   
        return true;
    }
    
    public ClHabitacionInspecciones sqlLeer(int id){     
        ClHabitacionInspecciones inspecciones = new ClHabitacionInspecciones();        
        if(!bd.sqlSelect("SELECT * FROM \"habitacion_inspecciones\" WHERE \"id_habitacion_inspeccion\" = "+id+" ")){
            return null;
        }        
        if(!bd.sqlFetch()){
            return null;
        }        
        inspecciones.setIdHabitacionInspeccion(bd.getInt("id_habitacion_inspeccion"));
        inspecciones.setIdHabitacion(bd.getInt("id_habitacion"));
        //inspecciones.setFechaInicio(bd.getString("fecha_inicio"));
        inspecciones.setComentario(bd.getString("comentario"));
        inspecciones.setNombreInspector(bd.getString("nombre_inspector"));
        return inspecciones;
    }
    /*
    public static ArrayList sqlLeerTodos(){
        ArrayList<ClHabitacionInspecciones> inspecciones = new ArrayList<>();        
        if(!bd.sqlSelect("SELECT * FROM \"habitacion_inspecciones\"")){
            return null;
        }
        while(bd.sqlFetch()){
            inspecciones.add(new ClHabitacionInspecciones(bd.getInt("id_reporte")
                                    , bd.getString("id_tipo_reporte")
                                    //, bd.getString("fecha_creacion")
                                    , bd.getString("archivo")
                                    , bd.getString("comentario")
                                ));
            
        }     
        return inspecciones;
    }  
    * */
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.DAO;

import java.util.ArrayList;
import veranum.entities.ClHabitaciones;
import veranum.utilidades.OracleConection;

/**
 *
 * @author Zacarias
 */
public class DAOHabitaciones {
    private static final OracleConection bd = new OracleConection().Conectar();
    
    public static boolean sqlInsert(ClHabitaciones habitacion){
        String sql="INSERT INTO \"habitaciones\" (\"id_hotel\", \"id_habitacion_tipo\", \"id_habitacion_estado\", \"ubicacion\", \"cant_personas\", \"precio\") VALUES ('"+habitacion.getIdHotel()+"','"+habitacion.getIdHabitacionTipo()+"','"+habitacion.getIdHabitacionEstado()+"','"+habitacion.getUbicacion()+"','"+habitacion.getCantPersonas()+"','"+habitacion.getPrecio()+"')";
        bd.sqlEjecutar(sql);
        return true;
    }
    
    public static boolean sqlDelete(ClHabitaciones habitacion){
        String sql="DELETE FROM \"habitaciones\" WHERE \"id_habitacion\" = "+habitacion.getIdHabitacion()+"";
        bd.sqlEjecutar(sql);   
        return true;
    }
    
    public static boolean sqlUpdate(ClHabitaciones habitacion){
        String sql="UPDATE \"habitaciones\" SET \"id_hotel\" = '"+habitacion.getIdHotel()+"', \"id_habitacion_tipo\" = '"+habitacion.getIdHabitacionTipo()+"', \"id_habitacion_estado\" = '"+habitacion.getIdHabitacionEstado()+"', \"ubicacion\" = '"+habitacion.getUbicacion()+"', \"cant_personas\" = '"+habitacion.getCantPersonas()+"', \"precio\" = '"+habitacion.getPrecio()+"' WHERE \"id_habitacion\" = "+habitacion.getIdHabitacion()+"";
        bd.sqlEjecutar(sql);   
        return true;
    }
    
    public static ClHabitaciones sqlLeer(int id){     
        ClHabitaciones habitacion = new ClHabitaciones();        
        if(!bd.sqlSelect("SELECT * FROM \"habitaciones\" WHERE \"id_habitacion\" ='"+id+"'")){
            return null;
        }        
        if(!bd.sqlFetch()){
            return null;
        }        
        habitacion.setIdHabitacion(bd.getInt("id_habitacion"));
        habitacion.setIdHotel(bd.getInt("id_hotel"));
        habitacion.setIdHabitacionTipo(bd.getInt("id_habitacion_tipo"));
        habitacion.setIdHabitacionEstado(bd.getInt("id_habitacion_estado"));
        habitacion.setUbicacion(bd.getString("ubicacion"));
        habitacion.setCantPersonas(bd.getInt("cant_personas"));
        habitacion.setPrecio(bd.getInt("precio"));
        return habitacion;
    }
    
    public static ArrayList sqlLeerTodos(){
        ArrayList<ClHabitaciones> habitacion = new ArrayList<>();        
        if(!bd.sqlSelect("SELECT * FROM \"habitaciones\"")){
            return null;
        }
        while(bd.sqlFetch()){
            habitacion.add(new ClHabitaciones(bd.getInt("id_habitacion")
                                    , bd.getInt("id_hotel")
                                    , bd.getInt("id_habitacion_tipo")
                                    , bd.getInt("id_habitacion_estado")
                                    , bd.getString("ubicacion")
                                    , bd.getInt("cant_personas")
                                    , bd.getInt("precio")
                                ));
            
        }     
        return habitacion;
    }   
}

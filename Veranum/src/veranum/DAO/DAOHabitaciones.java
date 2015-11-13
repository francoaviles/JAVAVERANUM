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
    public static boolean sqlInsert(ClHabitaciones habitacion){
        String sql="INSERT INTO \"habitaciones\" (\"id_hotel\", \"id_habitacion_tipo\", \"id_habitacion_estado\", \"ubicacion\", \"cant_personas\", \"precio\") VALUES ('"+habitacion.getIdHotel()+"','"+habitacion.getIdHabitacionTipo()+"','"+habitacion.getIdHabitacionEstado()+"','"+habitacion.getUbicacion()+"','"+habitacion.getCantPersonas()+"','"+habitacion.getPrecio()+"')";
        OracleConection.getInstance().sqlEjecutar(sql);
        return true;
    }
    
    public static boolean sqlDelete(ClHabitaciones habitacion){
        String sql="DELETE FROM \"habitaciones\" WHERE \"id_habitacion\" = "+habitacion.getIdHabitacion()+"";
        OracleConection.getInstance().sqlEjecutar(sql);   
        return true;
    }
    
    public static boolean sqlUpdate(ClHabitaciones habitacion){
        String sql="UPDATE \"habitaciones\" SET \"id_hotel\" = '"+habitacion.getIdHotel()+"', \"id_habitacion_tipo\" = '"+habitacion.getIdHabitacionTipo()+"', \"id_habitacion_estado\" = '"+habitacion.getIdHabitacionEstado()+"', \"ubicacion\" = '"+habitacion.getUbicacion()+"', \"cant_personas\" = '"+habitacion.getCantPersonas()+"', \"precio\" = '"+habitacion.getPrecio()+"' WHERE \"id_habitacion\" = "+habitacion.getIdHabitacion()+"";
        OracleConection.getInstance().sqlEjecutar(sql);   
        return true;
    }
    
    public static ClHabitaciones sqlLeer(int id){     
        ClHabitaciones habitacion = new ClHabitaciones();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"habitaciones\" WHERE \"id_habitacion\" ="+id+"")){
            return null;
        }        
        if(!OracleConection.getInstance().sqlFetch()){
            return null;
        }        
        habitacion.setIdHabitacion(OracleConection.getInstance().getInt("id_habitacion"));
        habitacion.setIdHotel(OracleConection.getInstance().getInt("id_hotel"));
        habitacion.setIdHabitacionTipo(OracleConection.getInstance().getInt("id_habitacion_tipo"));
        habitacion.setIdHabitacionEstado(OracleConection.getInstance().getInt("id_habitacion_estado"));
        habitacion.setUbicacion(OracleConection.getInstance().getString("ubicacion"));
        habitacion.setCantPersonas(OracleConection.getInstance().getInt("cant_personas"));
        habitacion.setPrecio(OracleConection.getInstance().getInt("precio"));
        return habitacion;
    }
    
    public static ArrayList sqlLeerTodos(){
        ArrayList<ClHabitaciones> habitacion = new ArrayList<>();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"habitaciones\"")){
            return null;
        }
        while(OracleConection.getInstance().sqlFetch()){
            habitacion.add(new ClHabitaciones(OracleConection.getInstance().getInt("id_habitacion")
                                    , OracleConection.getInstance().getInt("id_hotel")
                                    , OracleConection.getInstance().getInt("id_habitacion_tipo")
                                    , OracleConection.getInstance().getInt("id_habitacion_estado")
                                    , OracleConection.getInstance().getString("ubicacion")
                                    , OracleConection.getInstance().getInt("cant_personas")
                                    , OracleConection.getInstance().getInt("precio")
                                ));
            
        }     
        return habitacion;
    }   
}

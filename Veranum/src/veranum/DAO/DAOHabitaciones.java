/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import veranum.entities.ClHabitaciones;
import veranum.utilidades.OracleConection;

/**
 *
 * @author Zacarias
 */
public class DAOHabitaciones {
    public static boolean sqlInsert(ClHabitaciones habitacion) throws SQLException{
        String sql="INSERT INTO \"habitaciones\" (\"id_hotel\", \"id_habitacion_tipo\", \"id_habitacion_estado\", \"ubicacion\", \"cant_personas\", \"precio\") VALUES (?,?,?,?,?,?)";
        PreparedStatement a = OracleConection.getInstance().sqlPreparar(sql);
        a.setInt(1, habitacion.getIdHotel());
        a.setInt(2, habitacion.getIdHabitacionTipo());
        a.setInt(3, habitacion.getIdHabitacionEstado());
        a.setString(4, habitacion.getUbicacion());
        a.setInt(5, habitacion.getCantPersonas());
        a.setInt(6, habitacion.getPrecio());        
        
        return OracleConection.getInstance().sqlEjecutarPreparacion();
    }
    
    public static boolean sqlDelete(ClHabitaciones habitacion){
        String sql="DELETE FROM \"habitaciones\" WHERE \"id_habitacion\" = "+habitacion.getIdHabitacion()+"";
        OracleConection.getInstance().sqlEjecutar(sql);   
        return OracleConection.getInstance().sqlEjecutar(sql);   
    }
    
    public static boolean sqlUpdate(ClHabitaciones habitacion) throws SQLException{
        String sql="UPDATE \"habitaciones\" SET \"id_hotel\" = ?, \"id_habitacion_tipo\" = ?, \"id_habitacion_estado\" = ?, \"ubicacion\" = ?, \"cant_personas\" = ?, \"precio\" = ? WHERE \"id_habitacion\" = ?";
        PreparedStatement a = OracleConection.getInstance().sqlPreparar(sql);
        a.setInt(1, habitacion.getIdHotel());
        a.setInt(2, habitacion.getIdHabitacionTipo());
        a.setInt(3, habitacion.getIdHabitacionEstado());
        a.setString(4, habitacion.getUbicacion());
        a.setInt(5, habitacion.getCantPersonas());
        a.setInt(6, habitacion.getPrecio());        
        a.setInt(7, habitacion.getIdHabitacion());
        
        return OracleConection.getInstance().sqlEjecutarPreparacion();  
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
    
    public static ArrayList sqlBuscarByNombre(String ubicacion){
        ArrayList<ClHabitaciones> habitaciones = new ArrayList<>();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"habitaciones\" WHERE \"ubicacion\" LIKE '%"+ubicacion+"'")){
            return null;
        }
        while(OracleConection.getInstance().sqlFetch()){
            habitaciones.add(new ClHabitaciones(OracleConection.getInstance().getInt("id_habitacion")
                                    , OracleConection.getInstance().getInt("id_hotel")
                                    , OracleConection.getInstance().getInt("id_habitacion_tipo")
                                    , OracleConection.getInstance().getInt("id_habitacion_estado")
                                    , OracleConection.getInstance().getString("ubicacion")
                                    , OracleConection.getInstance().getInt("cant_personas")
                                    , OracleConection.getInstance().getInt("precio")
                                ));
            
        }     
        return habitaciones;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.DAO;

import java.util.ArrayList;
import veranum.entities.ClHistorialPrecios;
import veranum.utilidades.OracleConection;

/**
 *
 * @author carlosdlg
 */
public class DAOHistorialPrecios {
    public static ArrayList sqlLeerTodos(){
        ArrayList<ClHistorialPrecios> datos = new ArrayList<>();
        if(!OracleConection.getInstance().sqlSelect("SELECT \"hoteles\".\"nombre\",\n" +
                            "\"historial_precios\".\"fecha\",\n" +
                            "\"historial_precios\".\"precio\",\n" +
                            "\"historial_precios\".\"nuevoprecio\",\n" +
                            "\"habitaciones\".\"ubicacion\",\n" +
                            "\"historial_precios\".\"id_historial_precio\",\n" +
                            "\"historial_precios\".\"id_habitacion\"\n" +
                            "FROM \"historial_precios\"\n" +
                            "LEFT JOIN \"habitaciones\" ON  \"historial_precios\".\"id_habitacion\" = \"habitaciones\".\"id_habitacion\"\n" +
                            "LEFT JOIN \"hoteles\" ON  \"hoteles\".\"id_hotel\" = \"habitaciones\".\"id_hotel\"")){
            return null;
        }
        while(OracleConection.getInstance().sqlFetch()){
            datos.add(new ClHistorialPrecios(
                                    OracleConection.getInstance().getInt("id_historial_precio"), 
                                    OracleConection.getInstance().getInt("id_habitacion"),
                                    OracleConection.getInstance().getInt("precio"), 
                                    OracleConection.getInstance().getInt("nuevoprecio"), 
                                    OracleConection.getInstance().getString("nombre"),
                                    OracleConection.getInstance().getInt("ubicacion"), 
                                    OracleConection.getInstance().getDate("fecha"))
                                );
        }     
        return datos;
    }
    
    
    public static ArrayList sqlByHotel(int id){
        ArrayList<ClHistorialPrecios> datos = new ArrayList<>();
        if(!OracleConection.getInstance().sqlSelect("SELECT \"hoteles\".\"nombre\",\n" +
                            "\"historial_precios\".\"fecha\",\n" +
                            "\"historial_precios\".\"precio\",\n" +
                            "\"historial_precios\".\"nuevoprecio\",\n" +
                            "\"habitaciones\".\"ubicacion\",\n" +
                            "\"historial_precios\".\"id_historial_precio\",\n" +
                            "\"historial_precios\".\"id_habitacion\"\n" +
                            "FROM \"historial_precios\"\n" +
                            "LEFT JOIN \"habitaciones\" ON  \"historial_precios\".\"id_habitacion\" = \"habitaciones\".\"id_habitacion\"\n" +
                            "LEFT JOIN \"hoteles\" ON  \"hoteles\".\"id_hotel\" = \"habitaciones\".\"id_hotel\" "
                + "WHERE \"hoteles\".\"id_hotel\" = "+id+" ")){
            return null;
        }
        while(OracleConection.getInstance().sqlFetch()){
            datos.add(new ClHistorialPrecios(
                                    OracleConection.getInstance().getInt("id_historial_precio"), 
                                    OracleConection.getInstance().getInt("id_habitacion"),
                                    OracleConection.getInstance().getInt("precio"), 
                                    OracleConection.getInstance().getInt("nuevoprecio"), 
                                    OracleConection.getInstance().getString("nombre"),
                                    OracleConection.getInstance().getInt("ubicacion"), 
                                    OracleConection.getInstance().getDate("fecha"))
                                );
        }     
        return datos;
    }
}

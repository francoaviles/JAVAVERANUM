/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.DAO;

import java.util.ArrayList;
import veranum.entities.ClHotelServicios;
import veranum.utilidades.OracleConection;

/**
 *
 * @author Zacarias
 */
public class DAOHotelServicio {
    public static boolean sqlInsert(ClHotelServicios hotelServicio){
        String sql="INSERT INTO \"hoteles_servicios\" (\"id_hotel\", \"id_servicio\") VALUES ('"+hotelServicio.getIdHotel()+"','"+hotelServicio.getIdServicio()+"')";
        OracleConection.getInstance().sqlEjecutar(sql);
        return true;
    }
    
    public static boolean sqlDelete(ClHotelServicios hotelServicio){
        String sql="DELETE FROM \"hoteles_servicios\" WHERE \"id_hotel\" = "+hotelServicio.getIdHotel()+"";
        OracleConection.getInstance().sqlEjecutar(sql);   
        return true;
    
    }
    
    public static boolean sqlUpdate(ClHotelServicios hotelServicio){
        String sql="UPDATE \"hoteles_servicios\" SET \"id_hotel\" = '"+hotelServicio.getIdHotel()+"', \"id_servicio\" = '"+hotelServicio.getIdServicio()+"' WHERE \"id_hotel\" = "+hotelServicio.getIdHotel()+"";
        OracleConection.getInstance().sqlEjecutar(sql);   
        return true;
    }
    
    public static ClHotelServicios sqlLeer(int id){     
        ClHotelServicios hotelServicio = new ClHotelServicios();
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"hoteles_servicios\" WHERE \"id_hotel\" ='"+id+"'")){
            return null;
        }        
        if(!OracleConection.getInstance().sqlFetch()){
            return null;
        }
        hotelServicio.setIdHotel(OracleConection.getInstance().getInt("id_hotel"));
        hotelServicio.setIdServicio(OracleConection.getInstance().getInt("id_servicio"));
        return hotelServicio;
    }
    
    public static ArrayList sqlLeerTodos(){
        ArrayList<ClHotelServicios> hotelServicio = new ArrayList<>();
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"hoteles_servicios\"")){
            return null;
        }
        while(OracleConection.getInstance().sqlFetch()){
            hotelServicio.add(new ClHotelServicios(OracleConection.getInstance().getInt("id_hotel")
                                    , OracleConection.getInstance().getInt("id_servicio")
                                ));
            
        }     
        return hotelServicio;
    }
}
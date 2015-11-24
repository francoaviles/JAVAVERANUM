/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.DAO;

import java.util.ArrayList;
import veranum.entities.ClHotelCaract;
import veranum.utilidades.OracleConection;

/**
 *
 * @author Zacarias
 */
public class DAOHotelCaract {
    public static boolean sqlInsert(ClHotelCaract hotelCaract){
        String sql="INSERT INTO \"hoteles_caracteristicas\" (\"id_hotel\", \"id_caracteristica\") VALUES ('"+hotelCaract.getId_hotel()+"','"+hotelCaract.getId_caract()+"')";
        OracleConection.getInstance().sqlEjecutar(sql);
        return true;
    }
    
    public static boolean sqlDelete(ClHotelCaract hotelCaract){
        String sql="DELETE FROM \"hoteles_caracteristicas\" WHERE \"id_hotel\" = "+hotelCaract.getId_hotel()+" AND \"id_caracteristica\" = "+hotelCaract.getId_caract()+"";
        OracleConection.getInstance().sqlEjecutar(sql);   
        return true;
    
    }
    
    /*public static boolean sqlUpdate(ClHotelCaract hotelCaract){
        String sql="UPDATE \"hoteles_caracteristicas\" SET \"id_hotel\" = '"+hotelCaract.getId_hotel()+"', \"id_caracteristica\" = '"+hotelCaract.getId_caract()+"' WHERE \"id_hotel\" = "+hotelCaract.getId_hotel()+"";
        OracleConection.getInstance().sqlEjecutar(sql);   
        return true;
    }*/
    
    public static ClHotelCaract sqlLeer(int id_hotel, int id_caracteristica){     
        ClHotelCaract hotelCaract = new ClHotelCaract();
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"hoteles_caracteristicas\" WHERE \"id_hotel\" ='"+id_hotel+"' AND \"id_caracteristica\" ='"+id_caracteristica+"'")){
            return null;
        }        
        if(!OracleConection.getInstance().sqlFetch()){
            return null;
        }
        hotelCaract.setId_hotel(OracleConection.getInstance().getInt("id_hotel"));
        hotelCaract.setId_caract(OracleConection.getInstance().getInt("id_caracteristica"));
        return hotelCaract;
    }
    
    public static ArrayList sqlLeerTodos(){
        ArrayList<ClHotelCaract> hotelCaract = new ArrayList<>();
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"hoteles_caracteristicas\"")){
            return null;
        }
        while(OracleConection.getInstance().sqlFetch()){
            hotelCaract.add(new ClHotelCaract(OracleConection.getInstance().getInt("id_hotel")
                                    , OracleConection.getInstance().getInt("id_caracteristica")
                                ));
            
        }     
        return hotelCaract;
    }
}

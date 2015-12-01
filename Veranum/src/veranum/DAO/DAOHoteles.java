/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.DAO;

import com.google.gson.Gson;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import veranum.entities.ClHoteles;
import veranum.utilidades.OracleConection;
import static veranum.utilidades.OracleConection.db;

/**
 *
 * @author Zacarias
 */
public class DAOHoteles {   
    public static boolean sqlInsert(ClHoteles hotel) throws SQLException{
        String sql="INSERT INTO \"hoteles\" (\"id_cadena\", \"id_region\", \"id_provincia\", \"id_comuna\", \"nombre\", \"direccion\") VALUES(?,?,?,?,?,?)";
        Log.create("INSERT",new Gson().toJson(hotel));
        PreparedStatement a = OracleConection.getInstance().sqlPreparar(sql);
        a.setInt(1, hotel.getIdCadena());
        a.setInt(2, hotel.getIdRegion());
        a.setInt(3, hotel.getIdProvincia());
        a.setInt(4, hotel.getIdComuna());
        a.setString(5, hotel.getNombre());
        a.setString(6, hotel.getDireccion());
        return OracleConection.getInstance().sqlEjecutarPreparacion();
    }
    
    public static boolean sqlDelete(ClHoteles hotel) throws SQLException{
        String sql="DELETE FROM \"hoteles\" WHERE \"id_hotel\" = "+hotel.getIdHotel()+"";
        Log.create("DELETE",new Gson().toJson(hotel));
        return OracleConection.getInstance().sqlEjecutar(sql);   
    }
    
    public static boolean sqlUpdate(ClHoteles hotel) throws SQLException{
        String sql="UPDATE \"hoteles\" SET \"id_cadena\" = ?, \"id_region\" = ?, \"id_provincia\" = ?, \"id_comuna\" = ?, \"nombre\" = ?, \"direccion\" = ? WHERE \"id_hotel\" = ?";
        Log.create("UPDATE",new Gson().toJson(hotel));
        PreparedStatement a = OracleConection.getInstance().sqlPreparar(sql);
        a.setInt(1, hotel.getIdCadena());
        a.setInt(2, hotel.getIdRegion());
        a.setInt(3, hotel.getIdProvincia());
        a.setInt(4, hotel.getIdComuna());
        a.setString(5, hotel.getNombre());
        a.setString(6, hotel.getDireccion());
        a.setInt(7, hotel.getIdHotel());
        return OracleConection.getInstance().sqlEjecutarPreparacion();  
    }
    
    public static ClHoteles sqlLeer(int id){     
        ClHoteles hotel = new ClHoteles();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"hoteles\" WHERE \"id_hotel\" = "+id+" ")){
            return null;
        }        
        if(!OracleConection.getInstance().sqlFetch()){
            return null;
        }        
        hotel.setIdHotel(OracleConection.getInstance().getInt("id_hotel"));
        hotel.setIdCadena(OracleConection.getInstance().getInt("id_cadena"));
        hotel.setIdRegion(OracleConection.getInstance().getInt("id_region"));
        hotel.setIdProvincia(OracleConection.getInstance().getInt("id_provincia"));
        hotel.setIdComuna(OracleConection.getInstance().getInt("id_comuna"));
        hotel.setNombre(OracleConection.getInstance().getString("nombre"));
        hotel.setDireccion(OracleConection.getInstance().getString("direccion"));
        return hotel;
    }
    
    public static ArrayList sqlLeerTodos(){
        ArrayList<ClHoteles> hotel = new ArrayList<>();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"hoteles\"")){
            return null;
        }
        while(OracleConection.getInstance().sqlFetch()){
            hotel.add(new ClHoteles(OracleConection.getInstance().getInt("id_hotel")
                                    , OracleConection.getInstance().getInt("id_cadena")
                                    , OracleConection.getInstance().getInt("id_region")
                                    , OracleConection.getInstance().getInt("id_provincia")
                                    , OracleConection.getInstance().getInt("id_comuna")
                                    , OracleConection.getInstance().getString("nombre")
                                    , OracleConection.getInstance().getString("direccion")
                                ));
            
        }     
        return hotel;
    }  
    
    public static ArrayList sqlBuscarByNombre(String nombre){
        ArrayList<ClHoteles> hotel = new ArrayList<>();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"hoteles\" WHERE \"nombre\" LIKE '%"+nombre+"%'")){
            return null;
        }
        while(OracleConection.getInstance().sqlFetch()){
            hotel.add(new ClHoteles(OracleConection.getInstance().getInt("id_cadena"), 
                                    OracleConection.getInstance().getInt("id_region"), 
                                    OracleConection.getInstance().getInt("id_provincia"), 
                                    OracleConection.getInstance().getInt("id_comuna"), 
                                    OracleConection.getInstance().getString("nombre"), 
                                    OracleConection.getInstance().getString("direccion")));
            
        }     
        return hotel;
    }
}

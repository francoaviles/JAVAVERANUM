/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.DAO;

import java.util.ArrayList;
import veranum.entities.ClHoteles;
import veranum.utilidades.OracleConection;
import static veranum.utilidades.OracleConection.db;

/**
 *
 * @author Zacarias
 */
public class DAOHoteles {   
    public static boolean sqlInsert(ClHoteles hotel){
        String sql="INSERT INTO \"hoteles\" (\"id_cadena\", \"id_region\", \"id_provincia\", \"id_comuna\", \"nombre\", \"direccion\" ) VALUES ('"+hotel.getIdCadena()+"','"+hotel.getIdRegion()+"','"+hotel.getIdProvincia()+"','"+hotel.getIdComuna()+"','"+hotel.getNombre()+"','"+hotel.getDireccion()+"')";
        OracleConection.getInstance().sqlEjecutar(sql);
        return true;
    }
    
    public static boolean sqlDelete(ClHoteles hotel){
        String sql="DELETE FROM \"hoteles\" WHERE \"id_hotel\" = "+hotel.getIdHotel()+"";
        System.out.println(sql);
        OracleConection.getInstance().sqlEjecutar(sql);   
        return true;
    }
    
    public static boolean sqlUpdate(ClHoteles hotel){
        String sql="UPDATE \"hoteles\" SET \"id_cadena\" = '"+hotel.getIdCadena()+"', \"id_region\" = '"+hotel.getIdRegion()+"', \"id_provincia\" = '"+hotel.getIdProvincia()+"', \"id_comuna\" = '"+hotel.getIdComuna()+"', \"nombre\" = '"+hotel.getNombre()+"', \"direccion\" = '"+hotel.getDireccion()+"' WHERE \"id_hotel\" = '"+hotel.getIdHotel()+"'";
        OracleConection.getInstance().sqlEjecutar(sql);   
        return true;
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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.DAO;

import java.util.ArrayList;
import veranum.entities.ClHoteles;
import veranum.utilidades.OracleConection;

/**
 *
 * @author Zacarias
 */
public class DAOHoteles {
    private static final OracleConection bd = new OracleConection().Conectar();
    
    public static boolean sqlInsert(ClHoteles hotel){
        String sql="INSERT INTO \"hoteles\" (\"id_cadena\", \"id_region\", \"id_provincia\", \"id_comuna\", \"nombre\", \"direccion\" ) VALUES ('"+hotel.getIdCadena()+"','"+hotel.getIdRegion()+"','"+hotel.getIdProvincia()+"','"+hotel.getIdComuna()+"','"+hotel.getNombre()+"','"+hotel.getDireccion()+"')";
        bd.sqlEjecutar(sql);
        return true;
    }
    
    public static boolean sqlDelete(ClHoteles hotel){
        String sql="DELETE FROM \"hoteles\" WHERE \"id_hotel\" = "+hotel.getIdHotel()+"";
        System.out.println(sql);
        bd.sqlEjecutar(sql);   
        return true;
    }
    
    public static boolean sqlUpdate(ClHoteles hotel){
        String sql="UPDATE \"hoteles\" SET \"id_cadena\" = '"+hotel.getIdCadena()+"', \"id_region\" = '"+hotel.getIdRegion()+"', \"id_provincia\" = '"+hotel.getIdProvincia()+"', \"id_comuna\" = '"+hotel.getIdComuna()+"', \"nombre\" = '"+hotel.getNombre()+"', \"direccion\" = '"+hotel.getDireccion()+"' WHERE \"id_hotel\" = '"+hotel.getIdHotel()+"'";
        bd.sqlEjecutar(sql);   
        return true;
    }
    
    public static ClHoteles sqlLeer(int id){     
        ClHoteles hotel = new ClHoteles();        
        if(!bd.sqlSelect("SELECT * FROM \"hoteles\" WHERE \"id_hotel\" = "+id+" ")){
            return null;
        }        
        if(!bd.sqlFetch()){
            return null;
        }        
        hotel.setIdHotel(bd.getInt("id_hotel"));
        hotel.setIdCadena(bd.getInt("id_cadena"));
        hotel.setIdRegion(bd.getInt("id_region"));
        hotel.setIdProvincia(bd.getInt("id_provincia"));
        hotel.setIdComuna(bd.getInt("id_comuna"));
        hotel.setNombre(bd.getString("nombre"));
        hotel.setDireccion(bd.getString("direccion"));
        return hotel;
    }
    
    public static ArrayList sqlLeerTodos(){
        ArrayList<ClHoteles> hotel = new ArrayList<>();        
        if(!bd.sqlSelect("SELECT * FROM \"hoteles\"")){
            return null;
        }
        while(bd.sqlFetch()){
            hotel.add(new ClHoteles(bd.getInt("id_hotel")
                                    , bd.getInt("id_cadena")
                                    , bd.getInt("id_region")
                                    , bd.getInt("id_provincia")
                                    , bd.getInt("id_comuna")
                                    , bd.getString("nombre")
                                    , bd.getString("direccion")
                                ));
            
        }     
        return hotel;
    }  
    
    public static ArrayList sqlBuscarByNombre(String nombre){
        ArrayList<ClHoteles> hotel = new ArrayList<>();        
        if(!bd.sqlSelect("SELECT * FROM \"hoteles\" WHERE \"nombre\" LIKE '%"+nombre+"%'")){
            return null;
        }
        while(bd.sqlFetch()){
            hotel.add(new ClHoteles(bd.getInt("id_cadena"), 
                                    bd.getInt("id_region"), 
                                    bd.getInt("id_provincia"), 
                                    bd.getInt("id_comuna"), 
                                    bd.getString("nombre"), 
                                    bd.getString("direccion")));
            
        }     
        return hotel;
    }
}

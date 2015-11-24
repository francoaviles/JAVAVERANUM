/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.DAO;

import java.util.ArrayList;
import veranum.entities.ClHotelInsumos;
import veranum.utilidades.OracleConection;

/**
 *
 * @author Zacarias
 */
public class DAOHotelInsumos {
    public static boolean sqlInsert(ClHotelInsumos hotelInsumos){
        String sql="INSERT INTO \"hotel_insumos\" (\"id_insumo\", \"id_hotel\", \"id_medida\", \"stock\" ) VALUES ('"+hotelInsumos.getIdInsumo()+"','"+hotelInsumos.getIdHotel()+"','"+hotelInsumos.getIdMedida()+"','"+hotelInsumos.getStock()+"')";
        OracleConection.getInstance().sqlEjecutar(sql);
        return true;
    }

    public static boolean sqlDelete(ClHotelInsumos hotelInsumos){
        String sql="DELETE FROM \"hotel_insumos\" WHERE \"id_insumo_hotel\" = "+hotelInsumos.getIdInsumoHotel()+"";
        OracleConection.getInstance().sqlEjecutar(sql);   
        return true;
    
    }
    
    public static boolean sqlUpdate(ClHotelInsumos hotelInsumos){
        String sql="UPDATE \"hotel_insumos\" SET \"id_insumo\" = '"+hotelInsumos.getIdInsumo()+"', \"id_hotel\" = '"+hotelInsumos.getIdHotel()+"', \"id_medida\" = '"+hotelInsumos.getIdMedida()+"', \"stock\" = '"+hotelInsumos.getStock()+"' WHERE \"id_insumo_hotel\" = "+hotelInsumos.getIdInsumoHotel()+"";
        OracleConection.getInstance().sqlEjecutar(sql);   
        return true;
    }
    
    public static ClHotelInsumos sqlLeer(int id){     
        ClHotelInsumos hotelInsumos = new ClHotelInsumos();
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"hotel_insumos\" WHERE \"id_insumo_hotel\" ='"+id+"'")){
            return null;
        }        
        if(!OracleConection.getInstance().sqlFetch()){
            return null;
        }
        hotelInsumos.setIdInsumoHotel(OracleConection.getInstance().getInt("id_insumo_hotel"));
        hotelInsumos.setIdInsumo(OracleConection.getInstance().getInt("id_insumo"));
        hotelInsumos.setIdHotel(OracleConection.getInstance().getInt("id_hotel"));
        hotelInsumos.setIdMedida(OracleConection.getInstance().getInt("id_medida"));
        hotelInsumos.setStock(OracleConection.getInstance().getInt("stock"));
        return hotelInsumos;
    }
    
    public static ArrayList sqlLeerTodos(){
        ArrayList<ClHotelInsumos> hotelInsumos = new ArrayList<>();
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"hotel_insumos\"")){
            return null;
        }
        while(OracleConection.getInstance().sqlFetch()){
            hotelInsumos.add(new ClHotelInsumos(OracleConection.getInstance().getInt("id_insumo_hotel")
                                               , OracleConection.getInstance().getInt("id_insumo")
                                               , OracleConection.getInstance().getInt("id_hotel")
                                               , OracleConection.getInstance().getInt("id_medida")
                                               , OracleConection.getInstance().getInt("stock")
                                ));
            
        }     
        return hotelInsumos;
    }
    
    public static ArrayList sqlBuscarByNombre(String stock){
        ArrayList<ClHotelInsumos> hotelInsumos = new ArrayList<>();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"hotel_insumos\" WHERE \"stock\" LIKE '%"+stock+"%'")){
            return null;
        }
        while(OracleConection.getInstance().sqlFetch()){
            hotelInsumos.add(new ClHotelInsumos(OracleConection.getInstance().getInt("id_insumo_hotel")
                                               , OracleConection.getInstance().getInt("id_insumo")
                                               , OracleConection.getInstance().getInt("id_hotel")
                                               , OracleConection.getInstance().getInt("id_medida")
                                               , OracleConection.getInstance().getInt("stock")
                                ));
        }     
        return hotelInsumos;
    }
        
}

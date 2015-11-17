/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.DAO;

import java.util.ArrayList;
import veranum.entities.ClHotelTipoMenu;
import veranum.utilidades.OracleConection;

/**
 *
 * @author Zacarias
 */
public class DAOHotelTipoMenu {
    public static boolean sqlInsert(ClHotelTipoMenu hTipoMenu){
        String sql="INSERT INTO \"hotel_tipo_menu\" (\"id_hotel\", \"id_tipo_menu\") VALUES ('"+hTipoMenu.getIdHotel()+"','"+hTipoMenu.getIdTipoMenu()+"')";
        OracleConection.getInstance().sqlEjecutar(sql);
        return true;
    }
    
    public static boolean sqlDelete(ClHotelTipoMenu hTipoMenu){
        String sql="DELETE FROM \"hotel_tipo_menu\" WHERE \"id_hotel\" = "+hTipoMenu.getIdHotel()+" AND \"id_tipo_menu\" ="+hTipoMenu.getIdTipoMenu()+" ";
        OracleConection.getInstance().sqlEjecutar(sql);   
        return true;
    
    }
    
    public static boolean sqlUpdate(ClHotelTipoMenu hTipoMenu){
        String sql="UPDATE \"hotel_tipo_menu\" SET \"id_hotel\" = '"+hTipoMenu.getIdHotel()+"', \"id_tipo_menu\" = '"+hTipoMenu.getIdTipoMenu()+"' WHERE \"id_hotel\" = "+hTipoMenu.getIdHotel()+"";
        OracleConection.getInstance().sqlEjecutar(sql);   
        return true;
    }
    
    public static ClHotelTipoMenu sqlLeer(int id_hotel, int id_tipo_menu){     
        ClHotelTipoMenu hTipoMenu = new ClHotelTipoMenu();
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"hotel_tipo_menu\" WHERE \"id_hotel\" ='"+id_hotel+"' AND \"id_tipo_menu\" ='"+id_tipo_menu+"' ")){
            return null;
        }        
        if(!OracleConection.getInstance().sqlFetch()){
            return null;
        }
        hTipoMenu.setIdHotel(OracleConection.getInstance().getInt("id_hotel"));
        hTipoMenu.setIdTipoMenu(OracleConection.getInstance().getInt("id_tipo_menu"));
        return hTipoMenu;
    }
    
    public static ArrayList sqlLeerTodos(){
        ArrayList<ClHotelTipoMenu> hTipoMenu = new ArrayList<>();
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"hotel_tipo_menu\"")){
            return null;
        }
        while(OracleConection.getInstance().sqlFetch()){
            hTipoMenu.add(new ClHotelTipoMenu(OracleConection.getInstance().getInt("id_hotel")
                                    , OracleConection.getInstance().getInt("id_tipo_menu")
                                ));
            
        }     
        return hTipoMenu;
    }
}

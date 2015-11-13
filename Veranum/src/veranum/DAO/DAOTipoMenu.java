/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.DAO;

import java.util.ArrayList;
import veranum.entities.ClTipoMenu;
import veranum.utilidades.OracleConection;

/**
 *
 * @author Zacarias
 */
public class DAOTipoMenu {
    public static boolean sqlInsert(ClTipoMenu menu){
        String sql="INSERT INTO \"tipo_menu\" (\"nombre\") VALUES ('"+menu.getNombre()+"')";
        OracleConection.getInstance().sqlEjecutar(sql);
        return true;
    }
    
    public static boolean sqlDelete(ClTipoMenu menu){
        String sql="DELETE FROM \"tipo_menu\" WHERE \"id_tipo_menu\" = "+menu.getIdTipoMenu()+"";
        OracleConection.getInstance().sqlEjecutar(sql);   
        return true;
    }
    
    public static boolean sqlUpdate(ClTipoMenu menu){
        String sql="UPDATE \"tipo_menu\" SET \"nombre\" = '"+menu.getNombre()+"' WHERE \"id_tipo_menu\" = "+menu.getIdTipoMenu()+"";
        OracleConection.getInstance().sqlEjecutar(sql);   
        return true;
    }
    
    public static ClTipoMenu sqlLeer(String name){     
        ClTipoMenu menu = new ClTipoMenu();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"tipo_menu\" WHERE \"nombre\" ='"+name+"'")){
            return null;
        }        
        if(!OracleConection.getInstance().sqlFetch()){
            return null;
        }        
        menu.setIdTipoMenu(OracleConection.getInstance().getInt("id_tipo_menu"));
        menu.setNombre(OracleConection.getInstance().getString("nombre"));
        return menu;
    }
    
    public static ClTipoMenu sqlLeer(int id){     
        ClTipoMenu menu = new ClTipoMenu();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"tipo_menu\" WHERE \"id_tipo_menu\" ='"+id+"'")){
            return null;
        }        
        if(!OracleConection.getInstance().sqlFetch()){
            return null;
        }        
        menu.setIdTipoMenu(OracleConection.getInstance().getInt("id_tipo_menu"));
        menu.setNombre(OracleConection.getInstance().getString("nombre"));
        return menu;
    }
    
    public static ArrayList sqlLeerTodos(){
        ArrayList<ClTipoMenu> menu = new ArrayList<>();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"tipo_menu\"")){
            return null;
        }
        while(OracleConection.getInstance().sqlFetch()){
            menu.add(new ClTipoMenu(OracleConection.getInstance().getInt("id_tipo_menu")
                                    , OracleConection.getInstance().getString("nombre")
                                ));
            
        }     
        return menu;
    }    
    
    public static ArrayList sqlBuscarByNombre(String nombre){
        ArrayList<ClTipoMenu> menu = new ArrayList<>();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"tipo_menu\" WHERE \"nombre\" LIKE '%"+nombre+"%'")){
            return null;
        }
        while(OracleConection.getInstance().sqlFetch()){
            menu.add(new ClTipoMenu(OracleConection.getInstance().getInt("id_tipo_menu")
                                    , OracleConection.getInstance().getString("nombre")
                                ));
            
        }     
        return menu;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.DAO;

import com.google.gson.Gson;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import veranum.entities.ClTipoMenu;
import veranum.utilidades.OracleConection;

/**
 *
 * @author Zacarias
 */
public class DAOTipoMenu {
    public static boolean sqlInsert(ClTipoMenu menu) throws SQLException{
        String sql="INSERT INTO \"tipo_menu\" (\"nombre\") VALUES (?)";
        Log.create("INSERT",new Gson().toJson(menu));
        PreparedStatement a = OracleConection.getInstance().sqlPreparar(sql);
        a.setString(1, menu.getNombre());
        return OracleConection.getInstance().sqlEjecutarPreparacion();
    }
    
    public static boolean sqlDelete(ClTipoMenu menu) throws SQLException{
        String sql="DELETE FROM \"tipo_menu\" WHERE \"id_tipo_menu\" = "+menu.getIdTipoMenu()+"";
        Log.create("DELETE",new Gson().toJson(menu));
        return OracleConection.getInstance().sqlEjecutar(sql);   
    }
    
    public static boolean sqlUpdate(ClTipoMenu menu) throws SQLException{
        String sql="UPDATE \"tipo_menu\" SET \"nombre\" = ? WHERE \"id_tipo_menu\" = ?";
        Log.create("UPDATE",new Gson().toJson(menu));
        PreparedStatement a = OracleConection.getInstance().sqlPreparar(sql);
        a.setString(1, menu.getNombre());
        a.setInt(2, menu.getIdTipoMenu());
        
        return OracleConection.getInstance().sqlEjecutarPreparacion();
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

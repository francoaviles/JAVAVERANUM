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
    private static final OracleConection bd = new OracleConection().Conectar();
    
    public static boolean sqlInsert(ClTipoMenu menu){
        String sql="INSERT INTO \"tipo_menu\" (\"nombre\") VALUES ('"+menu.getNombre()+"')";
        bd.sqlEjecutar(sql);
        return true;
    }
    
    public static boolean sqlDelete(ClTipoMenu menu){
        String sql="DELETE FROM \"tipo_menu\" WHERE \"id_tipo_menu\" = "+menu.getIdTipoMenu()+"";
        bd.sqlEjecutar(sql);   
        return true;
    }
    
    public static boolean sqlUpdate(ClTipoMenu menu){
        String sql="UPDATE \"tipo_menu\" SET \"nombre\" = '"+menu.getNombre()+"' WHERE \"id_tipo_menu\" = "+menu.getIdTipoMenu()+"";
        bd.sqlEjecutar(sql);   
        return true;
    }
    
    public static ClTipoMenu sqlLeer(String name){     
        ClTipoMenu menu = new ClTipoMenu();        
        if(!bd.sqlSelect("SELECT * FROM \"tipo_menu\" WHERE \"nombre\" ='"+name+"'")){
            return null;
        }        
        if(!bd.sqlFetch()){
            return null;
        }        
        menu.setIdTipoMenu(bd.getInt("id_tipo_menu"));
        menu.setNombre(bd.getString("nombre"));
        return menu;
    }
    
    public static ClTipoMenu sqlLeer(int id){     
        ClTipoMenu menu = new ClTipoMenu();        
        if(!bd.sqlSelect("SELECT * FROM \"tipo_menu\" WHERE \"id_tipo_menu\" ='"+id+"'")){
            return null;
        }        
        if(!bd.sqlFetch()){
            return null;
        }        
        menu.setIdTipoMenu(bd.getInt("id_tipo_menu"));
        menu.setNombre(bd.getString("nombre"));
        return menu;
    }
    
    public static ArrayList sqlLeerTodos(){
        ArrayList<ClTipoMenu> menu = new ArrayList<>();        
        if(!bd.sqlSelect("SELECT * FROM \"tipo_menu\"")){
            return null;
        }
        while(bd.sqlFetch()){
            menu.add(new ClTipoMenu(bd.getInt("id_tipo_menu")
                                    , bd.getString("nombre")
                                ));
            
        }     
        return menu;
    }    
    
    public static ArrayList sqlBuscarByNombre(String nombre){
        ArrayList<ClTipoMenu> menu = new ArrayList<>();        
        if(!bd.sqlSelect("SELECT * FROM \"tipo_menu\" WHERE \"nombre\" LIKE '%"+nombre+"%'")){
            return null;
        }
        while(bd.sqlFetch()){
            menu.add(new ClTipoMenu(bd.getInt("id_tipo_menu")
                                    , bd.getString("nombre")
                                ));
            
        }     
        return menu;
    }
}

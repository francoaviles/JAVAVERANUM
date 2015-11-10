/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.DAO;

import java.util.ArrayList;
import veranum.entities.ClMenu;
import veranum.utilidades.OracleConection;

/**
 *
 * @author Zacarias
 */
public class DAOMenu {
    private static final OracleConection bd = new OracleConection().Conectar();
    
    public static boolean sqlInsert(ClMenu menu){
        String sql="INSERT INTO \"menu\" (\"id_tipo_menu\", \"nombre\") VALUES ('"+menu.getTipoMenu()+"','"+menu.getNombre()+"')";
        bd.sqlEjecutar(sql);
        return true;
    }
    
    public static boolean sqlDelete(ClMenu menu){
        String sql="DELETE FROM \"menu\" WHERE \"nombre\" = '"+menu.getNombre()+"'";
        bd.sqlEjecutar(sql);   
        return true;
    }
    
    public static boolean sqlUpdate(ClMenu menu){
        String sql="UPDATE \"menu\" SET \"nombre\" = '"+menu.getNombre()+"' AND \"id_tipo_menu\" = '"+menu.getTipoMenu()+"'  WHERE \"nombre\" = '"+menu.getNombre()+"'";
        bd.sqlEjecutar(sql);   
        return true;
    }
    
    public static ClMenu sqlLeer(int id){     
        ClMenu menu = new ClMenu();        
        if(!bd.sqlSelect("SELECT * FROM \"menu\" WHERE \"id_menu\" ='"+id+"'")){
            return null;
        }        
        if(!bd.sqlFetch()){
            return null;
        }        
        menu.setIdMenu(bd.getInt("id_menu"));
        menu.setTipoMenu(bd.getInt("id_tipo_menu"));
        menu.setNombre(bd.getString("nombre"));
        return menu;
    }
    
    public static ClMenu sqlLeer(String name){     
        ClMenu menu = new ClMenu();        
        if(!bd.sqlSelect("SELECT * FROM \"menu\" WHERE \"nombre\" ='"+name+"'")){
            return null;
        }        
        if(!bd.sqlFetch()){
            return null;
        }        
        menu.setIdMenu(bd.getInt("id_menu"));
        menu.setTipoMenu(bd.getInt("id_tipo_menu"));
        menu.setNombre(bd.getString("nombre"));
        return menu;
    }
    
    public static ArrayList sqlLeerTodos(){
        ArrayList<ClMenu> menu = new ArrayList<>();        
        if(!bd.sqlSelect("SELECT * FROM \"menu\"")){
            return null;
        }
        while(bd.sqlFetch()){
            menu.add(new ClMenu(bd.getInt("id_menu")
                                    , bd.getInt("id_tipo_menu")
                                    , bd.getString("nombre")
                                ));
            
        }     
        return menu;
    }
    
    public static ArrayList sqlBuscarByNombre(String nombre){
        ArrayList<ClMenu> menu = new ArrayList<>();        
        if(!bd.sqlSelect("SELECT * FROM \"menu\" WHERE \"nombre\" LIKE '%"+nombre+"%'")){
            return null;
        }
        while(bd.sqlFetch()){
            menu.add(new ClMenu(bd.getInt("id_menu")
                                    , bd.getInt("id_tipo_menu")
                                    , bd.getString("nombre")
                                ));
            
        }     
        return menu;
    }
}

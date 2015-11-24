/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import veranum.entities.ClMenu;
import veranum.utilidades.OracleConection;

/**
 *
 * @author Zacarias
 */
public class DAOMenu {
    public static boolean sqlInsert(ClMenu menu) throws SQLException{
        String sql="INSERT INTO \"menu\" (\"id_tipo_menu\", \"nombre\") VALUES (?,?)";
        PreparedStatement a = OracleConection.getInstance().sqlPreparar(sql);
        a.setInt(1, menu.getTipoMenu());
        a.setString(2, menu.getNombre());
        OracleConection.getInstance().sqlEjecutarPreparacion();
        return true;
    }
    
    public static boolean sqlDelete(ClMenu menu){
        String sql="DELETE FROM \"menu\" WHERE \"id_menu\" = "+menu.getIdMenu()+"";
        OracleConection.getInstance().sqlEjecutar(sql);   
        return true;
    }
    
    public static boolean sqlUpdate(ClMenu menu) throws SQLException{
        String sql="UPDATE \"menu\" SET \"nombre\" = ?, \"id_tipo_menu\" = ? WHERE \"id_menu\" = ?";
        PreparedStatement a = OracleConection.getInstance().sqlPreparar(sql);
        a.setInt(1, menu.getTipoMenu());
        a.setString(2, menu.getNombre());
        a.setInt(3, menu.getIdMenu());
        OracleConection.getInstance().sqlEjecutarPreparacion();  
        return true;
    }
    
    public static ClMenu sqlLeer(int id){     
        ClMenu menu = new ClMenu();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"menu\" WHERE \"id_menu\" ='"+id+"'")){
            return null;
        }        
        if(!OracleConection.getInstance().sqlFetch()){
            return null;
        }        
        menu.setIdMenu(OracleConection.getInstance().getInt("id_menu"));
        menu.setTipoMenu(OracleConection.getInstance().getInt("id_tipo_menu"));
        menu.setNombre(OracleConection.getInstance().getString("nombre"));
        return menu;
    }
    
    public static ClMenu sqlLeer(String name){     
        ClMenu menu = new ClMenu();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"menu\" WHERE \"nombre\" ='"+name+"'")){
            return null;
        }        
        if(!OracleConection.getInstance().sqlFetch()){
            return null;
        }        
        menu.setIdMenu(OracleConection.getInstance().getInt("id_menu"));
        menu.setTipoMenu(OracleConection.getInstance().getInt("id_tipo_menu"));
        menu.setNombre(OracleConection.getInstance().getString("nombre"));
        return menu;
    }
    
    public static ArrayList sqlLeerTodos(){
        ArrayList<ClMenu> menu = new ArrayList<>();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"menu\"")){
            return null;
        }
        while(OracleConection.getInstance().sqlFetch()){
            menu.add(new ClMenu(OracleConection.getInstance().getInt("id_menu")
                                    , OracleConection.getInstance().getInt("id_tipo_menu")
                                    , OracleConection.getInstance().getString("nombre")
                                ));
            
        }     
        return menu;
    }
    
    public static ArrayList sqlBuscarByNombre(String nombre){
        ArrayList<ClMenu> menu = new ArrayList<>();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"menu\" WHERE \"nombre\" LIKE '%"+nombre+"%'")){
            return null;
        }
        while(OracleConection.getInstance().sqlFetch()){
            menu.add(new ClMenu(OracleConection.getInstance().getInt("id_menu")
                                    , OracleConection.getInstance().getInt("id_tipo_menu")
                                    , OracleConection.getInstance().getString("nombre")
                                ));
            
        }     
        return menu;
    }
}

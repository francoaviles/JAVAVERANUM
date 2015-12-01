/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.DAO;

import com.google.gson.Gson;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import veranum.entities.ClComuna;
import veranum.utilidades.OracleConection;

/**
 *
 * @author Zacarias
 */
public class DAOComuna {
    public static boolean sqlInsert(ClComuna comuna) throws SQLException{
        String sql="INSERT INTO \"comunas\" (\"comuna_nombre\", \"id_provincia\") VALUES (?,?)";
        Log.create("INSERT",new Gson().toJson(comuna));
        
        PreparedStatement a = OracleConection.getInstance().sqlPreparar(sql);
        a.setString(1, comuna.getNombre());
        a.setInt(2, comuna.getIdProvincia());
        
        return OracleConection.getInstance().sqlEjecutarPreparacion();
    }
    
    public static boolean sqlDelete(ClComuna comuna) throws SQLException{
        String sql="DELETE FROM \"comunas\" WHERE \"id_comuna\" = "+comuna.getIdComuna()+"";
        Log.create("DELETE",new Gson().toJson(comuna));
        return OracleConection.getInstance().sqlEjecutar(sql);   
    }
    
    public static boolean sqlUpdate(ClComuna comuna) throws SQLException{
        String sql="UPDATE \"comunas\" SET \"comuna_nombre\" = ?, \"id_provincia\" = ? WHERE \"id_comuna\" = ?";
        Log.create("UPDATE",new Gson().toJson(comuna));
        PreparedStatement a = OracleConection.getInstance().sqlPreparar(sql);
        a.setString(1, comuna.getNombre());
        a.setInt(2, comuna.getIdProvincia());
        a.setInt(3, comuna.getIdComuna());
         
        return OracleConection.getInstance().sqlEjecutarPreparacion();
    }
    
    public static ClComuna sqlLeer(int id){     
        ClComuna comuna = new ClComuna();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"comunas\" WHERE \"id_comuna\" ='"+id+"'")){
            return null;
        }        
        if(!OracleConection.getInstance().sqlFetch()){
            return null;
        }        
        comuna.setIdComuna(OracleConection.getInstance().getInt("id_comuna"));
        comuna.setNombre(OracleConection.getInstance().getString("comuna_nombre"));
        comuna.setIdProvincia(OracleConection.getInstance().getInt("id_provincia"));
        return comuna;
    }
    
    public static ClComuna sqlLeer(String name){     
        ClComuna comuna = new ClComuna();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"comunas\" WHERE \"nombre_comuna\" ='"+name+"'")){
            return null;
        }        
        if(!OracleConection.getInstance().sqlFetch()){
            return null;
        }        
        comuna.setIdComuna(OracleConection.getInstance().getInt("id_comuna"));
        comuna.setNombre(OracleConection.getInstance().getString("comuna_nombre"));
        comuna.setIdProvincia(OracleConection.getInstance().getInt("id_provincia"));
        return comuna;
    }
    
    public static ArrayList sqlPorProvincia(int id){     
        ArrayList<ClComuna> comuna = new ArrayList<>();
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"comunas\" WHERE \"id_provincia\" = "+id+" ")){
            return null;
        }
        while(OracleConection.getInstance().sqlFetch()){
            comuna.add(new ClComuna(OracleConection.getInstance().getInt("id_comuna")
                                    , OracleConection.getInstance().getString("comuna_nombre")
                                    , OracleConection.getInstance().getInt("id_provincia")
                                ));
            
        } 
        return comuna;
    }
    
    public static ArrayList sqlLeerTodos(){
        ArrayList<ClComuna> comuna = new ArrayList<>();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"comunas\"")){
            return null;
        }
        while(OracleConection.getInstance().sqlFetch()){
            comuna.add(new ClComuna(OracleConection.getInstance().getInt("id_comuna")
                                    , OracleConection.getInstance().getString("comuna_nombre")
                                    , OracleConection.getInstance().getInt("id_provincia")
                                ));
            
        }     
        return comuna;
    }
    
    public static ArrayList sqlBuscarByNombre(String nombre){
        ArrayList<ClComuna> com = new ArrayList<>();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"comunas\" WHERE \"comuna_nombre\" LIKE '%"+nombre+"%'")){
            return null;
        }
        while(OracleConection.getInstance().sqlFetch()){
            com.add(new ClComuna(OracleConection.getInstance().getInt("id_comuna")
                                    , OracleConection.getInstance().getString("comuna_nombre")
                                    , OracleConection.getInstance().getInt("id_provincia")
                                ));
            
        }     
        return com;
    }
}

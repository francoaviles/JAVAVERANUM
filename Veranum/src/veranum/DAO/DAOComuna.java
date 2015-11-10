/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.DAO;

import java.util.ArrayList;
import veranum.entities.ClComuna;
import veranum.utilidades.OracleConection;

/**
 *
 * @author Zacarias
 */
public class DAOComuna {
    private static final OracleConection bd = new OracleConection().Conectar();
    
    public static boolean sqlInsert(ClComuna comuna){
        String sql="INSERT INTO \"comunas\" (\"comuna_nombre\", \"id_provincia\") VALUES ('"+comuna.getNombre()+"','"+comuna.getIdProvincia()+"')";
        bd.sqlEjecutar(sql);
        return true;
    }
    
    public static boolean sqlDelete(ClComuna comuna){
        String sql="DELETE FROM \"comunas\" WHERE \"id_comuna\" = "+comuna.getIdComuna()+"";
        bd.sqlEjecutar(sql);   
        return true;
    }
    
    public static boolean sqlUpdate(ClComuna comuna){
        String sql="UPDATE \"comunas\" SET \"comuna_nombre\" = '"+comuna.getNombre()+"', \"id_provincia\" = '"+comuna.getIdProvincia()+"' WHERE \"id_comuna\" = "+comuna.getIdComuna()+"";
        bd.sqlEjecutar(sql);   
        return true;
    }
    
    public static ClComuna sqlLeer(int id){     
        ClComuna comuna = new ClComuna();        
        if(!bd.sqlSelect("SELECT * FROM \"comunas\" WHERE \"id_comuna\" ='"+id+"'")){
            return null;
        }        
        if(!bd.sqlFetch()){
            return null;
        }        
        comuna.setIdComuna(bd.getInt("id_comuna"));
        comuna.setNombre(bd.getString("comuna_nombre"));
        comuna.setIdProvincia(bd.getInt("id_provincia"));
        return comuna;
    }
    
    public static ClComuna sqlLeer(String name){     
        ClComuna comuna = new ClComuna();        
        if(!bd.sqlSelect("SELECT * FROM \"comunas\" WHERE \"nombre_comuna\" ='"+name+"'")){
            return null;
        }        
        if(!bd.sqlFetch()){
            return null;
        }        
        comuna.setIdComuna(bd.getInt("id_comuna"));
        comuna.setNombre(bd.getString("comuna_nombre"));
        comuna.setIdProvincia(bd.getInt("id_provincia"));
        return comuna;
    }
    
    public static ArrayList sqlPorProvincia(int id){     
        ArrayList<ClComuna> comuna = new ArrayList<>();
        if(!bd.sqlSelect("SELECT * FROM \"comunas\" WHERE \"id_provincia\" = "+id+" ")){
            return null;
        }
        while(bd.sqlFetch()){
            comuna.add(new ClComuna(bd.getInt("id_comuna")
                                    , bd.getString("comuna_nombre")
                                    , bd.getInt("id_provincia")
                                ));
            
        } 
        return comuna;
    }
    
    public static ArrayList sqlLeerTodos(){
        ArrayList<ClComuna> comuna = new ArrayList<>();        
        if(!bd.sqlSelect("SELECT * FROM \"comunas\"")){
            return null;
        }
        while(bd.sqlFetch()){
            comuna.add(new ClComuna(bd.getInt("id_comuna")
                                    , bd.getString("comuna_nombre")
                                    , bd.getInt("id_provincia")
                                ));
            
        }     
        return comuna;
    }
    
    public static ArrayList sqlBuscarByNombre(String nombre){
        ArrayList<ClComuna> com = new ArrayList<>();        
        if(!bd.sqlSelect("SELECT * FROM \"comunas\" WHERE \"comuna_nombre\" LIKE '%"+nombre+"%'")){
            return null;
        }
        while(bd.sqlFetch()){
            com.add(new ClComuna(bd.getInt("id_comuna")
                                    , bd.getString("comuna_nombre")
                                    , bd.getInt("id_provincia")
                                ));
            
        }     
        return com;
    }  
}

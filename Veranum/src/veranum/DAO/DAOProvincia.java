/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.DAO;

import com.google.gson.Gson;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import veranum.entities.ClProvincia;
import veranum.utilidades.OracleConection;

/**
 *
 * @author Zacarias
 */
public class DAOProvincia {
    public static boolean sqlInsert(ClProvincia provincia) throws SQLException{
        String sql="INSERT INTO \"provincias\" (\"provincia_nombre\", \"id_region\") VALUES (?,?)";
        Log.create("INSERT",new Gson().toJson(provincia));
        PreparedStatement a = OracleConection.getInstance().sqlPreparar(sql);
        a.setString(1, provincia.getNombre());
        a.setInt(2, provincia.getIdRegion());
        
        return OracleConection.getInstance().sqlEjecutarPreparacion();
    }
    
    public static boolean sqlDelete(ClProvincia provincia) throws SQLException{
        String sql="DELETE FROM \"provincias\" WHERE \"id_provincia\" = "+provincia.getIdProvincia()+"";
           Log.create("DELETE",new Gson().toJson(provincia));
        return OracleConection.getInstance().sqlEjecutar(sql);
    }
    
    public static boolean sqlUpdate(ClProvincia provincia) throws SQLException{
        String sql="UPDATE \"provincias\" SET \"provincia_nombre\" = ?, \"id_region\" = ? WHERE \"id_provincia\" = ?";
        Log.create("UPDATE",new Gson().toJson(provincia));
        PreparedStatement a = OracleConection.getInstance().sqlPreparar(sql);
        a.setString(1, provincia.getNombre());
        a.setInt(2, provincia.getIdRegion());
        a.setInt(3, provincia.getIdProvincia());
        
        return OracleConection.getInstance().sqlEjecutarPreparacion(); 
    }
    
    public static ClProvincia sqlLeer(int id){     
        ClProvincia provincia = new ClProvincia();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"provincias\" WHERE \"id_provincia\" ='"+id+"'")){
            return null;
        }        
        if(!OracleConection.getInstance().sqlFetch()){
            return null;
        }        
        provincia.setIdProvincia(OracleConection.getInstance().getInt("id_provincia"));
        provincia.setNombre(OracleConection.getInstance().getString("provincia_nombre"));
        provincia.setIdRegion(OracleConection.getInstance().getInt("id_region"));
        return provincia;
    }
    
    public static ClProvincia sqlLeer(String name){     
        ClProvincia provincia = new ClProvincia();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"provincias\" WHERE \"id_provincia\" ='"+name+"'")){
            return null;
        }        
        if(!OracleConection.getInstance().sqlFetch()){
            return null;
        }        
        provincia.setIdProvincia(OracleConection.getInstance().getInt("id_provincia"));
        provincia.setNombre(OracleConection.getInstance().getString("provincia_nombre"));
        provincia.setIdRegion(OracleConection.getInstance().getInt("id_region"));
        return provincia;
    }
    
    public static ArrayList sqlPorRegion(int id){     
        ArrayList<ClProvincia> provincia = new ArrayList<>();
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"provincias\" WHERE \"id_region\" = "+id+" ")){
            return null;
        }
        while(OracleConection.getInstance().sqlFetch()){
            provincia.add(new ClProvincia(OracleConection.getInstance().getInt("id_provincia")
                                    , OracleConection.getInstance().getString("provincia_nombre")
                                    , OracleConection.getInstance().getInt("id_region")
                                ));
            
        } 
        return provincia;
    }
    
    public static ArrayList sqlLeerTodos(){
        ArrayList<ClProvincia> provincia = new ArrayList<>();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"provincias\"")){
            return null;
        }
        while(OracleConection.getInstance().sqlFetch()){
            provincia.add(new ClProvincia(OracleConection.getInstance().getInt("id_provincia")
                                    , OracleConection.getInstance().getString("provincia_nombre")
                                    , OracleConection.getInstance().getInt("id_region")
                                ));
            
        }     
        return provincia;
    }  
    
    public static ArrayList sqlBuscarByNombre(String nombre){
        ArrayList<ClProvincia> pro = new ArrayList<>();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"provincias\" WHERE \"provincia_nombre\" LIKE '%"+nombre+"%'")){
            return null;
        }
        while(OracleConection.getInstance().sqlFetch()){
            pro.add(new ClProvincia(OracleConection.getInstance().getInt("id_provincia")
                                    , OracleConection.getInstance().getString("provincia_nombre")
                                    , OracleConection.getInstance().getInt("id_region")
                                ));
            
        }     
        return pro;
    }  
    
}

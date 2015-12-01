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
import veranum.entities.ClTipoCaracteristicas;
import veranum.utilidades.OracleConection;

/**
 *
 * @author Zacarias
 */
public class DAOTipoCaract {
    public static boolean sqlInsert(ClTipoCaracteristicas caract) throws SQLException{
        String sql="INSERT INTO \"tipo_caracteristicas\" (\"nombre\", \"descripcion\") VALUES (?,?)";
        Log.create("INSERT",new Gson().toJson(caract));
        
        PreparedStatement a = OracleConection.getInstance().sqlPreparar(sql);
        a.setString(1, caract.getNombre());
        a.setString(2, caract.getDescripcion());
       
        return  OracleConection.getInstance().sqlEjecutarPreparacion();
    }
    
    public static boolean sqlDelete(ClTipoCaracteristicas caract) throws SQLException{
        String sql="DELETE FROM \"tipo_caracteristicas\" WHERE \"id_tipo_caract\" = "+caract.getIdTipoCaract()+"";
        Log.create("DELETE",new Gson().toJson(caract));
        
        return  OracleConection.getInstance().sqlEjecutar(sql);   
    }
    
    public static boolean sqlUpdate(ClTipoCaracteristicas caract) throws SQLException{
        String sql="UPDATE \"tipo_caracteristicas\" SET \"nombre\" = ?, \"descripcion\" = ? WHERE \"id_tipo_caract\" = ?";
        Log.create("UPDATE",new Gson().toJson(caract));
        
        PreparedStatement a = OracleConection.getInstance().sqlPreparar(sql);
        a.setString(1, caract.getNombre());
        a.setString(2, caract.getDescripcion());
        a.setInt(3, caract.getIdTipoCaract());
        
        return OracleConection.getInstance().sqlEjecutarPreparacion();  
    }
    
    public static ClTipoCaracteristicas sqlLeer(int id){     
        ClTipoCaracteristicas caract = new ClTipoCaracteristicas();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"tipo_caracteristicas\" WHERE \"id_tipo_caract\" ='"+id+"'")){
            return null;
        }        
        if(!OracleConection.getInstance().sqlFetch()){
            return null;
        }        
        caract.setIdTipoCaract(OracleConection.getInstance().getInt("id_tipo_caract"));
        caract.setNombre(OracleConection.getInstance().getString("nombre"));
        caract.setDescripcion(OracleConection.getInstance().getString("descripcion"));
        return caract;
    }
    
    public static ClTipoCaracteristicas sqlLeer(String name){     
        ClTipoCaracteristicas caract = new ClTipoCaracteristicas();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"tipo_caracteristicas\" WHERE \"nombre\" ='"+name+"'")){
            return null;
        }        
        if(!OracleConection.getInstance().sqlFetch()){
            return null;
        }        
        caract.setIdTipoCaract(OracleConection.getInstance().getInt("id_tipo_caract"));
        caract.setNombre(OracleConection.getInstance().getString("nombre"));
        caract.setDescripcion(OracleConection.getInstance().getString("descripcion"));
        return caract;
    }
    
    public static ArrayList sqlLeerTodos(){
        ArrayList<ClTipoCaracteristicas> caract = new ArrayList<>();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"tipo_caracteristicas\"")){
            return null;
        }
        while(OracleConection.getInstance().sqlFetch()){
            caract.add(new ClTipoCaracteristicas(OracleConection.getInstance().getInt("id_tipo_caract")
                                    , OracleConection.getInstance().getString("nombre")
                                    , OracleConection.getInstance().getString("descripcion")
                                ));
            
        }     
        return caract;
    }    
    
    public static ArrayList sqlBuscarByNombre(String nombre){
        ArrayList<ClTipoCaracteristicas> caract = new ArrayList<>();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"tipo_caracteristicas\" WHERE \"nombre\" LIKE '%"+nombre+"%'")){
            return null;
        }
        while(OracleConection.getInstance().sqlFetch()){
            caract.add(new ClTipoCaracteristicas(OracleConection.getInstance().getInt("id_tipo_caract")
                                    , OracleConection.getInstance().getString("nombre")
                                    , OracleConection.getInstance().getString("descripcion")
                                ));
            
        }     
        return caract;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.DAO;

import java.util.ArrayList;
import veranum.entities.ClTipoCaracteristicas;
import veranum.utilidades.OracleConection;

/**
 *
 * @author Zacarias
 */
public class DAOTipoCaract {
    public static boolean sqlInsert(ClTipoCaracteristicas caract){
        String sql="INSERT INTO \"tipo_caracteristicas\" (\"nombre\", \"descripcion\") VALUES ('"+caract.getNombre()+"', '"+caract.getDescripcion()+"')";
        OracleConection.getInstance().sqlEjecutar(sql);
        return true;
    }
    
    public static boolean sqlDelete(ClTipoCaracteristicas caract){
        String sql="DELETE FROM \"tipo_caracteristicas\" WHERE \"id_tipo_caract\" = "+caract.getIdTipoCaract()+"";
        OracleConection.getInstance().sqlEjecutar(sql);   
        return true;
    }
    
    public static boolean sqlUpdate(ClTipoCaracteristicas caract){
        String sql="UPDATE \"tipo_caracteristicas\" SET \"nombre\" = '"+caract.getNombre()+"', \"descripcion\" = '"+caract.getDescripcion()+"' WHERE \"id_tipo_caract\" = "+caract.getIdTipoCaract()+"";
        OracleConection.getInstance().sqlEjecutar(sql);   
        return true;
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

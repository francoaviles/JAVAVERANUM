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
    private static final OracleConection bd = new OracleConection().Conectar();
    
    public static boolean sqlInsert(ClTipoCaracteristicas caract){
        String sql="INSERT INTO \"tipo_caracteristicas\" (\"nombre\", \"descripcion\") VALUES ('"+caract.getNombre()+"', '"+caract.getDescripcion()+"')";
        bd.sqlEjecutar(sql);
        return true;
    }
    
    public static boolean sqlDelete(ClTipoCaracteristicas caract){
        String sql="DELETE FROM \"tipo_caracteristicas\" WHERE \"id_tipo_caract\" = "+caract.getIdTipoCaract()+"";
        bd.sqlEjecutar(sql);   
        return true;
    }
    
    public static boolean sqlUpdate(ClTipoCaracteristicas caract){
        String sql="UPDATE \"tipo_caracteristicas\" SET \"nombre\" = '"+caract.getNombre()+"', \"descripcion\" = '"+caract.getDescripcion()+"' WHERE \"id_tipo_caract\" = "+caract.getIdTipoCaract()+"";
        bd.sqlEjecutar(sql);   
        return true;
    }
    
    public static ClTipoCaracteristicas sqlLeer(int id){     
        ClTipoCaracteristicas caract = new ClTipoCaracteristicas();        
        if(!bd.sqlSelect("SELECT * FROM \"tipo_caracteristicas\" WHERE \"id_tipo_caract\" ='"+id+"'")){
            return null;
        }        
        if(!bd.sqlFetch()){
            return null;
        }        
        caract.setIdTipoCaract(bd.getInt("id_tipo_caract"));
        caract.setNombre(bd.getString("nombre"));
        caract.setDescripcion(bd.getString("descripcion"));
        return caract;
    }
    
    public static ClTipoCaracteristicas sqlLeer(String name){     
        ClTipoCaracteristicas caract = new ClTipoCaracteristicas();        
        if(!bd.sqlSelect("SELECT * FROM \"tipo_caracteristicas\" WHERE \"nombre\" ='"+name+"'")){
            return null;
        }        
        if(!bd.sqlFetch()){
            return null;
        }        
        caract.setIdTipoCaract(bd.getInt("id_tipo_caract"));
        caract.setNombre(bd.getString("nombre"));
        caract.setDescripcion(bd.getString("descripcion"));
        return caract;
    }
    
    public static ArrayList sqlLeerTodos(){
        ArrayList<ClTipoCaracteristicas> caract = new ArrayList<>();        
        if(!bd.sqlSelect("SELECT * FROM \"tipo_caracteristicas\"")){
            return null;
        }
        while(bd.sqlFetch()){
            caract.add(new ClTipoCaracteristicas(bd.getInt("id_tipo_caract")
                                    , bd.getString("nombre")
                                    , bd.getString("descripcion")
                                ));
            
        }     
        return caract;
    }    
    
    public static ArrayList sqlBuscarByNombre(String nombre){
        ArrayList<ClTipoCaracteristicas> caract = new ArrayList<>();        
        if(!bd.sqlSelect("SELECT * FROM \"tipo_caracteristicas\" WHERE \"nombre\" LIKE '%"+nombre+"%'")){
            return null;
        }
        while(bd.sqlFetch()){
            caract.add(new ClTipoCaracteristicas(bd.getInt("id_tipo_caract")
                                    , bd.getString("nombre")
                                    , bd.getString("descripcion")
                                ));
            
        }     
        return caract;
    }
}

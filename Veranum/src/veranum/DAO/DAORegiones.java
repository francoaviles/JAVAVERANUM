/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.DAO;

import java.util.ArrayList;
import veranum.entities.ClRegion;
import veranum.utilidades.OracleConection;

/**
 *
 * @author carlosdlg
 */
public class DAORegiones {
    public static boolean sqlInsert(ClRegion region){
        String sql="INSERT INTO \"regiones\" (\"region_nombre\", \"region_ordinal\") VALUES ('"+region.getNombre()+"','"+region.getOrdinal()+"')";
        OracleConection.getInstance().sqlEjecutar(sql);
        return true;
    }
    
    public static boolean sqlDelete(ClRegion region){
        String sql="DELETE FROM \"regiones\" WHERE \"id_region\" = "+region.getIdRegion()+"";
        OracleConection.getInstance().sqlEjecutar(sql);   
        return true;
    
    }
    
    public static boolean sqlUpdate(ClRegion region){
        String sql="UPDATE \"regiones\" SET \"region_nombre\" = '"+region.getNombre()+"', \"region_ordinal\" = '"+region.getOrdinal()+"' WHERE \"id_region\" = "+region.getIdRegion()+"";
        OracleConection.getInstance().sqlEjecutar(sql);   
        return true;
    }
    
    public static ClRegion sqlLeer(int id){     
        ClRegion region = new ClRegion(); 
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"regiones\" WHERE \"id_region\" ='"+id+"'")){
            return null;
        }        
        if(!OracleConection.getInstance().sqlFetch()){
            return null;
        }
        region.setIdRegion(OracleConection.getInstance().getInt("id_region"));
        region.setNombre(OracleConection.getInstance().getString("region_nombre"));
        region.setOrdinal(OracleConection.getInstance().getString("region_ordinal"));
        return region;
    }
    
    public static ClRegion sqlLeer(String name){     
        ClRegion region = new ClRegion(); 
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"regiones\" WHERE \"region_nombre\" ='"+name+"'")){
            return null;
        }        
        if(!OracleConection.getInstance().sqlFetch()){
            return null;
        }
        region.setIdRegion(OracleConection.getInstance().getInt("id_region"));
        region.setNombre(OracleConection.getInstance().getString("region_nombre"));
        region.setOrdinal(OracleConection.getInstance().getString("region_ordinal"));
        return region;
    }
    
    public static ArrayList sqlLeerTodos(){
        ArrayList<ClRegion> region = new ArrayList<>();
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"regiones\"")){
            return null;
        }
        while(OracleConection.getInstance().sqlFetch()){
            region.add(new ClRegion(OracleConection.getInstance().getInt("id_region")
                                    , OracleConection.getInstance().getString("region_nombre")
                                    , OracleConection.getInstance().getString("region_ordinal")
                                ));
            
        }     
        return region;
    }
    
    public static ArrayList sqlBuscarByNombre(String nombre){
        ArrayList<ClRegion> region = new ArrayList<>();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"regiones\" WHERE \"region_nombre\" LIKE '%"+nombre+"%'")){
            return null;
        }
        while(OracleConection.getInstance().sqlFetch()){
            region.add(new ClRegion(OracleConection.getInstance().getInt("id_region")
                                    , OracleConection.getInstance().getString("region_nombre")
                                    , OracleConection.getInstance().getString("region_ordinal")
                                ));
            
        }     
        return region;
    }  
}

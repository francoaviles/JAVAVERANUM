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
    private static final OracleConection bd = new OracleConection().Conectar();
    
    public static boolean sqlInsert(ClRegion region){
        String sql="INSERT INTO \"regiones\" (\"region_nombre\", \"region_ordinal\") VALUES ('"+region.getNombre()+"','"+region.getOrdinal()+"')";
        bd.sqlEjecutar(sql);
        return true;
    }
    
    public static boolean sqlDelete(ClRegion region){
        String sql="DELETE FROM \"regiones\" WHERE \"id_region\" = '"+region.getIdRegion()+"'";
        bd.sqlEjecutar(sql);   
        return true;
    
    }
    
    public static boolean sqlUpdate(ClRegion region){
        String sql="UPDATE \"regiones\" SET \"nombre\" = '"+region.getNombre()+"', \"region_ordinal\" = '"+region.getOrdinal()+"' WHERE \"id_region\" = '"+region.getIdRegion()+"'";
        bd.sqlEjecutar(sql);   
        return true;
    }
    
    public ClRegion sqlLeer(int id){     
        ClRegion region = new ClRegion(); 
        if(!bd.sqlSelect("SELECT * FROM \"regiones\" WHERE \"id_region\" = "+id+" ")){
            return null;
        }        
        if(!bd.sqlFetch()){
            return null;
        }
        region.setIdRegion(bd.getInt("id_region"));
        region.setNombre(bd.getString("region_nombre"));
        region.setOrdinal(bd.getString("region_ordinal"));
        return region;
    }
    
    public static ArrayList sqlLeerTodos(){
        ArrayList<ClRegion> region = new ArrayList<>();
        if(!bd.sqlSelect("SELECT * FROM \"regiones\"")){
            return null;
        }
        while(bd.sqlFetch()){
            region.add(new ClRegion(bd.getInt("id_region")
                                    , bd.getString("region_nombre")
                                    , bd.getString("region_ordinal")
                                ));
            
        }     
        return region;
    }
}

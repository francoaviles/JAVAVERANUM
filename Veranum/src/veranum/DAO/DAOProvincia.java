/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.DAO;

import java.util.ArrayList;
import veranum.entities.ClProvincia;
import veranum.utilidades.OracleConection;

/**
 *
 * @author Zacarias
 */
public class DAOProvincia {
    private static final OracleConection bd = new OracleConection().Conectar();
    
    public static boolean sqlInsert(ClProvincia provincia){
        String sql="INSERT INTO \"provincias\" (\"provincia_nombre\", \"id_region\") VALUES ('"+provincia.getNombre()+"','"+provincia.getIdRegion()+"')";
        bd.sqlEjecutar(sql);
        return true;
    }
    
    public static boolean sqlDelete(ClProvincia provincia){
        String sql="DELETE FROM \"provincias\" WHERE \"id_provincia\" = '"+provincia.getIdProvincia()+"'";
        bd.sqlEjecutar(sql);   
        return true;
    }
    
    public static boolean sqlUpdate(ClProvincia provincia){
        String sql="UPDATE \"provincias\" SET \"provincia_nombre\" = '"+provincia.getNombre()+"' AND \"id_region\" = '"+provincia.getIdRegion()+"'  WHERE \"provincia_nombre\" = '"+provincia.getNombre()+"'";
        bd.sqlEjecutar(sql);   
        return true;
    }
    
    public static ClProvincia sqlLeer(int id){     
        ClProvincia provincia = new ClProvincia();        
        if(!bd.sqlSelect("SELECT * FROM \"provincias\" WHERE \"id_provincia\" ='"+id+"'")){
            return null;
        }        
        if(!bd.sqlFetch()){
            return null;
        }        
        provincia.setIdProvincia(bd.getInt("id_provincia"));
        provincia.setNombre(bd.getString("provincia_nombre"));
        provincia.setIdRegion(bd.getInt("id_region"));
        return provincia;
    }
    
    public static ClProvincia sqlLeer(String name){     
        ClProvincia provincia = new ClProvincia();        
        if(!bd.sqlSelect("SELECT * FROM \"provincias\" WHERE \"id_provincia\" ='"+name+"'")){
            return null;
        }        
        if(!bd.sqlFetch()){
            return null;
        }        
        provincia.setIdProvincia(bd.getInt("id_provincia"));
        provincia.setNombre(bd.getString("provincia_nombre"));
        provincia.setIdRegion(bd.getInt("id_region"));
        return provincia;
    }
    
    public static ArrayList sqlPorRegion(int id){     
        ArrayList<ClProvincia> provincia = new ArrayList<>();
        if(!bd.sqlSelect("SELECT * FROM \"provincias\" WHERE \"id_region\" = "+id+" ")){
            return null;
        }
        while(bd.sqlFetch()){
            provincia.add(new ClProvincia(bd.getInt("id_provincia")
                                    , bd.getString("provincia_nombre")
                                    , bd.getInt("id_region")
                                ));
            
        } 
        return provincia;
    }
    
    public static ArrayList sqlLeerTodos(){
        ArrayList<ClProvincia> provincia = new ArrayList<>();        
        if(!bd.sqlSelect("SELECT * FROM \"provincias\"")){
            return null;
        }
        while(bd.sqlFetch()){
            provincia.add(new ClProvincia(bd.getInt("id_provincia")
                                    , bd.getString("provincia_nombre")
                                    , bd.getInt("id_region")
                                ));
            
        }     
        return provincia;
    }  
    
    public static ArrayList sqlBuscarByNombre(String nombre){
        ArrayList<ClProvincia> pro = new ArrayList<>();        
        if(!bd.sqlSelect("SELECT * FROM \"provincias\" WHERE \"provincia_nombre\" LIKE '%"+nombre+"%'")){
            return null;
        }
        while(bd.sqlFetch()){
            pro.add(new ClProvincia(bd.getInt("id_provincia")
                                    , bd.getString("provincia_nombre")
                                    , bd.getInt("id_region")
                                ));
            
        }     
        return pro;
    }  
    
}

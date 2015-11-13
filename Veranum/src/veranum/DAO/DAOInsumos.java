/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.DAO;

import java.util.ArrayList;
import veranum.entities.ClInsumos;
import veranum.utilidades.OracleConection;

/**
 *
 * @author Zacarias
 */
public class DAOInsumos {
    public static boolean sqlInsert(ClInsumos insumo){
        String sql="INSERT INTO \"insumos\" (\"nombre\", \"descripcion\") VALUES ('"+insumo.getNombre()+"','"+insumo.getDescripcion()+"')";
        OracleConection.getInstance().sqlEjecutar(sql);
        return true;
    }
    
    public static boolean sqlDelete(ClInsumos insumo){
        String sql="DELETE FROM \"insumos\" WHERE \"id_insumo\" = "+insumo.getIdInsumo()+"";
        OracleConection.getInstance().sqlEjecutar(sql);   
        return true;
    }
    
    public static boolean sqlUpdate(ClInsumos insumo){
        String sql="UPDATE \"insumos\" SET \"nombre\" = '"+insumo.getNombre()+"', \"descripcion\" = '"+insumo.getDescripcion()+"'  WHERE \"id_insumo\" = "+insumo.getIdInsumo()+"";
        OracleConection.getInstance().sqlEjecutar(sql);   
        return true;
    }
    
    public static ClInsumos sqlLeer(int id){     
        ClInsumos insumo = new ClInsumos();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"insumos\" WHERE \"id_insumo\" ='"+id+"'")){
            return null;
        }        
        if(!OracleConection.getInstance().sqlFetch()){
            return null;
        }        
        insumo.setIdInsumo(OracleConection.getInstance().getInt("id_insumo"));
        insumo.setNombre(OracleConection.getInstance().getString("nombre"));
        insumo.setDescripcion(OracleConection.getInstance().getString("descripcion"));
        return insumo;
    }
    
    public static ClInsumos sqlLeer(String name){     
        ClInsumos insumo = new ClInsumos();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"insumos\" WHERE \"nombre\" ='"+name+"'")){
            return null;
        }        
        if(!OracleConection.getInstance().sqlFetch()){
            return null;
        }        
        insumo.setIdInsumo(OracleConection.getInstance().getInt("id_insumo"));
        insumo.setNombre(OracleConection.getInstance().getString("nombre"));
        insumo.setDescripcion(OracleConection.getInstance().getString("descripcion"));
        return insumo;
    }
    
    public static ArrayList sqlLeerTodos(){
        ArrayList<ClInsumos> insumo = new ArrayList<>();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"insumos\"")){
            return null;
        }
        while(OracleConection.getInstance().sqlFetch()){
            insumo.add(new ClInsumos(OracleConection.getInstance().getInt("id_insumo")
                                    , OracleConection.getInstance().getString("nombre")
                                    , OracleConection.getInstance().getString("descripcion")
                                ));
            
        }     
        return insumo;
    }
    
    public static ArrayList sqlBuscarByNombre(String nombre){
        ArrayList<ClInsumos> insumo = new ArrayList<>();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"insumos\" WHERE \"nombre\" LIKE '%"+nombre+"%'")){
            return null;
        }
        while(OracleConection.getInstance().sqlFetch()){
            insumo.add(new ClInsumos(OracleConection.getInstance().getInt("id_insumo")
                                    , OracleConection.getInstance().getString("nombre")
                                    , OracleConection.getInstance().getString("descripcion")
                                ));
        }     
        return insumo;
    }
}

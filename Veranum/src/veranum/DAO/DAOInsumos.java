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
    private static final OracleConection bd = new OracleConection().Conectar();
    
    public static boolean sqlInsert(ClInsumos insumo){
        String sql="INSERT INTO \"insumos\" (\"nombre\", \"descripcion\") VALUES ('"+insumo.getNombre()+"','"+insumo.getDescripcion()+"')";
        bd.sqlEjecutar(sql);
        return true;
    }
    
    public static boolean sqlDelete(ClInsumos insumo){
        String sql="DELETE FROM \"insumos\" WHERE \"id_insumo\" = '"+insumo.getIdInsumo()+"'";
        bd.sqlEjecutar(sql);   
        return true;
    }
    
    public static boolean sqlUpdate(ClInsumos insumo){
        String sql="UPDATE \"insumos\" SET \"nombre\" = '"+insumo.getNombre()+"' AND \"descripcion\" = '"+insumo.getDescripcion()+"'  WHERE \"nombre\" = '"+insumo.getNombre()+"'";
        bd.sqlEjecutar(sql);   
        return true;
    }
    
    public static ClInsumos sqlLeer(int id){     
        ClInsumos insumo = new ClInsumos();        
        if(!bd.sqlSelect("SELECT * FROM \"insumos\" WHERE \"id_insumo\" ='"+id+"'")){
            return null;
        }        
        if(!bd.sqlFetch()){
            return null;
        }        
        insumo.setIdInsumo(bd.getInt("id_insumo"));
        insumo.setNombre(bd.getString("nombre"));
        insumo.setDescripcion(bd.getString("descripcion"));
        return insumo;
    }
    
    public static ClInsumos sqlLeer(String name){     
        ClInsumos insumo = new ClInsumos();        
        if(!bd.sqlSelect("SELECT * FROM \"insumos\" WHERE \"nombre\" ='"+name+"'")){
            return null;
        }        
        if(!bd.sqlFetch()){
            return null;
        }        
        insumo.setIdInsumo(bd.getInt("id_insumo"));
        insumo.setNombre(bd.getString("nombre"));
        insumo.setDescripcion(bd.getString("descripcion"));
        return insumo;
    }
    
    public static ArrayList sqlLeerTodos(){
        ArrayList<ClInsumos> insumo = new ArrayList<>();        
        if(!bd.sqlSelect("SELECT * FROM \"insumos\"")){
            return null;
        }
        while(bd.sqlFetch()){
            insumo.add(new ClInsumos(bd.getInt("id_insumo")
                                    , bd.getString("nombre")
                                    , bd.getString("descripcion")
                                ));
            
        }     
        return insumo;
    }
    
    public static ArrayList sqlBuscarByNombre(String nombre){
        ArrayList<ClInsumos> insumo = new ArrayList<>();        
        if(!bd.sqlSelect("SELECT * FROM \"insumos\" WHERE \"nombre\" LIKE '%"+nombre+"%'")){
            return null;
        }
        while(bd.sqlFetch()){
            insumo.add(new ClInsumos(bd.getInt("id_insumo")
                                    , bd.getString("nombre")
                                    , bd.getString("descripcion")
                                ));
        }     
        return insumo;
    }
}

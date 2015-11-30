/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import veranum.entities.ClInsumos;
import veranum.utilidades.OracleConection;

/**
 *
 * @author Zacarias
 */
public class DAOInsumos {
    public static boolean sqlInsert(ClInsumos insumo) throws SQLException{
        String sql="INSERT INTO \"insumos\" (\"nombre\", \"descripcion\") VALUES (?,?)";
        PreparedStatement a = OracleConection.getInstance().sqlPreparar(sql);
        a.setString(1, insumo.getNombre());
        a.setString(2, insumo.getDescripcion());
        
        return OracleConection.getInstance().sqlEjecutarPreparacion();
    }
    
    public static boolean sqlDelete(ClInsumos insumo){
        String sql="DELETE FROM \"insumos\" WHERE \"id_insumo\" = "+insumo.getIdInsumo()+"";
           
        return OracleConection.getInstance().sqlEjecutar(sql);
    }
    
    public static boolean sqlUpdate(ClInsumos insumo) throws SQLException{
        String sql="UPDATE \"insumos\" SET \"nombre\" = ?, \"descripcion\" = ?  WHERE \"id_insumo\" = ?";
        PreparedStatement a = OracleConection.getInstance().sqlPreparar(sql);
        a.setString(1, insumo.getNombre());
        a.setString(2, insumo.getDescripcion());
        a.setInt(3, insumo.getIdInsumo());
         
        return OracleConection.getInstance().sqlEjecutarPreparacion();
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

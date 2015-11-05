/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.DAO;

import java.util.ArrayList;
import veranum.entities.ClServicios;
import veranum.utilidades.OracleConection;

/**
 *
 * @author Zacarias
 */
public class DAOServicios {
    private static final OracleConection bd = new OracleConection().Conectar();
    
    public static boolean sqlInsert(ClServicios servicios){
        String sql="INSERT INTO \"servicios\" (\"nombre\", \"precio\") VALUES ('"+servicios.getNombre()+"', '"+servicios.getPrecio()+"')";
        bd.sqlEjecutar(sql);
        return true;
    }
    
    public static boolean sqlDelete(ClServicios servicios){
        String sql="DELETE FROM \"servicios\" WHERE \"id_servicio\" = '"+servicios.getIdServicio()+"'";
        bd.sqlEjecutar(sql);   
        return true;
    }
    
    public static boolean sqlUpdate(ClServicios servicios)
    {
        String sql="UPDATE \"servicios\" SET \"nombre\" = '"+servicios.getNombre()+"', \"precio\" = '"+servicios.getPrecio()+"' WHERE \"nombre\" = '"+servicios.getNombre()+"'";
        bd.sqlEjecutar(sql);   
        return true;
    }
    
    public static ClServicios sqlLeer(String name){     
        ClServicios servicio = new ClServicios();        
        if(!bd.sqlSelect("SELECT * FROM \"servicios\" WHERE \"nombre\" ="+name+"")){
            return null;
        }        
        if(!bd.sqlFetch()){
            return null;
        }        
        servicio.setIdServicio(bd.getInt("id_servicio"));
        servicio.setNombre(bd.getString("nombre"));
        servicio.setPrecio(bd.getInt("precio"));
        return servicio;
    }
    
    public static ArrayList sqlLeerTodos(){
        ArrayList<ClServicios> servicio = new ArrayList<>();        
        if(!bd.sqlSelect("SELECT * FROM \"servicios\"")){
            return null;
        }
        while(bd.sqlFetch()){
            servicio.add(new ClServicios(bd.getInt("id_servicio")
                                    , bd.getString("nombre")
                                    , bd.getInt("precio")
                                ));
            
        }     
        return servicio;
    }    
}

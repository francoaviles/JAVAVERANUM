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
    public static boolean sqlInsert(ClServicios servicios){
        String sql="INSERT INTO \"servicios\" (\"nombre\", \"precio\") VALUES ('"+servicios.getNombre()+"', '"+servicios.getPrecio()+"')";
        OracleConection.getInstance().sqlEjecutar(sql);
        return true;
    }
    
    public static boolean sqlDelete(ClServicios servicios){
        String sql="DELETE FROM \"servicios\" WHERE \"id_servicio\" = "+servicios.getIdServicio()+"";
        OracleConection.getInstance().sqlEjecutar(sql);   
        return true;
    }
    
    public static boolean sqlUpdate(ClServicios servicios)
    {
        String sql="UPDATE \"servicios\" SET \"nombre\" = '"+servicios.getNombre()+"', \"precio\" = '"+servicios.getPrecio()+"' WHERE \"id_servicio\" = "+servicios.getIdServicio()+"";
        OracleConection.getInstance().sqlEjecutar(sql);   
        return true;
    }
    
    public static ClServicios sqlLeer(String name){     
        ClServicios servicio = new ClServicios();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"servicios\" WHERE \"nombre\" ='"+name+"'")){
            return null;
        }        
        if(!OracleConection.getInstance().sqlFetch()){
            return null;
        }        
        servicio.setIdServicio(OracleConection.getInstance().getInt("id_servicio"));
        servicio.setNombre(OracleConection.getInstance().getString("nombre"));
        servicio.setPrecio(OracleConection.getInstance().getInt("precio"));
        return servicio;
    }
    
    public static ClServicios sqlLeer(int id){     
        ClServicios servicio = new ClServicios();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"servicios\" WHERE \"id_servicio\" ='"+id+"'")){
            return null;
        }        
        if(!OracleConection.getInstance().sqlFetch()){
            return null;
        }        
        servicio.setIdServicio(OracleConection.getInstance().getInt("id_servicio"));
        servicio.setNombre(OracleConection.getInstance().getString("nombre"));
        servicio.setPrecio(OracleConection.getInstance().getInt("precio"));
        return servicio;
    }
    
    public static ArrayList sqlLeerTodos(){
        ArrayList<ClServicios> servicio = new ArrayList<>();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"servicios\"")){
            return null;
        }
        while(OracleConection.getInstance().sqlFetch()){
            servicio.add(new ClServicios(OracleConection.getInstance().getInt("id_servicio")
                                    , OracleConection.getInstance().getString("nombre")
                                    , OracleConection.getInstance().getInt("precio")
                                ));
            
        }     
        return servicio;
    }    
    
    public static ArrayList sqlBuscarByNombre(String nombre){
        ArrayList<ClServicios> servicio = new ArrayList<>();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"servicios\" WHERE \"nombre\" LIKE '%"+nombre+"%'")){
            return null;
        }
        while(OracleConection.getInstance().sqlFetch()){
            servicio.add(new ClServicios(OracleConection.getInstance().getInt("id_servicio")
                                    , OracleConection.getInstance().getString("nombre")
                                    , OracleConection.getInstance().getInt("precio")
                                ));
            
        }     
        return servicio;
    }  
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import veranum.entities.ClServicios;
import veranum.utilidades.OracleConection;

/**
 *
 * @author Zacarias
 */
public class DAOServicios {
    public static boolean sqlInsert(ClServicios servicios) throws SQLException{
        String sql="INSERT INTO \"servicios\" (\"nombre\", \"precio\") VALUES (?,?)";
        PreparedStatement a = OracleConection.getInstance().sqlPreparar(sql);
        a.setString(1, servicios.getNombre());
        a.setInt(2, servicios.getPrecio());
        
        return OracleConection.getInstance().sqlEjecutarPreparacion();
    }
    
    public static boolean sqlDelete(ClServicios servicios){
        String sql="DELETE FROM \"servicios\" WHERE \"id_servicio\" = "+servicios.getIdServicio()+"";
        
        return OracleConection.getInstance().sqlEjecutar(sql);   
    }
    
    public static boolean sqlUpdate(ClServicios servicios) throws SQLException{
        String sql="UPDATE \"servicios\" SET \"nombre\" = ?, \"precio\" = ? WHERE \"id_servicio\" = ?";
        PreparedStatement a = OracleConection.getInstance().sqlPreparar(sql);
        a.setString(1, servicios.getNombre());
        a.setInt(2, servicios.getPrecio());
        a.setInt(3, servicios.getIdServicio());
        
        return OracleConection.getInstance().sqlEjecutarPreparacion();  
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

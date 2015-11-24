/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import veranum.entities.ClTipoHabitacion;
import veranum.utilidades.OracleConection;

/**
 *
 * @author Zacarias
 */
public class DAOTipoHab {
    public static boolean sqlInsert(ClTipoHabitacion hab) throws SQLException{
        String sql="INSERT INTO \"habitacion_tipos\" (\"nombre\") VALUES (?)";
        PreparedStatement a = OracleConection.getInstance().sqlPreparar(sql);
        a.setString(1, hab.getNombre());
        OracleConection.getInstance().sqlEjecutarPreparacion();
        return true;
    }
    
    public static boolean sqlDelete(ClTipoHabitacion hab){
        String sql="DELETE FROM \"habitacion_tipos\" WHERE \"id_habitacion_tipo\" = "+hab.getIdTipoHabit()+"";
        OracleConection.getInstance().sqlEjecutar(sql);   
        return true;
    }
    
    public static boolean sqlUpdate(ClTipoHabitacion hab) throws SQLException{
        String sql="UPDATE \"habitacion_tipos\" SET \"nombre\" = ? WHERE \"id_habitacion_tipo\" = ?";
        PreparedStatement a = OracleConection.getInstance().sqlPreparar(sql);
        a.setString(1, hab.getNombre());
        a.setInt(2, hab.getIdTipoHabit());
        OracleConection.getInstance().sqlEjecutarPreparacion();   
        return true;
    }
    
    public static ClTipoHabitacion sqlLeer(int id){     
        ClTipoHabitacion hab = new ClTipoHabitacion();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"habitacion_tipos\" WHERE \"id_habitacion_tipo\" ='"+id+"'")){
            return null;
        }        
        if(!OracleConection.getInstance().sqlFetch()){
            return null;
        }        
        hab.setIdTipoHabit(OracleConection.getInstance().getInt("id_habitacion_tipo"));
        hab.setNombre(OracleConection.getInstance().getString("nombre"));
        return hab;
    }
    
    public static ClTipoHabitacion sqlLeer(String name){     
        ClTipoHabitacion hab = new ClTipoHabitacion();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"habitacion_tipos\" WHERE \"nombre\" ='"+name+"'")){
            return null;
        }        
        if(!OracleConection.getInstance().sqlFetch()){
            return null;
        }        
        hab.setIdTipoHabit(OracleConection.getInstance().getInt("id_habitacion_tipo"));
        hab.setNombre(OracleConection.getInstance().getString("nombre"));
        return hab;
    }
    
    public static ArrayList sqlLeerTodos(){
        ArrayList<ClTipoHabitacion> hab = new ArrayList<>();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"habitacion_tipos\"")){
            return null;
        }
        while(OracleConection.getInstance().sqlFetch()){
            hab.add(new ClTipoHabitacion(OracleConection.getInstance().getInt("id_habitacion_tipo")
                                    , OracleConection.getInstance().getString("nombre")
                                ));
            
        }     
        return hab;
    }
    
    public static ArrayList sqlBuscarByNombre(String nombre){
        ArrayList<ClTipoHabitacion> hab = new ArrayList<>();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"habitacion_tipos\" WHERE \"nombre\" LIKE '%"+nombre+"%'")){
            return null;
        }
        while(OracleConection.getInstance().sqlFetch()){
            hab.add(new ClTipoHabitacion(OracleConection.getInstance().getInt("id_habitacion_tipo")
                                    , OracleConection.getInstance().getString("nombre")
                                )); 
        }     
        return hab;
    }
}

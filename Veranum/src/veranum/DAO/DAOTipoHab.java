/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.DAO;

import java.util.ArrayList;
import veranum.entities.ClTipoHabitacion;
import veranum.utilidades.OracleConection;

/**
 *
 * @author Zacarias
 */
public class DAOTipoHab {
    public static boolean sqlInsert(ClTipoHabitacion hab){
        String sql="INSERT INTO \"habitacion_tipos\" (\"nombre\") VALUES ('"+hab.getNombre()+"')";
        OracleConection.getInstance().sqlEjecutar(sql);
        return true;
    }
    
    public static boolean sqlDelete(ClTipoHabitacion hab){
        String sql="DELETE FROM \"habitacion_tipos\" WHERE \"id_habitacion_tipo\" = "+hab.getIdTipoHabit()+"";
        OracleConection.getInstance().sqlEjecutar(sql);   
        return true;
    }
    
    public static boolean sqlUpdate(ClTipoHabitacion hab){
        String sql="UPDATE \"habitacion_tipos\" SET \"nombre\" = '"+hab.getNombre()+"' WHERE \"id_habitacion_tipo\" = "+hab.getIdTipoHabit()+"";
        OracleConection.getInstance().sqlEjecutar(sql);   
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

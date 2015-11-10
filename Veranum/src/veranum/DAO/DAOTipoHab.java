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
    private static final OracleConection bd = new OracleConection().Conectar();
    
    public static boolean sqlInsert(ClTipoHabitacion hab){
        String sql="INSERT INTO \"habitacion_tipo\" (\"id_tipo_habitacion\", \"nombre\") VALUES ('"+hab.getIdTipoHabit()+"', '"+hab.getNombre()+"')";
        bd.sqlEjecutar(sql);
        return true;
    }
    
    public static boolean sqlDelete(ClTipoHabitacion hab){
        String sql="DELETE FROM \"habitacion_tipo\" WHERE \"id_tipo_habitacion\" = "+hab.getIdTipoHabit()+"";
        bd.sqlEjecutar(sql);   
        return true;
    }
    
    public static boolean sqlUpdate(ClTipoHabitacion hab){
        String sql="UPDATE \"habitacion_tipo\" SET \"nombre\" = '"+hab.getNombre()+"' WHERE \"id_tipo_habitacion\" = "+hab.getIdTipoHabit()+"";
        bd.sqlEjecutar(sql);   
        return true;
    }
    
    public static ClTipoHabitacion sqlLeer(int id){     
        ClTipoHabitacion hab = new ClTipoHabitacion();        
        if(!bd.sqlSelect("SELECT * FROM \"habitacion_tipo\" WHERE \"id_tipo_habitacion\" ='"+id+"'")){
            return null;
        }        
        if(!bd.sqlFetch()){
            return null;
        }        
        hab.setIdTipoHabit(bd.getInt("id_tipo_habitacion"));
        hab.setNombre(bd.getString("nombre"));
        return hab;
    }
    
    public static ClTipoHabitacion sqlLeer(String name){     
        ClTipoHabitacion hab = new ClTipoHabitacion();        
        if(!bd.sqlSelect("SELECT * FROM \"habitacion_tipo\" WHERE \"nombre\" ='"+name+"'")){
            return null;
        }        
        if(!bd.sqlFetch()){
            return null;
        }        
        hab.setIdTipoHabit(bd.getInt("id_tipo_habitacion"));
        hab.setNombre(bd.getString("nombre"));
        return hab;
    }
    
    public static ArrayList sqlLeerTodos(){
        ArrayList<ClTipoHabitacion> hab = new ArrayList<>();        
        if(!bd.sqlSelect("SELECT * FROM \"habitacion_tipo\"")){
            return null;
        }
        while(bd.sqlFetch()){
            hab.add(new ClTipoHabitacion(bd.getInt("id_tipo_habitacion")
                                    , bd.getString("nombre")
                                ));
            
        }     
        return hab;
    }
    
    public static ArrayList sqlBuscarByNombre(String nombre){
        ArrayList<ClTipoHabitacion> hab = new ArrayList<>();        
        if(!bd.sqlSelect("SELECT * FROM \"habitacion_tipo\" WHERE \"nombre\" LIKE '%"+nombre+"%'")){
            return null;
        }
        while(bd.sqlFetch()){
            hab.add(new ClTipoHabitacion(bd.getInt("id_tipo_habitacion")
                                    , bd.getString("nombre")
                                )); 
        }     
        return hab;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.DAO;

import java.util.ArrayList;
import veranum.entities.ClHabitacionEstados;
import veranum.utilidades.OracleConection;

/**
 *
 * @author Zacarias
 */
public class DAOEstadoHab {
    private static final OracleConection bd = new OracleConection().Conectar();
    
    public static boolean sqlInsert(ClHabitacionEstados estado){
        String sql="INSERT INTO \"habitacion_estados\" (\"estado\") VALUES ('"+estado.getEstado()+"')";
        bd.sqlEjecutar(sql);
        return true;
    }
    
    public static boolean sqlDelete(ClHabitacionEstados estado){
        String sql="DELETE FROM \"habitacion_estados\" WHERE \"id_habitacion_estado\" = "+estado.getIdHabitacionEstado()+"";
        bd.sqlEjecutar(sql);   
        return true;
    }
    
    public static boolean sqlUpdate(ClHabitacionEstados estado){
        String sql="UPDATE \"habitacion_estados\" SET \"estado\" = '"+estado.getEstado()+"' WHERE \"id_habitacion_estado\" = "+estado.getIdHabitacionEstado()+"";
        bd.sqlEjecutar(sql);   
        return true;
    }
    
    public static ClHabitacionEstados sqlLeer(String name){     
        ClHabitacionEstados estado = new ClHabitacionEstados();        
        if(!bd.sqlSelect("SELECT * FROM \"habitacion_estados\" WHERE \"estado\" ='"+name+"'")){
            return null;
        }        
        if(!bd.sqlFetch()){
            return null;
        }        
        estado.setIdHabitacionEstado(bd.getInt("id_habitacion_estado"));
        estado.setEstado(bd.getString("estado"));
        return estado;
    }
    
    public static ClHabitacionEstados sqlLeer(int id){     
        ClHabitacionEstados estado = new ClHabitacionEstados();        
        if(!bd.sqlSelect("SELECT * FROM \"habitacion_estados\" WHERE \"ud_habitacion_estado\" ='"+id+"'")){
            return null;
        }        
        if(!bd.sqlFetch()){
            return null;
        }        
        estado.setIdHabitacionEstado(bd.getInt("id_habitacion_estado"));
        estado.setEstado(bd.getString("estado"));
        return estado;
    }
    
    public static ArrayList sqlLeerTodos(){
        ArrayList<ClHabitacionEstados> estado = new ArrayList<>();        
        if(!bd.sqlSelect("SELECT * FROM \"habitacion_estados\"")){
            return null;
        }
        while(bd.sqlFetch()){
            estado.add(new ClHabitacionEstados(bd.getInt("id_habitacion_estadoo")
                                    , bd.getString("estado")
                                ));
            
        }     
        return estado;
    }    
    
    public static ArrayList sqlBuscarByNombre(String nombre){
        ArrayList<ClHabitacionEstados> estado = new ArrayList<>();        
        if(!bd.sqlSelect("SELECT * FROM \"habitacion_estados\" WHERE \"estado\" LIKE '%"+nombre+"%'")){
            return null;
        }
        while(bd.sqlFetch()){
            estado.add(new ClHabitacionEstados(bd.getInt("id_habitacion_estadoo")
                                    , bd.getString("estado")
                                ));
            
        }     
        return estado;
    }
}

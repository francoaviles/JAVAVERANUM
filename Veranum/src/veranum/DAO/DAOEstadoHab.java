/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import veranum.entities.ClHabitacionEstados;
import veranum.utilidades.OracleConection;

/**
 *
 * @author Zacarias
 */
public class DAOEstadoHab {
    public static boolean sqlInsert(ClHabitacionEstados estado) throws SQLException{
        String sql="INSERT INTO \"habitacion_estados\" (\"estado\") VALUES (?)";
        PreparedStatement a = OracleConection.getInstance().sqlPreparar(sql);
        a.setString(1, estado.getEstado());
        OracleConection.getInstance().sqlEjecutarPreparacion();
        return true;
    }
    
    public static boolean sqlDelete(ClHabitacionEstados estado){
        String sql="DELETE FROM \"habitacion_estados\" WHERE \"id_habitacion_estado\" = "+estado.getIdHabitacionEstado()+"";
        OracleConection.getInstance().sqlEjecutar(sql);   
        return true;
    }
    
    public static boolean sqlUpdate(ClHabitacionEstados estado) throws SQLException{
        String sql="UPDATE \"habitacion_estados\" SET \"estado\" = ? WHERE \"id_habitacion_estado\" = ?";
        PreparedStatement a = OracleConection.getInstance().sqlPreparar(sql);
        a.setString(1, estado.getEstado());
        a.setInt(2, estado.getIdHabitacionEstado());        
        OracleConection.getInstance().sqlEjecutarPreparacion();  
        return true;
    }
    
    public static ClHabitacionEstados sqlLeer(String name){     
        ClHabitacionEstados estado = new ClHabitacionEstados();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"habitacion_estados\" WHERE \"estado\" ='"+name+"'")){
            return null;
        }        
        if(!OracleConection.getInstance().sqlFetch()){
            return null;
        }        
        estado.setIdHabitacionEstado(OracleConection.getInstance().getInt("id_habitacion_estado"));
        estado.setEstado(OracleConection.getInstance().getString("estado"));
        return estado;
    }
    
    public static ClHabitacionEstados sqlLeer(int id){     
        ClHabitacionEstados estado = new ClHabitacionEstados();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"habitacion_estados\" WHERE \"id_habitacion_estado\" ="+id+"")){
            return null;
        }        
        if(!OracleConection.getInstance().sqlFetch()){
            return null;
        }        
        estado.setIdHabitacionEstado(OracleConection.getInstance().getInt("id_habitacion_estado"));
        estado.setEstado(OracleConection.getInstance().getString("estado"));
        return estado;
    }
    
    public static ArrayList sqlLeerTodos(){
        ArrayList<ClHabitacionEstados> estado = new ArrayList<>();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"habitacion_estados\"")){
            return null;
        }
        while(OracleConection.getInstance().sqlFetch()){
            estado.add(new ClHabitacionEstados(OracleConection.getInstance().getInt("id_habitacion_estado")
                                    , OracleConection.getInstance().getString("estado")
                                ));
            
        }     
        return estado;
    }    
    
    public static ArrayList sqlBuscarByNombre(String est){
        ArrayList<ClHabitacionEstados> estado = new ArrayList<>();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"habitacion_estados\" WHERE \"estado\" LIKE '%"+est+"%'")){
            return null;
        }
        while(OracleConection.getInstance().sqlFetch()){
            estado.add(new ClHabitacionEstados(OracleConection.getInstance().getInt("id_habitacion_estado")
                                    , OracleConection.getInstance().getString("estado")
                                ));
            
        }     
        return estado;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.DAO;

import java.util.ArrayList;
import veranum.entities.ClHabitacionCaract;
import veranum.utilidades.OracleConection;

/**
 *
 * @author Zacarias
 */
public class DAOHabCaract {
    public static boolean sqlInsert(ClHabitacionCaract habCaract){
        String sql="INSERT INTO \"habitaciones_caracteristicas\" (\"id_habitacion\", \"id_caracteristica\") VALUES ('"+habCaract.getIdHabitacion()+"','"+habCaract.getIdCaract()+"')";
        OracleConection.getInstance().sqlEjecutar(sql);
        return true;
    }
    
    public static boolean sqlDelete(ClHabitacionCaract habCaract){
        String sql="DELETE FROM \"habitaciones_caracteristicas\" WHERE \"id_habitacion\" = "+habCaract.getIdHabitacion()+" AND \"id_caracteristica\" = "+habCaract.getIdCaract()+" ";
        OracleConection.getInstance().sqlEjecutar(sql);   
        return true;
    
    }
    
    public static boolean sqlUpdate(ClHabitacionCaract habCaract){
        String sql="UPDATE \"habitaciones_caracteristicas\" SET \"id_habitacion\" = '"+habCaract.getIdHabitacion()+"', \"id_caracteristica\" = '"+habCaract.getIdCaract()+"' WHERE \"id_habitacion\" = "+habCaract.getIdHabitacion()+"";
        OracleConection.getInstance().sqlEjecutar(sql);   
        return true;
    }
    
    public static ClHabitacionCaract sqlLeer(int id_habitacion, int id_caract){     
        ClHabitacionCaract habCaract = new ClHabitacionCaract();
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"habitaciones_caracteristicas\" WHERE \"id_habitacion\" ='"+id_habitacion+"' AND \"id_caracteristica\" ='"+id_caract+"' ")){
            return null;
        }        
        if(!OracleConection.getInstance().sqlFetch()){
            return null;
        }
        habCaract.setIdHabitacion(OracleConection.getInstance().getInt("id_habitacion"));
        habCaract.setIdCaract(OracleConection.getInstance().getInt("id_caracteristica"));
        return habCaract;
    }
    
    public static ArrayList sqlLeerTodos(){
        ArrayList<ClHabitacionCaract> habCaract = new ArrayList<>();
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"habitaciones_caracteristicas\"")){
            return null;
        }
        while(OracleConection.getInstance().sqlFetch()){
            habCaract.add(new ClHabitacionCaract(OracleConection.getInstance().getInt("id_habitacion")
                                    , OracleConection.getInstance().getInt("id_caracteristica")
                                ));
            
        }     
        return habCaract;
    }
}

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
        
        return OracleConection.getInstance().sqlEjecutar(sql);
    }
    
    public static boolean sqlDelete(ClHabitacionCaract habCaract){
        String sql="DELETE FROM \"habitaciones_caracteristicas\"" +
                    "WHERE \"id_caracteristica\" = "+habCaract.getIdCaract()+" " +
                    "AND  \"id_habitacion\" = "+habCaract.getIdHabitacion()+" ";
       
        return  OracleConection.getInstance().sqlEjecutar(sql);   
    
    }
    
    /*public static boolean sqlUpdate(ClHabitacionCaract habCaract, ClHabitacionCaract habCaract2){
        String sql="UPDATE \"habitaciones_caracteristicas\" SET " +
                    "\"id_caracteristica\" = "+habCaract.getIdCaract()+"," +
                    "\"id_habitacion\" = "+habCaract.getIdHabitacion()+"" +
                    " WHERE \"id_caracteristica\" = "+habCaract2.getIdCaract()+"" +
                    " AND \"id_habitacion\" = "+habCaract2.getIdHabitacion()+"";
        System.out.println(sql);
        OracleConection.getInstance().sqlEjecutar(sql);   
        return true;
    }*/
    
    public static ClHabitacionCaract sqlLeer(int id_habitacion, int id_caract){     
        ClHabitacionCaract habCaract = new ClHabitacionCaract();
        if(!OracleConection.getInstance().sqlSelect("SELECT \n" +
"\"habitaciones\".\"id_habitacion\",\n" +
"\"caracteristicas\".\"id_caracteristica\",\n" +
"\"hoteles\".\"nombre\" as \"hotel_nombre\",\n" +
"\"habitaciones\".\"ubicacion\",\n" +
"\"habitaciones\".\"cant_personas\",\n" +
"\"tipo_caracteristicas\".\"nombre\" as \"tipo_nombre\"\n" +
"FROM \"caracteristicas\"\n" +
"LEFT JOIN \"habitaciones_caracteristicas\" ON  \"habitaciones_caracteristicas\".\"id_caracteristica\" = \"caracteristicas\".\"id_caracteristica\"\n" +
"LEFT JOIN \"tipo_caracteristicas\" ON  \"tipo_caracteristicas\".\"id_tipo_caract\" = \"caracteristicas\".\"id_tipo_caract\"\n" +
"LEFT JOIN \"habitaciones\" ON  \"habitaciones_caracteristicas\".\"id_habitacion\" = \"habitaciones\".\"id_habitacion\"\n" +
"LEFT JOIN \"hoteles\" ON  \"hoteles\".\"id_hotel\" = \"habitaciones\".\"id_hotel\"\n" +
" WHERE \"caracteristicas\".\"tipo\" = 'Habitación'"
                + "AND \"habitaciones\".\"id_habitacion\" = "+id_habitacion+""
                + "AND  \"habitaciones_caracteristicas\".\"id_caracteristica\" =  "+id_caract+" ")){
            return null;
        }        
        if(!OracleConection.getInstance().sqlFetch()){
            return null;
        }
        habCaract.setIdHabitacion(OracleConection.getInstance().getInt("id_habitacion"));
        habCaract.setIdCaract(OracleConection.getInstance().getInt("id_caracteristica"));
        habCaract.setNombreHotel(OracleConection.getInstance().getString("hotel_nombre"));
        habCaract.setUbicacion(OracleConection.getInstance().getInt("habitacion_ubicacion"));
        habCaract.setCantPersonas(OracleConection.getInstance().getInt("cantPersonas"));
        habCaract.setNombreHotel(OracleConection.getInstance().getString("tipo_nombre"));
        return habCaract;
    }
    
    public static ArrayList sqlLeerTodos(){
        ArrayList<ClHabitacionCaract> habCaract = new ArrayList<>();
        if(!OracleConection.getInstance().sqlSelect("SELECT \n" +
"\"habitaciones\".\"id_habitacion\",\n" +
"\"caracteristicas\".\"id_caracteristica\",\n" +
"\"hoteles\".\"nombre\" as \"hotel_nombre\",\n" +
"\"habitaciones\".\"ubicacion\",\n" +
"\"habitaciones\".\"cant_personas\",\n" +
"\"tipo_caracteristicas\".\"nombre\" as \"tipo_nombre\"\n" +
"FROM \"caracteristicas\"\n" +
"LEFT JOIN \"habitaciones_caracteristicas\" ON  \"habitaciones_caracteristicas\".\"id_caracteristica\" = \"caracteristicas\".\"id_caracteristica\"\n" +
"LEFT JOIN \"tipo_caracteristicas\" ON  \"tipo_caracteristicas\".\"id_tipo_caract\" = \"caracteristicas\".\"id_tipo_caract\"\n" +
"LEFT JOIN \"habitaciones\" ON  \"habitaciones_caracteristicas\".\"id_habitacion\" = \"habitaciones\".\"id_habitacion\"\n" +
"LEFT JOIN \"hoteles\" ON  \"hoteles\".\"id_hotel\" = \"habitaciones\".\"id_hotel\"\n" +
" WHERE \"caracteristicas\".\"tipo\" = 'Habitación'")){
            return null;
        }
        while(OracleConection.getInstance().sqlFetch()){
            habCaract.add(new ClHabitacionCaract(OracleConection.getInstance().getInt("id_habitacion")
                                    , OracleConection.getInstance().getInt("id_caracteristica")
                                    , OracleConection.getInstance().getString("hotel_nombre")
                                    , OracleConection.getInstance().getInt("ubicacion")
                                    , OracleConection.getInstance().getInt("cant_personas")
                                    , OracleConection.getInstance().getString("tipo_nombre")
                                ));
            
        }     
        return habCaract;
    }
    
}

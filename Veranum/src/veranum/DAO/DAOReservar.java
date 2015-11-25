/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import veranum.entities.ClHabitaciones;
import veranum.entities.ClHoteles;
import veranum.entities.ClTipoHabitacion;
import veranum.utilidades.OracleConection;

/**
 *
 * @author Duoc
 */
public class DAOReservar {
    public static ArrayList sqlBuscarHabitacion(int hotel, int tipo, int cant) throws SQLException{
        ArrayList<ClHabitaciones> habitacion = new ArrayList<>();  
        
        String and = " ";
        if(tipo != 0) {
            and += "AND \"id_habitacion_tipo\" = ?";
        }
        if (cant > 0) {
            and += "AND \"cant_personas\" >= ? ";
        }
        String sql = "SELECT * FROM \"habitaciones\" WHERE \"id_hotel\" = ? AND \"id_habitacion_estado\" = ? "+and;
        PreparedStatement a = OracleConection.getInstance().sqlPreparar(sql);
        a.setInt(1, hotel);
        a.setInt(2, 1);
        if(tipo != 0)
             a.setInt(3, tipo);
        if(cant > 0 && tipo != 0)
            a.setInt(4, cant);
        else if(cant > 0)
            a.setInt(3, cant);
        
        OracleConection.getInstance().sqlEjecutarPreparacion();
        
        while(OracleConection.getInstance().sqlFetch()){
            habitacion.add(new ClHabitaciones(OracleConection.getInstance().getInt("id_habitacion")
                                    , OracleConection.getInstance().getInt("id_hotel")
                                    , OracleConection.getInstance().getInt("id_habitacion_tipo")
                                    , OracleConection.getInstance().getInt("id_habitacion_estado")
                                    , OracleConection.getInstance().getString("ubicacion")
                                    , OracleConection.getInstance().getInt("cant_personas")
                                    , OracleConection.getInstance().getInt("precio")
                                ));
            
        }     
        return habitacion;

    }
}

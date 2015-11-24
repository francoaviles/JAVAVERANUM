/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.DAO;

import veranum.entities.ClHoteles;
import veranum.entities.ClTipoHabitacion;
import veranum.utilidades.OracleConection;

/**
 *
 * @author Duoc
 */
public class DAOReservar {
    public static boolean sqlBuscarHabitacion(ClHoteles hotel, ClTipoHabitacion tipo, int cant){
        String and = " ";
        if(tipo != null) {
            and += "AND \"id_habitacion_tipo\" = "+tipo.getIdTipoHabit()+"";
        }
        String sql = "SELECT * FROM \"habitaciones\" WHERE \"id_hotel\" = "+hotel.getIdHotel()+" ";
        OracleConection.getInstance().sqlEjecutar(sql);   
        return true;
    }
}

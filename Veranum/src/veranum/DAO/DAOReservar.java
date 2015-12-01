/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import veranum.entities.ClConsultarReserva;
import veranum.entities.ClHabitaciones;
import veranum.entities.ClReservar;
import veranum.entities.ClServicios;
import veranum.utilidades.OracleConection;

/**
 *
 * @author Duoc
 */
public class DAOReservar {
    
    public static boolean sqlInsert(ClReservar reserva) throws SQLException{
        String sql="INSERT INTO \"reservas\" (\"id_pasajero\", \"id_reserva_estado\", \"fecha_ingreso\", \"fecha_salida\", \"precio_total\" ) VALUES (?,?,?,?,?)";
        PreparedStatement a = OracleConection.getInstance().sqlPreparar(sql);
        a.setInt(1, reserva.getUsuario().getIdPasajero());
        a.setInt(2, reserva.getEstado().getIdReserva());
        a.setDate(3, (new java.sql.Date(reserva.getFechaIngreso().getTime())));
        a.setDate(4, (new java.sql.Date(reserva.getFechaSalida().getTime())));
        a.setLong(5, reserva.getTotal());
        OracleConection.getInstance().sqlEjecutarPreparacion();
        
        int id_reserva = DAOReservar.sqlLastID();
        // habitaciones 
        for(int i = 0; i < reserva.getReservas().size(); i++){
            ClHabitaciones xx = (ClHabitaciones)reserva.getReservas().get(i);
            String sql_habitacion = "INSERT INTO \"habitaciones_reservas\" (\"id_habitacion\", \"id_reserva\") VALUES (?,?) ";
            PreparedStatement b = OracleConection.getInstance().sqlPreparar(sql_habitacion);
            b.setInt(1, xx.getIdHabitacion());
            b.setInt(2, id_reserva);
            OracleConection.getInstance().sqlEjecutarPreparacion();
            
            String sql_update="UPDATE \"habitaciones\" SET  \"id_habitacion_estado\" = ? WHERE \"id_habitacion\" = ?";
            PreparedStatement bb = OracleConection.getInstance().sqlPreparar(sql_update);
            bb.setInt(1, 3);
            bb.setInt(2, xx.getIdHabitacion());
            OracleConection.getInstance().sqlEjecutarPreparacion();
        }
        // servicios
        for(int i = 0; i < reserva.getServicios().size(); i++){
            ClServicios xx = (ClServicios)reserva.getServicios().get(i);
            String sql_habitacion = "INSERT INTO \"servicios_reservas\" (\"id_servicio\", \"id_reserva\") VALUES (?,?) ";
            PreparedStatement b = OracleConection.getInstance().sqlPreparar(sql_habitacion);
            b.setInt(1, xx.getIdServicio());
            b.setInt(2, id_reserva);
            OracleConection.getInstance().sqlEjecutarPreparacion();
        }
        
        return true;
    }
    
    
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
    
    public static boolean sqlUpdateEstadoReserva(int idreserva, int idestado) throws SQLException{
        String sql="UPDATE \"reservas\" SET \"id_reserva_estado\" = ? WHERE \"id_reserva\" = ?";
        PreparedStatement a = OracleConection.getInstance().sqlPreparar(sql);
        a.setInt(1, idestado);
        a.setInt(2, idreserva);        
        return OracleConection.getInstance().sqlEjecutarPreparacion(); 
    }
    public static  ArrayList<ClConsultarReserva> sqlConsultar(String rut, int id) throws SQLException{
        ArrayList<ClConsultarReserva> reserva = new ArrayList<>();  
        
        String sql = "SELECT \n" +
                    "  \"pasajeros\".\"rut\",\n" +
                    "  \"reservas\".\"id_reserva\",\n" +
                    "  \"reservas\".\"fecha_ingreso\",\n" +
                    "  \"reservas\".\"fecha_salida\",\n" +
                    "  \"reservas\".\"precio_total\",\n" +
                    "  \"estado_reservas\".\"nombre\" AS \"estado\",\n" +
                    "  (SELECT COUNT(*) FROM \"servicios_reservas\" WHERE  \"servicios_reservas\".\"id_reserva\" = \"reservas\".\"id_reserva\") AS \"total_servicios\",\n" +
                    "  (SELECT COUNT(*) FROM \"habitaciones_reservas\" WHERE  \"habitaciones_reservas\".\"id_reserva\" = \"reservas\".\"id_reserva\") AS \"total_habs\"\n" +
                    "FROM \"reservas\"\n" +
                    "LEFT JOIN \"pasajeros\" ON  \"reservas\".\"id_pasajero\" = \"pasajeros\".\"id_pasajero\"\n" +
                    "LEFT JOIN \"estado_reservas\" ON  \"reservas\".\"id_reserva_estado\" = \"estado_reservas\".\"id_reserva_estado\"\n" +
                    "WHERE \"pasajeros\".\"rut\" = ?\n" +
                    "OR \"reservas\".\"id_reserva\" = ?";
        
        PreparedStatement a = OracleConection.getInstance().sqlPreparar(sql);
        a.setString(1, rut);
        a.setInt(2, id);
        OracleConection.getInstance().sqlEjecutarPreparacion();
        
        while(OracleConection.getInstance().sqlFetch()){
            reserva.add(new ClConsultarReserva(
                    OracleConection.getInstance().getString("rut"), 
                    OracleConection.getInstance().getInt("id_reserva"), 
                    OracleConection.getInstance().getDate("fecha_ingreso"), 
                    OracleConection.getInstance().getDate("fecha_salida"), 
                    OracleConection.getInstance().getInt("precio_total"), 
                    OracleConection.getInstance().getString("estado"), 
                    OracleConection.getInstance().getInt("total_servicios"), 
                    OracleConection.getInstance().getInt("total_habs")
                                ));
            
        } 
        return reserva;
    }
    
    public static int sqlLastID(){
        return OracleConection.getInstance().sqlLastID("reservas_seq");
    }
}

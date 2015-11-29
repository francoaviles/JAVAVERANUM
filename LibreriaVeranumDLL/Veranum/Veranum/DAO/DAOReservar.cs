using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Veranum.Clases;
using Veranum.Conexion;
using System.Data;

namespace Veranum.DAO
{
    public class DAOReservar
    {
        public static int sqlInsertar(string fecha1, string fecha2, int total, int idhotel, int cant, List<string> habitaciones, List<string> servicios, ClPasajero p) 
        {
            string sql_r = @"INSERT INTO ""reservas""
                                (""id_pasajero"",""id_reserva_estado"",""fecha_ingreso"",""fecha_salida"",""precio_total"") 
                            VALUES
                                (:idpasajero,:idreserva,TO_DATE(:fecha1, 'dd/MM/YYYY'),TO_DATE(:fecha2, 'dd/MM/YYYY'),:total)
                             ";

            DB.Instance.Conectar(Constantes.CONEXION_DUOC);
            DB.Instance.EjecutarQuery(sql_r);
            DB.Instance.setParameter("idpasajero", p.IdPasajero);
            DB.Instance.setParameter("idreserva", 3);
            DB.Instance.setParameter("fecha1", fecha1);
            DB.Instance.setParameter("fecha2", fecha2);
            DB.Instance.setParameter("total", total);
            DB.Instance.Procesar();
            int id_reserva = DB.Instance.LastID("reservas_seq");


            string sql_hr = @"INSERT INTO ""habitaciones_reservas""
                            (""id_habitacion"",""id_reserva"")
                            VALUES
                            (:idh, :idr)";

            string sql_sr = @"INSERT INTO ""servicios_reservas""
                            (""id_servicio"",""id_reserva"")
                            VALUES
                            (:ids, :idr)";

            string sqlu_h = @"UPDATE ""habitaciones"" SET
                            ""id_habitacion_estado"" = :estado
                            WHERE
                            ""id_habitacion"" = :idha";

            for (int h = 0; h < habitaciones.Count; h++) {
                DB.Instance.EjecutarQuery(sql_hr);
                DB.Instance.setParameter("idh", habitaciones[h]);
                DB.Instance.setParameter("idr", id_reserva);
                DB.Instance.Procesar();

                DB.Instance.EjecutarQuery(sqlu_h);
                DB.Instance.setParameter("estado", 3);
                DB.Instance.setParameter("idha", habitaciones[h]);
                DB.Instance.Procesar();
            }

            for (int s = 0; s < servicios.Count; s++)
            {
                DB.Instance.EjecutarQuery(sql_sr);
                DB.Instance.setParameter("ids", servicios[s]);
                DB.Instance.setParameter("idr", id_reserva);
                DB.Instance.Procesar();
            }


            DB.Instance.Cerrar();
            return id_reserva;
        }

        public static List<ClHabitaciones> sqlBuscarHabitacion(int hotel, int tipo, int cant)
        {
            List<ClHabitaciones> habitacion = new List<ClHabitaciones>();


            return habitacion;


            /*public static ArrayList sqlBuscarHabitacion(int hotel, int tipo, int cant) throws SQLException{
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

        }*/
        }
    }
}

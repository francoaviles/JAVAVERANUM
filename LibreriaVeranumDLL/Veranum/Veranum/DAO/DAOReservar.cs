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
            DB.Instance.setParameter("idreserva", 1);
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

        public static DataTable getReservaByUser(ClPasajero p) 
        {
            string sql_r = @"SELECT * 
                            FROM ""reservas""
                            LEFT JOIN ""estado_reservas"" ON   ""reservas"".""id_reserva_estado"" = ""estado_reservas"".""id_reserva_estado""
                            WHERE ""id_pasajero"" = :id
                            ORDER BY ""id_reserva"" DESC ";

            DB.Instance.Conectar(Constantes.CONEXION_DUOC);
            DB.Instance.EjecutarQuery(sql_r);
            DB.Instance.setParameter("id", p.IdPasajero);
            DataTable dt = DB.Instance.Leer(sql_r);
            return dt;
        }

        public static DataTable getDetalleHabs(int idreserva) 
        {
            string sql_r = @"SELECT * 
                            FROM ""habitaciones_reservas""
                            LEFT JOIN ""habitaciones"" ON  ""habitaciones_reservas"".""id_habitacion"" = ""habitaciones"".""id_habitacion""
                            WHERE ""id_reserva"" = :id";

            DB.Instance.EjecutarQuery(sql_r);
            DB.Instance.setParameter("id", idreserva);
            DataTable dt = DB.Instance.Leer(sql_r);
            

            return dt;
        }

        public static DataTable getDetalleServ(int idreserva) 
        {
            string sql_r = @"SELECT * 
                            FROM ""servicios_reservas""
                            LEFT JOIN ""servicios"" ON  ""servicios_reservas"".""id_servicio"" = ""servicios"".""id_servicio""
                            WHERE ""id_reserva"" = :id";

            DB.Instance.EjecutarQuery(sql_r);
            DB.Instance.setParameter("id", idreserva);
            DataTable dt = DB.Instance.Leer(sql_r);
            

            return dt;
        
        }

        public static List<DataTable> getDetalle(ClPasajero p) {
            List<DataTable> table = new List<DataTable>();
            DataTable dt = DAOReservar.getReservaByUser(p);
            DataTable habs = new DataTable();
            DataTable servs = new DataTable();

            table.Add(dt);
            for (int i = 0; i < dt.Rows.Count; i++) {
                habs.Merge(DAOReservar.getDetalleHabs(int.Parse(dt.Rows[i]["id_reserva"].ToString())));
                servs.Merge(DAOReservar.getDetalleServ(int.Parse(dt.Rows[i]["id_reserva"].ToString())));
            }
            table.Add(habs);
            table.Add(servs);

            return table;
        
        }

        public static void cerrar()
        {
            DB.Instance.Cerrar();
        }


    }
}

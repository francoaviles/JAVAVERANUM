using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

using Veranum.Clases;
using Veranum.Conexion;
using System.Data;

namespace Veranum.DAO
{
    public class DAOHabitaciones
    {
        public static DataTable sqlHoteles()
        {
            String sql = @"SELECT 
                            ""hoteles"".""nombre"",
                            ""habitacion_tipo"".""nombre"",
                            ""habitacion_estados"".""estado"", 
                            ""habitaciones"".* 
                        FROM ""habitaciones"" 
                        LEFT JOIN ""hoteles"" ON ""hoteles"".""id_hotel"" = ""habitaciones"".""id_hotel"" 
                        LEFT JOIN ""habitacion_tipo"" ON ""habitacion_tipo"".""id_habitacion_tipo"" = ""habitaciones"".""id_habitacion_tipo"" 
                        LEFT JOIN ""habitacion_estados"" ON ""habitacion_estados"".""id_habitacion_estado"" = ""habitaciones"".""id_habitacion_estado"" ";

            DB.Instance.Conectar(Constantes.CONEXION_DUOC);

            DB.Instance.EjecutarQuery(sql);
            DataTable dt = DB.Instance.Leer(sql);
            DB.Instance.Cerrar();

            /* 
            if (dt.Rows.Count > 0)
            {
                dato = new ClHabitaciones();
                dato.IdHabitacion = int.Parse(dt.Rows[0]["id_habitacion"].ToString());
                dato.IdHotel = int.Parse(dt.Rows[0]["id_hotel"].ToString());
                dato.IdHabitacionTipo = int.Parse(dt.Rows[0]["id_habitacion_tipo"].ToString());
                dato.IdHabitacionEstado = int.Parse(dt.Rows[0]["id_habitacion_estado"].ToString());
                dato.Ubicacion = dt.Rows[0]["ubicacion"].ToString();
                dato.CantPersonas = dt.Rows[0]["cant_personas"].ToString();
                dato.Precio = dt.Rows[0]["precio"].ToString();
            }
            */

            return dt;
        }


        public static DataTable HabDisponibles(String fecha1, String fecha2, int idHotel, int cantPersonas) {

            String sql = @"SELECT *
                        FROM ""habitaciones""
                        LEFT JOIN ""habitacion_tipos"" ON  ""habitaciones"".""id_habitacion_tipo"" = ""habitacion_tipos"".""id_habitacion_tipo""
                        LEFT JOIN ""hoteles"" ON  ""hoteles"".""id_hotel"" = ""habitaciones"".""id_hotel""
                        WHERE NOT ""habitaciones"".""id_habitacion"" IN 
                            (SELECT ""id_habitacion"" FROM ""habitaciones_reservas""
                              WHERE ""habitaciones_reservas"".""id_reserva"" IN 
                                  (SELECT ""id_reserva"" FROM ""reservas"" 
                                  WHERE  (""reservas"".""fecha_ingreso"" BETWEEN TO_DATE(:fecha1, 'DD/MM/YYYY') AND TO_DATE(:fecha2, 'DD/MM/YYYY')
                                  OR ""reservas"".""fecha_salida"" BETWEEN TO_DATE(:fecha1, 'DD/MM/YYYY') AND TO_DATE(:fecha2, 'DD/MM/YYYY'))
                                  AND ""reservas"".""id_reserva_estado"" <> 3
                                  )
                            )
                        AND  ""hoteles"".""id_hotel"" = :idhotel
                        AND ""habitaciones"".""cant_personas"" >= :cant
                        ORDER BY ""habitaciones"".""cant_personas"" ASC";

            DB.Instance.Conectar(Constantes.CONEXION_DUOC);

            DB.Instance.EjecutarQuery(sql);
            DB.Instance.setParameter("fecha1", fecha1);
            DB.Instance.setParameter("fecha2", fecha2);
            DB.Instance.setParameter("idhotel", idHotel);
            DB.Instance.setParameter("cant", cantPersonas);
            DB.Instance.Procesar(); 
            DataTable dt = DB.Instance.Leer(sql);
            DB.Instance.Cerrar();

            return dt;
        }

    }
}

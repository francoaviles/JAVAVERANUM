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

    }
}

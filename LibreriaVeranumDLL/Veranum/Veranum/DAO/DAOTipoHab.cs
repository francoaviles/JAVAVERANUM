using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

using System.Data;
using Veranum.Conexion;

namespace Veranum.DAO
{
    public class DAOTipoHab
    {
        public static DataTable sqlTodos()
        {
            String sql = @"SELECT 
                            DISTINCT ""habitaciones"".""id_habitacion_tipo"",
                            MIN(""habitaciones"".""precio"") as ""precio"",
                            ""habitacion_tipos"".""nombre""
                        FROM ""habitacion_tipos"" 
                        LEFT JOIN ""habitaciones"" ON ""habitaciones"".""id_habitacion_tipo"" = ""habitacion_tipos"".""id_habitacion_tipo""
                        GROUP BY ""habitaciones"".""id_habitacion_tipo"", ""habitacion_tipos"".""nombre""
                        ";

            DB.Instance.Conectar(Constantes.CONEXION_DUOC);

            DB.Instance.EjecutarQuery(sql);
            DataTable dt = DB.Instance.Leer(sql);
            DB.Instance.Cerrar();
            return dt;
        }
    }
}

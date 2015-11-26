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
            String sql = @"SELECT * FROM ""habitacion_tipos"" ";

            DB.Instance.Conectar(Constantes.CONEXION_DUOC);

            DB.Instance.EjecutarQuery(sql);
            DataTable dt = DB.Instance.Leer(sql);
            DB.Instance.Cerrar();
            return dt;
        }
    }
}

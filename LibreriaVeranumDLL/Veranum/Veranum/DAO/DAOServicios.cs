using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

using Veranum.Clases;
using Veranum.Conexion;
using System.Data;

namespace Veranum.DAO
{
    public class DAOServicios
    {
        public static DataTable sqlServicios()
        {
            String sql = @"SELECT * FROM servicios";

            DB.Instance.Conectar(Constantes.CONEXION_DUOC);

            DB.Instance.EjecutarQuery(sql);
            DataTable dt = DB.Instance.Leer(sql);
            DB.Instance.Cerrar();

            /* 
            if (dt.Rows.Count > 0)
            {
                dato = new ClServicios();
                dato.IdServicio = int.Parse(dt.Rows[0]["id_servicio"].ToString());
                dato.Nombre = dt.Rows[0]["nombre"].ToString();
                dato.Precio = int.Parse(dt.Rows[0]["precio"].ToString());
            }
            */

            return dt;
        }

    }
}

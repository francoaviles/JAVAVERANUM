using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data;
using Veranum.Clases;
using Veranum.Conexion;

namespace Veranum.DAO
{
    public class DAOPasajero
    {
        public static ClPasajero LoginIn(ClPasajero p) 
        {
            ClPasajero pasajero = null;
            String sql = String.Format("SELECT * FROM \"pasajeros\" WHERE \"rut\" = '{0}' AND \"contrasena\" = '{1}'", 
                                        p.Rut,
                                        p.Contrasena);

            DB.Instance.Conectar(Constantes.CONEXION_DUOC);
            DataTable dt = DB.Instance.Leer(sql);

            if(dt.Rows.Count > 0){
                pasajero = new ClPasajero(p.Rut, p.Contrasena);
                pasajero.IdRol = int.Parse(dt.Rows[0]["id_rol"].ToString());
                pasajero.Nombre = dt.Rows[0]["nombre"].ToString();
                pasajero.ApellidoPa = dt.Rows[0]["apellido_pa"].ToString();
                pasajero.ApellidoMa = dt.Rows[0]["apellido_ma"].ToString();

                return pasajero;
            }
            return pasajero;
        }
    }
}

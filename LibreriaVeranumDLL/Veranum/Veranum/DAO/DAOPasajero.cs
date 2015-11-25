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

        public static Boolean InsertPasajero(ClPasajero p) {
            String sql=  String.Format("INSERT INTO \"pasajeros\" (\"rut\", \"nombre\", \"contrasena\", \"apellido_pa\", \"apellido_ma\", \"telefono\", \"email\", \"direccion\", \"fecha_nac\", \"id_rol\" ) VALUES ('{0}','{1}','{2}','{3}','{4}','{5}','{6}','{7}',TO_DATE('{8}', 'dd/MM/YYYY'),'{9}')",
                                        p.Rut
                                        ,p.Nombre
                                        ,p.Contrasena
                                        ,p.ApellidoMa
                                        ,p.ApellidoPa
                                        ,p.Telefono
                                        ,p.Email
                                        ,p.Direccion
                                        ,p.Fecha_nac
                                        ,p.IdRol);
            DB.Instance.Ejecutar(sql);
            return true;
        }

        public static Boolean UpdatePasajero(ClPasajero p)
        {
            String sql = String.Format("UPDATE \"pasajeros\" SET \"rut\" = '{0}', \"nombre\" = '{1}', \"contrasena\" = '{2}', \"apellido_pa\" = '{3}', \"apellido_ma\" = '{4}', \"telefono\" = '{5}', \"email\" = '{6}', \"direccion\" = '{7}', \"fecha_nac\" = TO_DATE('{8}', 'dd/MM/YYYY') WHERE \"id_pasajero\" = '{9}'",
                                        p.Rut
                                        , p.Nombre
                                        , p.Contrasena
                                        , p.ApellidoMa
                                        , p.ApellidoPa
                                        , p.Telefono
                                        , p.Email
                                        , p.Direccion
                                        , p.Fecha_nac
                                        , p.IdPasajero);
            DB.Instance.Ejecutar(sql);
            return true;
        }

        public static Boolean DeletePasajero(ClPasajero p)
        {
            String sql = String.Format("DELETE FROM \"pasajeros\" WHERE \"id_pasajero\" = '{0}' ",
                                        p.IdPasajero
                                        );
            DB.Instance.Ejecutar(sql);
            return true;
        }



    }
}

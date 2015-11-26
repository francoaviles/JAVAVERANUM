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
            String sql = "SELECT * FROM \"pasajeros\" WHERE \"rut\" = :rut AND \"contrasena\" = :contrasena";

            DB.Instance.Conectar(Constantes.CONEXION_DUOC);

            DB.Instance.EjecutarQuery(sql);
            DB.Instance.setParameter("rut", p.Rut);
            DB.Instance.setParameter("contrasena", p.Contrasena);
            DataTable dt = DB.Instance.Leer(sql);
            DB.Instance.Cerrar();

            if (dt.Rows.Count > 0)
            {
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
            String sql=  @"INSERT INTO ""pasajeros"" 
                            (""rut"", ""nombre"", ""contrasena"", ""apellido_pa"", ""apellido_ma"", ""telefono"", ""email"", ""direccion"", ""fecha_nac"", ""id_rol"") 
                            VALUES (:rut,:nombre,:contrasena,:apellido_pa,:apellido_ma,:telefono,:email,:direccion,TO_DATE(:fecha_nac, 'dd-MM-YYYY HH24:MI:SS'),:idrol)";

            DB.Instance.Conectar(Constantes.CONEXION_DUOC);
            DB.Instance.EjecutarQuery(sql);
            DB.Instance.setParameter("rut", p.Rut);
            DB.Instance.setParameter("nombre", p.Nombre);
            DB.Instance.setParameter("contrasena", p.Contrasena);
            DB.Instance.setParameter("apellido_pa", p.ApellidoPa);
            DB.Instance.setParameter("apellido_ma", p.ApellidoMa);
            DB.Instance.setParameter("telefono", p.Telefono);
            DB.Instance.setParameter("email", p.Email);
            DB.Instance.setParameter("direccion", p.Direccion);
            DB.Instance.setParameter("fecha_nac", p.Fecha_nac);
            DB.Instance.setParameter("idrol", p.IdRol);
            DB.Instance.Procesar();
            DB.Instance.Cerrar();
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

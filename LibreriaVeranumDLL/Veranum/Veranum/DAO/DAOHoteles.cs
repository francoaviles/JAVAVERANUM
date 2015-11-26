using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

using Veranum.Clases;
using Veranum.Conexion;
using System.Data;

namespace Veranum.DAO
{
    class DAOHoteles
    {
        public static ClHoteles LoginIn(ClHoteles p)
        {
            ClHoteles dato = null;
            String sql = "SELECT \"regiones\".\"region_nombre\",\"provincias\".\"provincia_nombre\",\"comunas\".\"comuna_nombre\",\"hoteles\".* FROM \"hoteles\" LEFT JOIN \"regiones\" ON \"regiones\".\"id_region\" = \"hoteles\".\"id_region\" LEFT JOIN \"provincias\" ON \"provincias\".\"id_provincia\" = \"hoteles\".\"id_provincia\" LEFT JOIN \"comunas\" ON \"comunas\".\"id_comuna\" = \"hoteles\".\"id_comuna\" ";

            DB.Instance.Conectar(Constantes.CONEXION_DUOC);

            DB.Instance.EjecutarQuery(sql);
            DataTable dt = DB.Instance.Leer(sql);
            DB.Instance.Cerrar();

            if (dt.Rows.Count > 0)
            {
                dato = new ClHoteles();
                dato.IdHotel = int.Parse(dt.Rows[0]["id_hotel"].ToString());
                dato.IdCadena = int.Parse(dt.Rows[0]["id_cadena"].ToString());
                dato.IdRegion = int.Parse(dt.Rows[0]["id_region"].ToString());
                dato.IdProvincia = int.Parse(dt.Rows[0]["id_provincia"].ToString());
                dato.IdComuna = int.Parse(dt.Rows[0]["id_comuna"].ToString());
                dato.Nombre = dt.Rows[0]["nombre"].ToString();
                dato.Direccion = dt.Rows[0]["direccion"].ToString();
                dato.Region = dt.Rows[0]["region_nombre"].ToString(); ;
                dato.Provincia = dt.Rows[0]["provincia_nombre"].ToString();
                dato.Comuna = dt.Rows[0]["comuna_nombre"].ToString(); 
            }
            return dato;
        }
    }
}

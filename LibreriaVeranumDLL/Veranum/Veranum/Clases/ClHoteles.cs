using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Veranum.Clases
{
    public class ClHoteles
    {
        private int idHotel;
        private int idCadena;
        private int idRegion;
        private int idProvincia;
        private int idComuna;
        private string nombre;
        private string direccion;

        private string region;
        private string provincia;
        private string comuna;

        public string Comuna
        {
            get { return comuna; }
            set { comuna = value; }
        }

        public string Provincia
        {
            get { return provincia; }
            set { provincia = value; }
        }

        public string Region
        {
            get { return region; }
            set { region = value; }
        }

        public ClHoteles() { }

        public ClHoteles(int idh, int idc, int idr, int idp, int idco, string nombre, string direccion) 
        {
            IdCadena = idc;
            IdComuna = idco;
            IdHotel = idh;
            IdProvincia = idp;
            IdRegion = idr;
            Nombre = nombre;
            Direccion = direccion;
        }

        public ClHoteles(int idh, int idc, int idr, int idp, int idco, string nombre, string direccion, string r, string p, string c)
        {
            IdCadena = idc;
            IdComuna = idco;
            IdHotel = idh;
            IdProvincia = idp;
            IdRegion = idr;
            Nombre = nombre;
            Direccion = direccion;

            Region = r;
            Provincia = p;
            Comuna = c;
        }


        public string Direccion
        {
            get { return direccion; }
            set { direccion = value; }
        }

        public string Nombre
        {
            get { return nombre; }
            set { nombre = value; }
        }

        public int IdComuna
        {
            get { return idComuna; }
            set { idComuna = value; }
        }

        public int IdProvincia
        {
            get { return idProvincia; }
            set { idProvincia = value; }
        }

        public int IdRegion
        {
            get { return idRegion; }
            set { idRegion = value; }
        }

        public int IdCadena
        {
            get { return idCadena; }
            set { idCadena = value; }
        }

        public int IdHotel
        {
            get { return idHotel; }
            set { idHotel = value; }
        }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Veranum.Clases
{
    public class ClServicios
    {
        private int idServicio;
        private string nombre;
        private int precio;

        public ClServicios() { 
        }

        public ClServicios(int idServicio)
        {
            this.IdServicio = idServicio;
        }

        public ClServicios(string nombre)
        {
            this.Nombre = nombre;
        }

        public ClServicios(int idServicio, string nombre, int precio)
        {
            this.IdServicio = idServicio;
            this.Nombre = nombre;
            this.Precio = precio;
        }

        public int Precio
        {
            get { return precio; }
            set { precio = value; }
        }

        public string Nombre
        {
            get { return nombre; }
            set { nombre = value; }
        }        

        public int IdServicio
        {
            get { return idServicio; }
            set { idServicio = value; }
        }
        



    }
}

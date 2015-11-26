using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Veranum.Clases
{
    public class ClRol
    {
        private int idRol;
        private string nombre;
        private string descripcion;

        public ClRol()
        {
        }

        public ClRol(int idRol)
        {
            this.IdRol = idRol;
        }

        public ClRol(string nombre)
        {
            this.Nombre = nombre;
        }

        public ClRol(int idRol, string nombre, string descripcion)
        {
            this.IdRol = idRol;
            this.Nombre = nombre;
            this.Descripcion = descripcion;
        }

        public string Descripcion
        {
            get { return descripcion; }
            set { descripcion = value; }
        }


        public string Nombre
        {
            get { return nombre; }
            set { nombre = value; }
        }

        public int IdRol
        {
          get { return idRol; }
          set { idRol = value; }
        }

    }
}

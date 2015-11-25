using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Veranum.Clases
{
    class ClRegion
    {
        private int idRegion;
        private String nombre;
        private String ordinal;

        public ClRegion()
        {
        }

        public ClRegion(int idRegion)
        {
            this.IdRegion = idRegion;
        }

        public ClRegion(string nombre)
        {
            this.Nombre = nombre;
        }

        public ClRegion(int idRegion, string nombre, string ordinal)
        {
            this.IdRegion = idRegion;
            this.Nombre = nombre;
            this.Ordinal = ordinal;
        }

        public String Ordinal
        {
            get { return ordinal; }
            set { ordinal = value; }
        }

        public String Nombre
        {
            get { return nombre; }
            set { nombre = value; }
        }
        

        public int IdRegion
        {
            get { return idRegion; }
            set { idRegion = value; }
        }

    }
}

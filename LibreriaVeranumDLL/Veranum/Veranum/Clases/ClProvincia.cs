using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Veranum.Clases
{
    class ClProvincia
    {
        private int idProvincia;
        private String nombre;
        private int idRegion;

        public ClProvincia()
        {
        }

        public ClProvincia(int idProvincia)
        {
            this.IdProvincia = idProvincia;
        }

        public ClProvincia(string nombre)
        {
            this.Nombre = nombre;
        }

        public ClProvincia(int idProvincia, string nombre, int idRegion)
        {
            this.IdProvincia = idProvincia;
            this.Nombre = nombre;
            this.IdRegion = idRegion;
        }

        public int IdRegion
        {
            get { return idRegion; }
            set { idRegion = value; }
        }

        public String Nombre
        {
            get { return nombre; }
            set { nombre = value; }
        }
        

        public int IdProvincia
        {
            get { return idProvincia; }
            set { idProvincia = value; }
        }
        
    }
}

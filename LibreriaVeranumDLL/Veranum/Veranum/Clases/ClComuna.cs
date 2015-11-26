using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Veranum.Clases
{
    public class ClComuna
    {
        private int idComuna;
        private String nombre;
        private int idProvincia;

        public ClComuna()
        {
        }

        public ClComuna(int idComuna)
        {
            this.IdComuna = idComuna;
        }

        public ClComuna(string nombre)
        {
            this.Nombre = nombre;
        }

        public ClComuna(int idComuna, string nombre, int idProvincia)
        {
            this.IdComuna = idComuna;
            this.Nombre = nombre;
            this.IdProvincia = idProvincia;
        }

        public int IdProvincia
        {
            get { return idProvincia; }
            set { idProvincia = value; }
        }

        public String Nombre
        {
            get { return nombre; }
            set { nombre = value; }
        }
        

        public int IdComuna
        {
            get { return idComuna; }
            set { idComuna = value; }
        }
        

    }
}

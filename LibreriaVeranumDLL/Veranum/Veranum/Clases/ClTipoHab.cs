using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Veranum.Clases
{
    public class ClTipoHab
    {
        private int idTipoHabit;
        private String nombre;

        public ClTipoHab()
        {
        }

        public ClTipoHab(int idTipoHab)
        {
            this.IdTipoHabit = idTipoHab;
        }

        public ClTipoHab(string nombre)
        {
            this.Nombre = nombre;
        }

        public ClTipoHab(int idTipoHab, string nombre)
        {
            this.IdTipoHabit = idTipoHab;
            this.Nombre = nombre;
        }

        public String Nombre
        {
            get { return nombre; }
            set { nombre = value; }
        }

        public int IdTipoHabit
        {
            get { return idTipoHabit; }
            set { idTipoHabit = value; }
        }
     
    }
}

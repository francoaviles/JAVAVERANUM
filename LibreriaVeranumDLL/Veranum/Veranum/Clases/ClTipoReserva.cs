using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Veranum.Clases
{
    class ClTipoReserva
    {
        private int idTipoReserva;
        private string nombre;

        public ClTipoReserva()
        {
        }

        public ClTipoReserva(int idTipoReserva)
        {
            this.IdTipoReserva = idTipoReserva;
        }

        public ClTipoReserva(string nombre)
        {
            this.Nombre = nombre;
        }

        public ClTipoReserva(int idTipoReserva, string nombre)
        {
            this.IdTipoReserva = idTipoReserva;
            this.Nombre = nombre;
        }

        public string Nombre
        {
            get { return nombre; }
            set { nombre = value; }
        }

        public int IdTipoReserva
        {
            get { return idTipoReserva; }
            set { idTipoReserva = value; }
        }
    }
}

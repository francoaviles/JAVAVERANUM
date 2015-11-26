using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Veranum.Clases
{
    public class ClEstadoReserva
    {
        private int idReservaEstado;
        private string nombre;

        public ClEstadoReserva()
        {
        }

        public ClEstadoReserva(int idReservaEstado)
        {
            this.IdReservaEstado = idReservaEstado;
        }

        public ClEstadoReserva(string nombre)
        {
            this.Nombre = nombre;
        }

        public ClEstadoReserva(int idReservaEstado, string nombre)
        {
            this.IdReservaEstado = idReservaEstado;
            this.Nombre = nombre;
        }

        public string Nombre
        {
            get { return nombre; }
            set { nombre = value; }
        }

        public int IdReservaEstado
        {
            get { return idReservaEstado; }
            set { idReservaEstado = value; }
        }
        

    }
}

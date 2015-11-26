using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Veranum.Clases
{
    public class ClReservas
    {
        private int idReserva;
        private int idPasajero;
        private int idReservaEstado;
        private DateTime fechaIngreso;
        private DateTime fechaSalida;
        private int precioTotal;

        public ClReservas()
        {
        }

        public ClReservas(int idReserva)
        {
            this.IdReserva = idReserva;
        }

        public ClReservas(int idReserva, int idPasajero, int idReservaEstado, DateTime fechaIngreso, DateTime fechaSalida, int precioFinal)
        {
            this.IdReserva = idReserva;
            this.IdPasajero = idPasajero;
            this.IdReservaEstado = idReservaEstado;
            this.FechaIngreso = fechaIngreso;
            this.FechaSalida = fechaSalida;
            this.PrecioTotal = precioTotal;
        }

        public int PrecioTotal
        {
            get { return precioTotal; }
            set { precioTotal = value; }
        }

        public DateTime FechaSalida
        {
            get { return fechaSalida; }
            set { fechaSalida = value; }
        }
        

        public DateTime FechaIngreso
        {
            get { return fechaIngreso; }
            set { fechaIngreso = value; }
        }
        

        public int IdReservaEstado
        {
            get { return idReservaEstado; }
            set { idReservaEstado = value; }
        }
        

        public int IdPasajero
        {
            get { return idPasajero; }
            set { idPasajero = value; }
        }
        

        public int IdReserva
        {
            get { return idReserva; }
            set { idReserva = value; }
        }
        



    }
}

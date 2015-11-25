using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Veranum.Clases
{
    class ClReservar
    {
        private ClPasajero usuario;
        private List<ClHabitaciones> reservas = new List<ClHabitaciones>();
        private List<ClServicios> servicios = new List<ClServicios>();
        private DateTime fechaIngreso;
        private DateTime fechaSalida;
        private long dias;
        private long totalxnoche;
        private long total;

        public ClReservar()
        {
        }

        public ClReservar(ClPasajero usuario, List<ClHabitaciones> reservas, List<ClServicios> servicios, DateTime fechaIngreso, DateTime fechaSalida ,long dias, long totalxnoche, long total)
        {
            this.Usuario = usuario;
            this.Reservas = reservas;
            this.Servicios = servicios;
            this.FechaIngreso = fechaIngreso;
            this.FechaSalida = fechaSalida;
            this.Dias = dias;
            this.Totalxnoche = totalxnoche;
            this.Total = total;
        }

        public ClReservar(ClPasajero usuario, List<ClHabitaciones> reservas,DateTime fechaIngreso, DateTime fechaSalida, long dias, long totalxnoche, long total)
        {
            this.Usuario = usuario;
            this.Reservas = reservas;
            this.FechaIngreso = fechaIngreso;
            this.FechaSalida = fechaSalida;
            this.Dias = dias;
            this.Totalxnoche = totalxnoche;
            this.Total = total;
        }

        public long Total
        {
            get { return total; }
            set { total = value; }
        }


        public long Totalxnoche
        {
            get { return totalxnoche; }
            set { totalxnoche = value; }
        }
        

        public long Dias
        {
            get { return dias; }
            set { dias = value; }
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
        

        internal List<ClServicios> Servicios
        {
            get { return servicios; }
            set { servicios = value; }
        }
        

        internal List<ClHabitaciones> Reservas
        {
            get { return reservas; }
            set { reservas = value; }
        }
        

        public ClPasajero Usuario
        {
            get { return usuario; }
            set { usuario = value; }
        }
        



    }
}

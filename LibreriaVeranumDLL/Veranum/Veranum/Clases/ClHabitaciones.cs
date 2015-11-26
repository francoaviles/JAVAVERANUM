using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Veranum.Clases
{
    public class ClHabitaciones
    {
        private int idHabitacion;
        private int idHotel;
        private int idHabitacionTipo;
        private int idHabitacionEstado;
        private String ubicacion;
        private int cantPersonas;
        private int precio;

        public ClHabitaciones()
        {
        }

        public ClHabitaciones(int idHabitacion)
        {
            this.IdHabitacion = idHabitacion;
        }

        public ClHabitaciones(int idHabitacion, int idHotel, int idHabitacionTipo, int idHabitacionEstado, string ubicacion, int cantPersonas,int precio)
        {
            this.IdHabitacion = idHabitacion;
            this.IdHotel = idHotel;
            this.IdHabitacionTipo = idHabitacionTipo;
            this.IdHabitacionEstado = idHabitacionEstado;
            this.Ubicacion = ubicacion;
            this.CantPersonas = cantPersonas;
            this.Precio = precio;
        }

        public int Precio
        {
            get { return precio; }
            set { precio = value; }
        }

        public int CantPersonas
        {
            get { return cantPersonas; }
            set { cantPersonas = value; }
        }
        

        public String Ubicacion
        {
            get { return ubicacion; }
            set { ubicacion = value; }
        }
        

        public int IdHabitacionEstado
        {
            get { return idHabitacionEstado; }
            set { idHabitacionEstado = value; }
        }
        

        public int IdHabitacionTipo
        {
            get { return idHabitacionTipo; }
            set { idHabitacionTipo = value; }
        }
        

        public int IdHotel
        {
            get { return idHotel; }
            set { idHotel = value; }
        }
        

        public int IdHabitacion
        {
            get { return idHabitacion; }
            set { idHabitacion = value; }
        }
        
    }
}

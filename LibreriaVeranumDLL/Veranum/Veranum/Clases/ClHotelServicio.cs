using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Veranum.Clases
{
    public class ClHotelServicio
    {
        private int idHotel;
        private int idServicio;

        public ClHotelServicio()
        {
        }

        public ClHotelServicio(int idHotel, int idServicio)
        {
            this.IdHotel = idHotel;
            this.IdServicio = idServicio;
        }

        public int IdServicio
        {
            get { return idServicio; }
            set { idServicio = value; }
        }

        public int IdHotel
        {
            get { return idHotel; }
            set { idHotel = value; }
        }
        

    }
}

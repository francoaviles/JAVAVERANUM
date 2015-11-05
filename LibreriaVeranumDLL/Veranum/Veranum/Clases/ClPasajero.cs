using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Veranum.Clases
{
    public class ClPasajero
    {
        private int idPasajero;
        private String rut;
        private String nombre;
        private String contrasena;
        private String apellidoPa;
        private String apellidoMa;
        private String telefono;
        private String email;
        private int idRegion;
        private int idProvincia;
        private int idComuna;
        private String direccion;
        private DateTime fecha_nac;
        private int idRol;

        public ClPasajero() { }

        public ClPasajero(string rut, string contrasena)
        {
            this.Rut = rut;
            this.Contrasena = contrasena;
        }

        public ClPasajero(string rut, string nombre, string contrasena, string appa, string apma, string telefono, string email, int idregion, int idprovincia, int idcomuna, string direccion, DateTime fechanac, int idrol)
        {
            this.Rut = rut;
            this.Nombre = nombre;
            this.Contrasena = contrasena;
            this.ApellidoMa = apma;
            this.ApellidoPa = appa;
            this.Telefono = telefono;
            this.Email = email;
            this.IdRegion = idregion;
            this.IdProvincia = idprovincia;
            this.IdComuna = idcomuna;
            this.Direccion = direccion;
            this.Fecha_nac = fechanac;
            this.idRol = idrol;
        }

        public ClPasajero(int idpasajero, string rut, string nombre, string contrasena, string appa, string apma, string telefono, string email, int idregion, int idprovincia, int idcomuna, string direccion, DateTime fechanac, int idrol) 
        {
            this.IdPasajero = idpasajero;
            this.Rut = rut;
            this.Nombre = nombre;
            this.Contrasena = contrasena;
            this.ApellidoMa = apma;
            this.ApellidoPa = appa;
            this.Telefono = telefono;
            this.Email = email;
            this.IdRegion = idregion;
            this.IdProvincia = idprovincia;
            this.IdComuna = idcomuna;
            this.Direccion = direccion;
            this.Fecha_nac = fechanac;
            this.idRol = idrol;
        }


        public int IdRol
        {
            get { return idRol; }
            set { idRol = value; }
        }

        public DateTime Fecha_nac
        {
            get { return fecha_nac; }
            set { fecha_nac = value; }
        }

        public String Direccion
        {
            get { return direccion; }
            set { direccion = value; }
        }

        public int IdComuna
        {
            get { return idComuna; }
            set { idComuna = value; }
        }

        public int IdProvincia
        {
            get { return idProvincia; }
            set { idProvincia = value; }
        }

        public int IdRegion
        {
            get { return idRegion; }
            set { idRegion = value; }
        }


        public String Email
        {
            get { return email; }
            set { email = value; }
        }

        public String Telefono
        {
            get { return telefono; }
            set { telefono = value; }
        }

        public String ApellidoMa
        {
            get { return apellidoMa; }
            set { apellidoMa = value; }
        }

        public String ApellidoPa
        {
            get { return apellidoPa; }
            set { apellidoPa = value; }
        }

        public String Contrasena
        {
            get { return contrasena; }
            set { contrasena = value; }
        }

        public String Nombre
        {
            get { return nombre; }
            set { nombre = value; }
        }

        public String Rut
        {
            get { return rut; }
            set { rut = value; }
        }

        public int IdPasajero
        {
            get { return idPasajero; }
            set { idPasajero = value; }
        }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

using Veranum.Clases;
using Veranum.DAO;
using System.Data;
using System.Text;

/// <summary>servicios
/// Descripción breve de guardarReserva
/// </summary>
[WebService(Namespace = "http://tempuri.org/")]
[WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
// Para permitir que se llame a este servicio Web desde un script, usando ASP.NET AJAX, quite la marca de comentario de la línea siguiente. 
 [System.Web.Script.Services.ScriptService]
public class guardarReserva : System.Web.Services.WebService {

    public guardarReserva () {

        //Eliminar la marca de comentario de la línea siguiente si utiliza los componentes diseñados 
        //InitializeComponent(); 
    }

    [WebMethod(EnableSession = true)]
    public int guardar(string fecha1, string fecha2, int total, int idhotel, int cant, List<string> habitaciones, List<string> servicios)
    {
        if (Session["login"] == null) { return 0; }

         return DAOReservar.sqlInsertar(fecha1, fecha2, total, idhotel, cant, habitaciones, servicios, (ClPasajero)Session["login"]);
    }
    
}

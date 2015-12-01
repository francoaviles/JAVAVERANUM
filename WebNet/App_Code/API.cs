using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;
using System.Data;
using Veranum.DAO;

/// <summary>
/// Descripción breve de APIGetHabs
/// </summary>
[WebService(Namespace = "VeranumAPI")]
[WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
// Para permitir que se llame a este servicio Web desde un script, usando ASP.NET AJAX, quite la marca de comentario de la línea siguiente. 
// [System.Web.Script.Services.ScriptService]
public class API : System.Web.Services.WebService {

    public API () {

        //Eliminar la marca de comentario de la línea siguiente si utiliza los componentes diseñados 
        //InitializeComponent(); 
    }

    [WebMethod]
    public DataTable getHabs(string ingreso, string salida, int idhotel, int cant)
    {
        DataTable dt = new DataTable("habitaciones");
        dt.Merge(DAOHabitaciones.HabDisponibles(ingreso, salida, idhotel, cant));
        return dt;
    }
    
}

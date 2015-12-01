using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

using Veranum.DAO;
using Veranum.Clases;

public partial class cancelar_reserva : System.Web.UI.Page
{
    private int id = 0;
    protected void Page_Load(object sender, EventArgs e)
    {
        id = Convert.ToInt32(Request.QueryString["id"]);
        if (Session["login"] != null)
            DAOReservar.cancelarByUser(id, (ClPasajero)Session["login"]);

        Response.Redirect("misreservas.aspx");
    }
}
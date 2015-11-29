using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

using System.Data;
using Veranum.DAO;
using Veranum.Clases;

public partial class misreservas : System.Web.UI.Page
{
    public DataTable reservas;
    public DataTable h;
    public DataTable s;

    protected void Page_Load(object sender, EventArgs e)
    {
        if (Session["login"] == null)
        {
            Session["flash"] = "Necesitas estar logeado estar aquí.";
            Response.Redirect("Login.aspx");
        }

        this.reservas = DAOReservar.getReservaByUser((ClPasajero)Session["login"]);
    }

    public DataTable getHabs(int id) 
    {
        this.h = DAOReservar.getDetalleHabs(id);
        return this.h;
    }

    public DataTable getServs(int id)
    {
        this.s = DAOReservar.getDetalleServ(id);
        return this.s;
    }
}
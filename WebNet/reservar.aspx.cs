using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

using System.Data;
using Veranum.DAO;
using Veranum.Clases;

public partial class reservar : System.Web.UI.Page
{
    public DataTable hoteles;
    public string nohab = "none";
    public string pasodos = "none";
    public string pasotres = "none";

    protected void Page_Load(object sender, EventArgs e)
    {
        if (VeranumMaster.pagina != "reserva")
            VeranumMaster.pagina = "reserva";

        if (Session["login"] == null)
        {
            Session["flash"] = "Necesitas estar logeado para realizar una reserva.";
            Response.Redirect("Login.aspx");
        }

        cbHoteles.DataSource = DAOHoteles.sqlHoteles();
        cbHoteles.DataTextField = "nombre";
        cbHoteles.DataValueField = "id_hotel";
        cbHoteles.DataBind();
    }
    protected void btnSeguir_Click(object sender, EventArgs e)
    {
        this.pasodos = "block";
    }
}
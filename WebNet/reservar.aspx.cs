using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

using System.Data;
using Veranum.DAO;
using Veranum.Clases;
using System.Net;

public partial class reservar : System.Web.UI.Page
{
    public DataTable hoteles;
    public string id_hotel = "";
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

        id_hotel = Request.QueryString["hotel"];

        cbHoteles.DataSource = DAOHoteles.sqlHoteles();
        cbHoteles.DataTextField = "nombre";
        cbHoteles.DataValueField = "id_hotel";
        try
        {
            cbHoteles.SelectedValue = id_hotel;
            cbHoteles.DataBind();
        }
        catch (Exception excepcion) {
            cbHoteles.SelectedValue = "1";
            cbHoteles.DataBind();
        }
    }
    protected void btnSeguir_Click(object sender, EventArgs e)
    {
        this.pasodos = "block";
    }
}
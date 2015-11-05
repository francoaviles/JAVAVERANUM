using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using Veranum.Clases;
using Veranum.DAO;

public partial class Login : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }
    protected void btnIngresar_Click(object sender, EventArgs e)
    {
        ClPasajero p = new ClPasajero(txtRut.Text, txtContraseña.Text);
        ClPasajero pp = DAOPasajero.LoginIn(p);
        if (pp == null)
        {
            lblError.Text = "Combinación rut/contraseña incorrecto. ";
        }
        else
        {
            Session["login"] = pp;
            Response.Redirect("index.aspx");
        }
    }
}
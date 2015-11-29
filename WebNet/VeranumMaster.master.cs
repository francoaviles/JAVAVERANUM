using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class VeranumMaster : System.Web.UI.MasterPage
{
    public static string pagina = "";
    public string aux_flash = "";
    protected void Page_Load(object sender, EventArgs e)
    {
        if (!VeranumMaster.pagina.Contains("inicio") &&
            !VeranumMaster.pagina.Contains("hotel") &&
            !VeranumMaster.pagina.Contains("servicio") &&
            !VeranumMaster.pagina.Contains("habitacion") &&
            !VeranumMaster.pagina.Contains("reserva") &&
            !VeranumMaster.pagina.Contains("contacto"))
        {
            VeranumMaster.pagina = "";
        }

        if (Session["flash"] != null)
        {
            lblSessionFlash.Text = Session["flash"].ToString();
            Session["flash"] = null;
        }
       
    }

}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

using Veranum.DAO;
using System.Data;

public partial class Hoteles_Todos : System.Web.UI.Page
{
    public DataTable hoteles;

    protected void Page_Load(object sender, EventArgs e)
    {
        if (VeranumMaster.pagina != "hotel")
                VeranumMaster.pagina = "hotel";

        this.hoteles = DAOHoteles.sqlHoteles();
    }
}
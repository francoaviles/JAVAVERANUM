using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

using System.Data;
using Veranum.DAO;

public partial class servicios : System.Web.UI.Page
{
    public DataTable dt_servicios; 

    protected void Page_Load(object sender, EventArgs e)
    {
        if (VeranumMaster.pagina != "servicio")
            VeranumMaster.pagina = "servicio";

        this.dt_servicios = DAOServicios.sqlServicios();
    }
}
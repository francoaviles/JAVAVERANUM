using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

using System.Data;
using Veranum.DAO;

public partial class habitaciones : System.Web.UI.Page
{
    public DataTable dt_tb;

    protected void Page_Load(object sender, EventArgs e)
    {
        if (VeranumMaster.pagina != "habitacion")
            VeranumMaster.pagina = "habitacion";

        this.dt_tb = DAOTipoHab.sqlTodos();
    }
}
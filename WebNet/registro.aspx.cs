using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

using Veranum.Clases;
using Veranum.DAO;

public partial class registro : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }
    protected void btnRegistro_Click(object sender, EventArgs e)
    {
        ClPasajero p = new ClPasajero(
                                    txtRut.Text.ToUpper(),
                                    txtNombre.Text,
                                    txtContraseña.Text,
                                    txtApePa.Text,
                                    txtApeMa.Text,
                                    txtTelefono.Text,
                                    txtEmail.Text,
                                    0,0,0,
                                    txtDireccion.Text,
                                    DateTime.ParseExact(txtFechaNac.Text, "dd/MM/yyyy", System.Globalization.CultureInfo.InvariantCulture),
                                    3
                                );
        DAOPasajero.InsertPasajero(p);
    }
}
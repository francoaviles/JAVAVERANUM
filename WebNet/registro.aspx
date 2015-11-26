<%@ Page Title="" Language="C#" MasterPageFile="~/VeranumMaster.master" AutoEventWireup="true" CodeFile="registro.aspx.cs" Inherits="registro" %>

<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <div class="grid_6">
        <h2 class="heading text-2 color-4 wow fadeInUp animated" style="visibility: visible; animation-name: fadeInUp;">Registro de Usuarios</h2>
            <asp:Label ID="lblError" runat="server" Text=""></asp:Label>
        <form id="formRegistro" method="post" class="registroForm"  runat="server">
                  <div class="form-group">
                    <label for="lblRut">Rut:</label>
                      <asp:TextBox ID="txtRut" CssClass="form-control" runat="server"></asp:TextBox>
                  </div>
                  <div class="form-group">
                    <label for="lblContrasena">Contraseña:</label>
                      <asp:TextBox ID="txtContraseña" CssClass="form-control" TextMode="Password" runat="server"></asp:TextBox>
                  </div>
                <hr />
                <div class="form-group">
                    <label for="lblNombres">Nombres:</label>
                    <asp:TextBox ID="txtNombre" CssClass="form-control" runat="server"></asp:TextBox>
                </div>
                <div class="form-group">
                    <label for="lblApePa">Apellido paterno:</label>
                    <asp:TextBox ID="txtApePa" CssClass="form-control" runat="server"></asp:TextBox>
                </div>
                <div class="form-group">
                    <label for="lblApeMa">Apellido materno:</label>
                    <asp:TextBox ID="txtApeMa" CssClass="form-control" runat="server"></asp:TextBox>
                </div>
                <div class="form-group">
                    <label for="lblFechaNac">Fecha de Nacimiento:</label>
                    <asp:TextBox ID="txtFechaNac" CssClass="form-control" runat="server"></asp:TextBox>
                </div>
                <hr />
                <div class="form-group">
                    <label for="lblTelefono">Teléfono:</label>
                    <asp:TextBox ID="txtTelefono" CssClass="form-control" runat="server"></asp:TextBox>
                </div>
                <div class="form-group">
                    <label for="lblDirección">Dirección:</label>
                    <asp:TextBox ID="txtDireccion" CssClass="form-control" runat="server"></asp:TextBox>
                </div>
                <div class="form-group">
                    <label for="lblEmail">E-mail:</label>
                    <asp:TextBox ID="txtEmail" CssClass="form-control" runat="server"></asp:TextBox>
                </div>
                <asp:Button ID="btnRegistro" CssClass="btn btn-default" runat="server" 
                    Text="Registrarme" onclick="btnRegistro_Click" />
         </form>
        
    </div>
    <div class="grid_6 cajaservicios">
        <h2 class="text-3 color-4 wow fadeInUp animated" style="visibility: visible; animation-name: fadeInUp;">¿Por qué registrarme?</h2>
        <p>
            Con tu cuenta en Veranum podrás tener un control de todas reservas que has hecho en nuestros diferentes hoteles. 
        </p>
        <hr />
        <div style="text-align: left">
        <strong style="font-weight: bold">Beneficios de tu cuenta:</strong>
        <ul>
            <li>- ¡Podrás hacer reservaciones por nuestro sitio web!</li>
            <li>- Puedes cancelar tu reservación en cualquier momento.</li>
            <li>- Tendrás un control de todas las reservas que has hecho.</li>
            <li>- Reservar una habitación sólo indicando tu RUT en nuestros hoteles. </li>
        </ul>
        </div>
    </div>
</asp:Content>


<%@ Page Title="" Language="C#" MasterPageFile="~/VeranumMaster.master" AutoEventWireup="true" CodeFile="registro.aspx.cs" Inherits="registro" %>

<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <div class="grid_6">
        <h2 class="heading text-2 color-4 wow fadeInUp animated" style="visibility: visible; animation-name: fadeInUp;">Registro de Usuarios</h2>
            <asp:Label ID="lblError" runat="server" Text=""></asp:Label>
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
        
    </div>
</asp:Content>


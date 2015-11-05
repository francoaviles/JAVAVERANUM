<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPage.master" AutoEventWireup="true" CodeFile="Login.aspx.cs" Inherits="Login" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cpContenido" Runat="Server">
    <div class="row contenido">
        <h1>Ingresar</h1>
            <asp:Label ID="lblError" runat="server" Text=""></asp:Label>
          <div class="form-group">
            <label for="lblRut">Rut:</label>
              <asp:TextBox ID="txtRut" CssClass="form-control" runat="server"></asp:TextBox>
          </div>
          <div class="form-group">
            <label for="exampleInputPassword1">Contraseña:</label>
              <asp:TextBox ID="txtContraseña" CssClass="form-control" TextMode="Password" runat="server"></asp:TextBox>
          </div>
        <asp:Button ID="btnIngresar" CssClass="btn btn-default" runat="server" 
            Text="Entrar" onclick="btnIngresar_Click" />
    </div>
</asp:Content>


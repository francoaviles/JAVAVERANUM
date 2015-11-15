<%@ Page Title="" Language="C#" MasterPageFile="~/VeranumMaster.master" AutoEventWireup="true" CodeFile="Login.aspx.cs" Inherits="Login" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <div class="grid_8">
        <h2 class="heading text-2 color-4 wow fadeInUp animated" style="visibility: visible; animation-name: fadeInUp;">Ingresar</h2>
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


<%@ Page Title="" Language="C#" MasterPageFile="~/VeranumMaster.master" AutoEventWireup="true" CodeFile="reservar.aspx.cs" Inherits="reservar" %>

<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <div class="grid_12">
        <h2 class="heading text-2 color-4 wow fadeInUp animated" style="visibility: visible; animation-name: fadeInUp;">Reservar</h2>
        <hr />
    </div>
    <form id="FormReservar" method="post" class="formReservar form-inline"  runat="server">
    <div class="grid_12 cajahab">
            <div class="form-group">
                <label for="lblhotel">Hotel:</label> 
                <asp:DropDownList  CssClass="form-control" ID="cbHoteles" runat="server">
                <asp:ListItem>sadsad</asp:ListItem>
                </asp:DropDownList>
            </div>
        <hr />
            <div class="form-group">
                <label for="lblFechaIngreso" style="font-weight: bold">Fecha Ingreso:</label>
                <asp:TextBox ID="txtFechaIngreso" CssClass="form-control" runat="server"></asp:TextBox>
            </div>
            
            <div class="form-group">
                <label for="lblFechaSalida" style="font-weight: bold">Fecha Salida:</label>
                <asp:TextBox ID="txtFechaSalida" CssClass="form-control" runat="server"></asp:TextBox>
            </div>
        <hr />
            <div class="form-group">
                <label for="lblTotalDias" style="font-weight: bold">Días totales:</label>
                <asp:Label ID="lblTotalNDias"  CssClass=" form-control dias_totales" runat="server" Text="0"></asp:Label>
            </div>

            <div class="form-group">
                <label for="lblCantPersonas" style="font-weight: bold">Cantidad de Personas:</label>
                <asp:TextBox ID="txtCantPersonas" CssClass="form-control" Width="45" MaxLength="2" runat="server"></asp:TextBox>
            </div>
        <hr />
            <asp:Button ID="btnSeguir" CssClass="btn btn-success" runat="server" style="color: #fff" Text="Seguir" />
    </div>
    <div class="grid_12 cajahotel" style="margin-top: 10px; display: block">
         
    </div>
    </form>
</asp:Content>


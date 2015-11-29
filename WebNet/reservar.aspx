<%@ Page Title="" Language="C#" MasterPageFile="~/VeranumMaster.master" AutoEventWireup="true" CodeFile="reservar.aspx.cs" Inherits="reservar" %>

<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <div class="grid_12">
        <h2 class="heading text-2 color-4 wow fadeInUp animated" style="visibility: visible; animation-name: fadeInUp;">Reservar</h2>
        <hr />
    </div>
    <form id="FormReservar" method="post" class="formReservar form-inline"  runat="server">
    <div class="grid_12 cajahab" id="pasouno_reserva">
        <h3 class="text-3 color-4 wow fadeInUp animated" style="visibility: visible; animation-name: fadeInUp;">Calendario</h3>
            <div class="form-group">
                <input type="hidden" name="iduser" id="iduser" value="">
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
                <asp:DropDownList CssClass="form-control" ID="cbCantPersonas" runat="server">
                    <asp:ListItem Value="1">1</asp:ListItem>
                    <asp:ListItem Value="2">2</asp:ListItem>
                    <asp:ListItem Value="3">3</asp:ListItem>
                    <asp:ListItem Value="4">4</asp:ListItem>
                    <asp:ListItem Value="5">5</asp:ListItem>
                    <asp:ListItem Value="6">6</asp:ListItem>
                </asp:DropDownList>
            </div>
        <hr />
            <asp:Button ID="btnSeguir" CssClass="btn btn-success" runat="server" 
            style="color: #fff" Text="Seguir" onclick="btnSeguir_Click" />
    </div>
     <div class="grid_12 cajaerror" id="nohabs"  style="margin-top: 10px; display: <%=nohab%>" >
            No hay habitaciones disponibles en esta fecha.
     </div>
    <div class="grid_12 cajahotel" id="pasodos_reserva" style="margin-top: 10px; display: <%=pasodos%>">
         <h3 class="text-2 color-4 wow fadeInUp animated" style="visibility: visible; animation-name: fadeInUp;">Habitación</h3>
         <h4 class="text-3 color-4 wow fadeInUp animated" style="visibility: visible; animation-name: fadeInUp;">¡Tenemos <span id="cantHabs">4</span> habitaciones disponibles para ti!</h4>
        <p>
            Elige la que más te guste.
        </p>
        <hr />
        <div class="form-group" id="habdisponibles">
        </div>
        <hr />
        <button id="goPasoTres" disabled="disabled" style="color: #fff" class="btn btn-success">Seguir</button>
    </div>

    <div class="grid_12 cajaservicios" id="pasotres_servicios" style="margin-top: 10px; display: <%=pasotres%>">
         <h3 class="text-2 color-4 wow fadeInUp animated" style="visibility: visible; animation-name: fadeInUp;">Servicios</h3>
        <hr />
        <div class="form-group" id="serviciosDisp">
        </div>
        <hr />
            <h2 class="text-2 color-5 wow fadeInUp animated" style="visibility: visible; animation-name: fadeInUp;">
                Total por día: $<span id="totalxdias">0</span>
            </h2>
            <h2 class="text-2 color-4 wow fadeInUp animated" style="visibility: visible; animation-name: fadeInUp;">
                Total a pagar: $<span id="total">0</span>
            </h2>
        <hr />
       <asp:Button ID="btnReservar" CssClass="btn btn-success" runat="server" 
            style="color: #fff" Text="¡RESERVAR!" />
    </div>
    </form>
</asp:Content>


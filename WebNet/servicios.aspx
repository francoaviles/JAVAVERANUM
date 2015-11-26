<%@ Page Title="" Language="C#" MasterPageFile="~/VeranumMaster.master" AutoEventWireup="true" CodeFile="servicios.aspx.cs" Inherits="servicios" %>

<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <div class="grid_12">
        <h2 class="heading text-2 color-4 wow fadeInUp animated" style="visibility: visible; animation-name: fadeInUp;">Servicios</h2>
        <p>
            Hoteles Veranum ofrece diferentes servicios para que nuestros clientes tengan un momento de entretención, 
            relajación o pasar el tiempo haciendo deporte. Cada uno de estos servicios posee la mejor calidad e infraestructura.
        </p>
        <hr />
    </div>
    <% for (int i = 0; i < dt_servicios.Rows.Count; i++)
       {
    %>
    <div class="grid_4">
		<div class="wow fadeInLeft animated cajaservicios" data-wow-delay="0.5s" style="visibility: visible; animation-delay: 0.5s; animation-name: fadeInLeft;">
            <div class="block-4_s6">
                <h5 class=" text-3 wow fadeInUp animated" style="visibility: visible; animation-name: fadeInUp;"><%=dt_servicios.Rows[i]["nombre"].ToString()%></h5>
                <div class="block-4_s6_item">
                    <div class="wrap-box__left"></div>
                    <div class="wrap-box__none">
                        <div class="text-5"><span class="color-6 text__bold">$<%=dt_servicios.Rows[i]["precio"].ToString()%></span> \ Uso</div>
                    </div>
                </div>
            </div>
		</div>
	</div>
    <% } %>
</asp:Content>


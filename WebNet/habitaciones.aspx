<%@ Page Title="" Language="C#" MasterPageFile="~/VeranumMaster.master" AutoEventWireup="true" CodeFile="habitaciones.aspx.cs" Inherits="habitaciones" %>

<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
<div class="grid_12">
        <h2 class="heading text-2 color-4 wow fadeInUp animated" style="visibility: visible; animation-name: fadeInUp;">Habitaciones</h2>
        <p>
            Nuestro hotel cuenta con habitaciones de lujo, para que te sientas cómodo y acogido como en casa.
        </p>
        <hr />
    </div>
    <% for (int i = 0; i < dt_tb.Rows.Count; i++)
       {
    %>
    <div class="grid_4">
		<div class="wow fadeInLeft animated cajahab" data-wow-delay="0.5s" style="visibility: visible; animation-delay: 0.5s; animation-name: fadeInLeft;">
            <div class="block-4_s6">
                <h5 class=" text-3 color-1 wow fadeInUp animated" style="visibility: visible; animation-name: fadeInUp; text-shadow: 1px 1px 5px #000"><%=dt_tb.Rows[i]["nombre"].ToString()%></h5>
                <div class="block-4_s6_item">
                    <hr />
                    <div class="wrap-box__none">
                        Desde 
                        <div class="text-5"><span class="color-5 text__bold">$<%=dt_tb.Rows[i]["precio"].ToString()%> </span> / Noche</div>
                    </div>
                </div>
            </div>
		</div>
	</div>
    <% } %>
</asp:Content>


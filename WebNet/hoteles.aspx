<%@ Page Title="" Language="C#" MasterPageFile="~/VeranumMaster.master" AutoEventWireup="true" CodeFile="hoteles.aspx.cs" Inherits="Hoteles_Todos" %>

<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <div class="grid_12">
        <h2 class="heading text-2 color-4 wow fadeInUp animated" style="visibility: visible; animation-name: fadeInUp;">Hoteles</h2>
        <p>
        Hoteles Veranum cuenta con <strong><%=hoteles.Rows.Count%></strong> hoteles de lujo a lo largo de Chile. 
        Cada uno de ellos ha sido diseñado pensando en nuestros clientes para que su estaría sea lo más placentera posible.
        </p>
        <hr />
    </div>
    <% for (int i = 0; i < hoteles.Rows.Count; i++) {
           string direccion = hoteles.Rows[i]["direccion"].ToString().Replace(" ", "+");
           string comuna = hoteles.Rows[i]["comuna_nombre"].ToString().Replace(" ", "+");

           string iframe = direccion + comuna;
    %>
    <div class="grid_4">
		<h5 class=" text-3  wow fadeInUp animated" style="visibility: visible; animation-name: fadeInUp;"><%=hoteles.Rows[i]["nombre"].ToString()%></h5>
		<div class="block-7 wow fadeInLeft animated cajahotel" data-wow-delay="0.5s" style="visibility: visible; animation-delay: 0.5s; animation-name: fadeInLeft;">
           <iframe width="100%" height="100%" frameborder="0" style="border:0" src="https://www.google.com/maps/embed/v1/place?q=<%=iframe%>,+Chile&key=AIzaSyCL90b8sX49nXC0xb7Tnd23GpKkLgvcbhI"></iframe> 
            <p>
                <%=hoteles.Rows[i]["region_nombre"].ToString()%> 
                <br /> 
                <%=hoteles.Rows[i]["direccion"].ToString()%> 
                <br />
                <%=hoteles.Rows[i]["provincia_nombre"].ToString()%>, <%=hoteles.Rows[i]["comuna_nombre"].ToString()%>, Chile
            </p>
			<a href="#" class="btncaja">¡Reservar!</a>
		</div>
	</div>
    <% } %>
</asp:Content>


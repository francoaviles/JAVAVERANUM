<%@ Page Title="" Language="C#" MasterPageFile="~/VeranumMaster.master" AutoEventWireup="true" CodeFile="misreservas.aspx.cs" Inherits="misreservas" %>

<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <div class="grid_12">
        <h2 class="heading text-2 color-4 wow fadeInUp animated" style="visibility: visible; animation-name: fadeInUp;">Mis Reservas</h2>
        <p>
        Todas las reservas que has realizado. 
        </p>
        <hr />
    </div>
    <% if (reservas.Rows.Count == 0)     { %>
        No hay reservas.
    <% }    else      { %>
    <div class="grid_12">
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>#</th>
                    <th>Fecha entrada</th>
                    <th>Fecha salida</th>
                    <th>Habitaciones</th>
                    <th>Servicios</th>
                    <th>Total</th>
                    <th>Estado</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
            <% for (int i = 0; i < reservas.Rows.Count; i++)
               {
                   getServs(int.Parse(reservas.Rows[i]["id_reserva"].ToString())); 
                   getHabs(int.Parse(reservas.Rows[i]["id_reserva"].ToString()));                    %>
                <tr>
                    <td><%=reservas.Rows[i]["id_reserva"].ToString()%></td>
                    <td><%=reservas.Rows[i]["fecha_ingreso"].ToString()%></td>
                    <td><%=reservas.Rows[i]["fecha_salida"].ToString()%></td>
                    <td>
                        <ul>
                        <% for (int k = 0; k < h.Rows.Count; k++)
                            { %>
                            <li><%=h.Rows[k]["ubicacion"].ToString()%> - 
                                $<%=h.Rows[k]["precio"].ToString()%>
                            </li>
                        <% } %>
                        </ul>
                    </td>
                    <td>
                        <% if (s.Rows.Count > 0) { %>
                            <ul>
                            <% for (int j = 0; j < s.Rows.Count; j++)  { %>
                                <li><%=s.Rows[j]["nombre"].ToString()%> - 
                                    $<%=s.Rows[j]["precio"].ToString()%>
                                </li>
                            <% } %>
                            </ul>
                        <% } else { %>
                            Ningún servicio.
                        <% } %>
                    </td>
                    <td>$<%=reservas.Rows[i]["precio_total"].ToString()%></td>
                    <td><%=reservas.Rows[i]["nombre"].ToString()%></td>
                    <td>
                        <% if (reservas.Rows[i]["id_reserva_estado"].ToString() == "1") { %>
                            <a href="cancelar_reserva.aspx?id=<%=reservas.Rows[i]["id_reserva"].ToString()%>" style="padding: 5px; background-color: #d20705; color: #fff">Cancelar</a>
                        <% } %>
                    </td>
                </tr>
            <% } %>
            </tbody>
        </table>
    </div>
    <% } %>
</asp:Content>


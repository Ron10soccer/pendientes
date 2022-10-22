<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.Tareas"%>
<%
    if(session.getAttribute("tareas") == null){
        ArrayList<Tareas> lisaux = new ArrayList<Tareas>();
        session.setAttribute("tareas", lisaux);
    }
        ArrayList<Tareas> almacen = (ArrayList<Tareas>)session.getAttribute("tareas");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>AGREGAR PENDIENTES</h1>
        <form action="MainServlet" method="post">
            <table>
                <tr>
                    <td>Id</td>
                    <td><input type="text" name="id" value="o"></td>
                </tr>
                <tr>
                    <td>Pendientes</td>
                    <td><input type="text" name="pendientes" value=""></td>
                </tr>
               <%-- <tr>
                    <td>Cantidad</td>
                    <td><input type="text" name="cantidad" value="0"></td>
                </tr>
                <tr>
                    <td>Precio</td>
                    <td><input type="text" name="precio" value="0"></td>
                </tr>--%>
                <tr>
                    <td></td>
                    <td><input type="submit"  value="Procesar"></td>
                </tr>
            </table>
            
        </form>
                
        <a href="MainServlet?op=vaciar">Vaciar Tareas</a>
        <h2>TAREAS PENDIENTES</h2>
        <table>
            <tr>
            <th>Id</th>
            <th>tareas</th>
            <th>Completado</th>
            <%--<th>Cantidad</th>
            <th>Precio</th>--%>
            <th></th>
            </tr>
            <%
                if(almacen != null){
                    for(Tareas p : almacen){
            %>
            
            <tr>
            
                <td><%= p.getId() %></td>
                <td><%= p.getPendientes()%></td>
                <td><input type="checkbox" name="completado" value="ON" /></td>
                <%--<td><%= p.getCantidad()  %></td>
                <td><%= p.getPrecio()  %></td>--%>
            
                <td><a href="MainServlet?op=eliminar&id=<%= p.getId() %>">Eliminar</a></td>
            </tr>
            
            <%
                    }
                }
            %>
        </table>
    </body>
</html>
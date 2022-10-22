
package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {

    
    


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("op");
        if(op.equals("vaciar")){
            
        HttpSession ses = request.getSession();
        ses.invalidate();
        response.sendRedirect("index.jsp");
        }
        //eliminar el producto
        if(op.equals("eliminar")){
            int pos =-1, buscado=-1;
            int id = Integer.parseInt( request.getParameter("id"));
            HttpSession ses = request.getSession();
            ArrayList<Tareas> lista = (ArrayList<Tareas>)ses.getAttribute("tareas");
            
            for(Tareas p: lista){
                pos++;
                if(p.getId() == id ){
                buscado = pos;
                }
            }
            lista.remove(buscado);
            response.sendRedirect("index.jsp");
        }
     }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       int id =Integer.parseInt( request.getParameter("id"));
       String pendientes = request.getParameter("pendientes");
      
       
       Tareas prod = new Tareas();
       
       prod.setId(id);
       prod.setPendientes(pendientes);
       
       
       HttpSession ses = request.getSession();
       
       ArrayList<Tareas> lista = (ArrayList<Tareas>)ses.getAttribute("tareas");
       lista.add(prod);
       
       response.sendRedirect("index.jsp");
}
}

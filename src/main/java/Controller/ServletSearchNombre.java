/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.DAOingreso;
import Model.Crudingreso;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author User
 */
public class ServletSearchNombre extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            String parametro = request.getParameter("nombre");
            Crudingreso nombre = new Crudingreso();
            List<DAOingreso> listarNombre = nombre.Read_Search(parametro);
            
            String respuesta = "";
            if(!listarNombre.isEmpty()){
                for(int i = 0; i < listarNombre.size(); i++){
                    respuesta += elementBuilder(listarNombre.get(i));
                }
                request.setAttribute("respuesta","<div class='formulario'>" + respuesta + "</div>");
                request.getRequestDispatcher("SearchNombre.jsp").forward(request, response);
            }else{
                String mensaje = "<div class='formulario'><label class=\"label-item\"><b>"
                        + "No se han encontrado elementos para la busqueda: " + parametro + "</b></label></div>";
                request.setAttribute("respuesta", mensaje);
            }            
        }
    }
    protected String elementBuilder(DAOingreso listarNombre){
                String opentable = "<table class=\"tableVenta\" align=\"center\" "
                        + "style=\"display:inline-block\">";
                String id = "<tr><td><label class=\"label-item\"><b>" + listarNombre.getID_INGRESO()
                        + "<\b></label></td></tr>";
                String nombre = "<tr><td><label class=\"label-item\"><b>" + listarNombre.getVCH_INGRESO_NOMBRE()
                        + "</b></label></td></tr>";
                String closetable =
                        "</table>";
                String elemento = opentable + id + nombre + closetable;
                return elemento;
        }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

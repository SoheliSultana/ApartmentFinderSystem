/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uwb;

import com.uwb.entity.apartment.ApartmentData;
import com.uwb.entity.apartment.ApartmentIf;
import com.uwb.servicelocator.ServiceLocator;
import com.uwb.session.ApartmentServiceService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Prova
 */
public class SaveApartment extends HttpServlet {

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
        try {
            /* TODO output your page here. You may use following sample code. */
            ApartmentServiceService aptService= (ApartmentServiceService)ServiceLocator.getService(ServiceLocator.APARTMENTSERVICE_SERVICE);
            ApartmentData apt = new ApartmentData(); 
            
            apt.setName(request.getParameter("name"));
            apt.setOwner(request.getParameter("owner"));
            apt.setDescription(request.getParameter("description"));
            apt.setImageurl(request.getParameter("imageurl"));
            apt.setParking(request.getParameter("parking"));
            Random rand = new Random();
       
            apt.setId(rand.nextInt(1000000));
            ApartmentIf result = aptService.addApartment(apt);
            
            if(result != null){
                response.sendRedirect("apartment.jsp?status=success");
            }else{
                response.sendRedirect("apartment.jsp?status=error");
            }
                       
        }catch (Exception e){
            response.sendRedirect("apartment.jsp?status=exception");
        }
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

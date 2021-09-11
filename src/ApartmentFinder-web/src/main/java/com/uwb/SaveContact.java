/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uwb;

import com.uwb.entity.contact.ContactData;
import com.uwb.entity.contact.ContactIf;
import com.uwb.servicelocator.ServiceLocator;
import com.uwb.session.ApartmentServiceService;
import java.io.IOException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Prova
 */
public class SaveContact extends HttpServlet {

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
            ContactData contact = new ContactData();
            contact.setApartmentid(Integer.parseInt(request.getParameter("apartmentid")));
            contact.setEmail(request.getParameter("email"));
            contact.setOpenhour(request.getParameter("openhour"));
            contact.setPhone(request.getParameter("phone"));
            contact.setRepresentative(request.getParameter("representative"));
            
            Random rand = new Random();
            contact.setId(rand.nextInt(1000000));
            ContactIf result = aptService.addContact(contact);
            
            if(result != null){
                response.sendRedirect("contact.jsp?status=success");
            }else{
                response.sendRedirect("contact.jsp?status=error");
            }
                       
        }catch (Exception e){
            response.sendRedirect("contact.jsp?status=exception");
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

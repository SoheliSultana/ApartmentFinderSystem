/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uwb;

import com.uwb.entity.deals.DealsData;
import com.uwb.entity.deals.DealsIf;
import com.uwb.entity.units.UnitsData;
import com.uwb.entity.units.UnitsIf;
import com.uwb.servicelocator.ServiceLocator;
import com.uwb.session.ApartmentServiceService;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Prova
 */
public class SaveUnits extends HttpServlet {

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
            UnitsData unit = new UnitsData();
            unit.setApertmentid(Integer.parseInt(request.getParameter("apartmentid")));
            Date date=new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("availability")); 
            Timestamp ts=new Timestamp(date.getTime());  
            unit.setAvalibility(ts);
            unit.setNumber(request.getParameter("number"));
            unit.setSquareft(request.getParameter("squareft"));
            unit.setType(request.getParameter("type"));
            unit.setRent(BigDecimal.valueOf(Long.parseLong(request.getParameter("rent"))));
            Random rand = new Random();
            unit.setId(rand.nextInt(1000000));
            UnitsIf result = aptService.addUnits(unit);
            
            if(result != null){
                response.sendRedirect("units.jsp?status=success");
            }else{
                response.sendRedirect("units.jsp?status=error");
            }
                       
        }catch (Exception e){
            response.sendRedirect("units.jsp?status=exception");
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

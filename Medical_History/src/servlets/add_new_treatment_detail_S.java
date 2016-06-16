/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import DAO.disease;
import DAO.treatments;
import controllers.diseaseC;
import controllers.treatmentC;
import controllers.userDetailsC;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Scorpius
 */
public class add_new_treatment_detail_S extends HttpServlet {

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
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        
     
   String name=request.getParameter("disease_name");
   String  date=request.getParameter("date") ;
   String  treatment =request.getParameter("treatment");
   String  description=request.getParameter("description");
   HttpSession session = request.getSession(true);
   String   addedby;
        addedby = (String)session.getAttribute("UserName");
     int patient_id=userDetailsC.getId(addedby);
        System.out.println("patient_id:::::::::::::::::::::::::"+patient_id);
     
     
    long   CreationTime=session.getCreationTime();
    long LastAccessedTime=session.getLastAccessedTime();
    
        System.out.println("session name"+addedby+CreationTime+" "+ LastAccessedTime);
        DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM);
        Date creationTime = new Date(session.getCreationTime() );
        Date lastAccessed = new Date(session.getLastAccessedTime());
       
        java.util.Date now = new java.util.Date();
        System.out.println("now "+now);
        SimpleDateFormat format=new SimpleDateFormat("yyyy/mm/dd HH:mm:ss");
        String currentTime=format.format(now);
        System.out.println("now::::"+currentTime);
     //  Date newDate=new Date();
         
        System.out.println("cretatio time"+formatter.format(creationTime));
        System.out.println("LAST ACC time"+formatter.format(lastAccessed));
        //  System.out.println("cretatio time"+ formatter.format(now) );
        String dummyDay="today";
   
         treatments newTreatment=new treatments(patient_id,name,date,treatment,description,addedby,currentTime);
          treatmentC.addNewTreatment(newTreatment);
          response.sendRedirect("user_treatments.jsp");
   
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(add_new_treatment_detail_S.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(add_new_treatment_detail_S.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(add_new_treatment_detail_S.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(add_new_treatment_detail_S.class.getName()).log(Level.SEVERE, null, ex);
        }
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

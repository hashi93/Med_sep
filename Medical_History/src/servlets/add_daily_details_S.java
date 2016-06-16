/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import DAO.daily_details;
import controllers.dailyDetailsC;
import controllers.userDetailsC;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
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
public class add_daily_details_S extends HttpServlet {

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
            throws ServletException, IOException, SQLException, ClassNotFoundException, ParseException {
        response.setContentType("text/html;charset=UTF-8");

        
         HttpSession session = request.getSession(true);
   String   addedby;
        addedby = (String)session.getAttribute("UserName");
     int patient_id=userDetailsC.getId(addedby);
        
        
        
        int type;
        float value;
        String type1 = request.getParameter("type");
        String date = request.getParameter("date");
        String value1 = request.getParameter("value");
       
        //compare dates
        java.util.Date now = new java.util.Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy/MM/dd");
        java.util.Date inputDate = format.parse(date);
        if(now.compareTo(inputDate)>=0){
            
        System.out.println("type"+type1+"date"+date+"value"+value1);
        if(type1.equals("weight")){
        type=1;
        }
        else{
        type=2;
        }
        value=Float.valueOf(value1);
        daily_details newDetail=new daily_details(type,date,patient_id,value);
        try{
        dailyDetailsC.addNewDetail(newDetail);
        
        response.sendRedirect("user_daily_details.jsp?message=success");
        }catch(Exception e){
        response.sendRedirect("user_daily_details.jsp?message=primary");
        }
        }
        
        else{
            String m="Idate";
             response.sendRedirect("user_daily_details.jsp?message=Idate");
            }
       // response.sendRedirect("user_daily_details.jsp?message"+"Idate");
//    response.setContentType("text/html");
//    request.setAttribute("message", "Idate");
//    request.getRequestDispatcher("user_daily_details.jsp").forward(request, response);




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
            Logger.getLogger(add_daily_details_S.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(add_daily_details_S.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(add_daily_details_S.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(add_daily_details_S.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(add_daily_details_S.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(add_daily_details_S.class.getName()).log(Level.SEVERE, null, ex);
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

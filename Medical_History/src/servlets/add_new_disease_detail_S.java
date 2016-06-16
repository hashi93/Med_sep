/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import DAO.disease;
import controllers.diseaseC;
import controllers.userDetailsC;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import static java.time.Instant.now;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Scorpius
 */
public class add_new_disease_detail_S extends HttpServlet {

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
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet add_new_disease_detail_S</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet add_new_disease_detail_S at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }

        String name = request.getParameter("disease_name");
        String date = request.getParameter("date");
        String date2 = request.getParameter("date");
        String syptom = request.getParameter("symptoms");
        String description = request.getParameter("description");
        HttpSession session = request.getSession(true);
        String addedby;
        addedby = (String) session.getAttribute("UserName");
        int patient_id = userDetailsC.getId(addedby);

        long CreationTime = session.getCreationTime();
        long LastAccessedTime = session.getLastAccessedTime();

        DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
        Date creationTime = new Date(session.getCreationTime());
        Date lastAccessed = new Date(session.getLastAccessedTime());

        java.util.Date now = new java.util.Date();
//        System.out.println("now "+now);
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String currentTime = format.format(now);
        System.out.println("now::::" + currentTime);

//        System.out.println("cretatio time"+formatter.format(creationTime));
//         System.out.println("LAST ACC time"+formatter.format(lastAccessed));
//        String dummyDay="today";
        java.util.Date now2 = new java.util.Date();
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy/MM/dd");
        java.util.Date inputDate = format2.parse(date2);
        if (now2.compareTo(inputDate) >= 0) {

            disease newDisease = new disease(patient_id, name, date, syptom, description, addedby, currentTime);

            try {
                diseaseC.addNewDisease(newDisease);

                response.sendRedirect("user_home.jsp?addDis=success");
            } catch (Exception ex) {
                response.sendRedirect("user_home.jsp?addDis=error");
                Logger.getLogger(add_new_disease_detail_S.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            // System.out.println("invalid date");
            response.sendRedirect("user_home.jsp?addDis=invalid");

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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(add_new_disease_detail_S.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(add_new_disease_detail_S.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(add_new_disease_detail_S.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(add_new_disease_detail_S.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(add_new_disease_detail_S.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(add_new_disease_detail_S.class.getName()).log(Level.SEVERE, null, ex);
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

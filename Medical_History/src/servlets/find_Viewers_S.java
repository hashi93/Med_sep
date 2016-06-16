/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import DAO.doctor_details;
import DAO.userLogin;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import controllers.doctorDetailsC;
import controllers.userDetailsC;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import static java.util.Collections.list;
import java.util.List;
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
public class find_Viewers_S extends HttpServlet {

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
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet find_Viewers_S</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet find_Viewers_S at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }


        System.out.println("INside find_Viewers Servlet");

        
        String input=request.getParameter("q");
        System.out.println(input);
       java.util.ArrayList<doctor_details> listOfDoctors=new java.util.ArrayList<doctor_details>();
        HttpSession session = request.getSession(true);
    String patient_name=(String) session.getAttribute("UserName");
    int patient_id=userDetailsC.getId(patient_name);
    
       listOfDoctors=doctorDetailsC.serchDoctors(input,patient_id);
//        response.setHeader("Cache-Control", "no-cache");
//        response.setHeader("Pragma", "no-cache");
if(listOfDoctors.isEmpty()){
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
}

else{
            Gson gson=new Gson();
            JsonElement element=gson.toJsonTree(listOfDoctors,new TypeToken<List<doctor_details>>(){}.getType());
            response.setContentType("application/json");
            //response.setHeader("Cache-Control", "no-cache");
            JsonArray jsonArray=element.getAsJsonArray();
            response.getWriter().print(jsonArray);
                    
                    }
//        PrintWriter out = response.getWriter();
//        String message = "Currently time is %tr on %tD.sadasdasd";
//        out.print(message);


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
            Logger.getLogger(find_Viewers_S.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(find_Viewers_S.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(find_Viewers_S.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(find_Viewers_S.class.getName()).log(Level.SEVERE, null, ex);
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

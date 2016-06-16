/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import DAO.disease;
import DAO.doctor_details;
import DAO.treatments;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import controllers.diseaseC;
import controllers.treatmentC;
import controllers.userDetailsC;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Scorpius
 */
public class view_detailsD_s extends HttpServlet {

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

        String msg = request.getParameter("q");
        String[] parts = msg.split(",");
        String email = parts[0];
        String name = parts[1];
        String type = parts[2];
        System.out.println(email);

        if (type.equals("View Disease Details")) {
            try {
                //get patient id
                int patient_id = userDetailsC.getId(email);

                //get disease list
                 ArrayList<disease> listOfDis = new ArrayList<disease>();
                listOfDis = diseaseC.returnListOfDis(patient_id);
                //check empy and send
                if(listOfDis.isEmpty()){
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
}

else{
            Gson gson=new Gson();
            JsonElement element=gson.toJsonTree(listOfDis,new TypeToken<List<disease>>(){}.getType());
            response.setContentType("application/json");
            //response.setHeader("Cache-Control", "no-cache");
            JsonArray jsonArray=element.getAsJsonArray();
            response.getWriter().print(jsonArray);
                    
                    }
                
                
                
            } catch (Exception e) {

            }

        } else {
            
            
             try {
                //get patient id
                int patient_id = userDetailsC.getId(email);

                //get disease list
                 ArrayList<treatments> listOfTr = new ArrayList<treatments>();
                listOfTr = treatmentC.returnListOfT(patient_id);
                //check empy and send
                if(listOfTr.isEmpty()){
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
}

else{
            Gson gson=new Gson();
            JsonElement element=gson.toJsonTree(listOfTr,new TypeToken<List<treatments>>(){}.getType());
            response.setContentType("application/json");
            //response.setHeader("Cache-Control", "no-cache");
            JsonArray jsonArray=element.getAsJsonArray();
            response.getWriter().print(jsonArray);
                    
                    }
                
                
                
            } catch (Exception e) {

            }
            
            
            
            
            
            

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
            Logger.getLogger(view_detailsD_s.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(view_detailsD_s.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(view_detailsD_s.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(view_detailsD_s.class.getName()).log(Level.SEVERE, null, ex);
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

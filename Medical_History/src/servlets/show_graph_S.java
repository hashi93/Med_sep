/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import DAO.daily_details;
import DAO.doctor_details;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import controllers.dailyDetailsC;
import controllers.userDetailsC;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.json.JSONObject;

/**
 *
 * @author Scorpius
 */
public class show_graph_S extends HttpServlet {

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

        //find values
        System.out.println("daily details show");
        HttpSession session = request.getSession(true);
        String addedby;
        addedby = (String) session.getAttribute("UserName");
        int patient_id = userDetailsC.getId(addedby);

        System.out.println("type set by user");

        String data = request.getParameter("q");
        System.out.println("qqqqqq"+data);
        String[] parts = data.split(",");
        String type1 = parts[0]; // 004
        String dateF = parts[1];
        String dateT = parts[2];

        System.out.println("type set by user" + type1+" "+dateF+" "+dateT);
      
         int type;
        if(type1.equals("weight")){
        type=1;
        }
        else{
        type=2;
        }

        java.util.ArrayList<daily_details> listDD = new java.util.ArrayList<daily_details>();
        listDD=dailyDetailsC.serchDetails(dateF, dateT, patient_id,type);

        //send json object
        if (listDD.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        } else {
            System.out.println("agdhasgdha");
            Gson gson = new Gson();
            JsonElement element = gson.toJsonTree(listDD, new TypeToken<List<daily_details>>() {
            }.getType());
            response.setContentType("application/json");
            //response.setHeader("Cache-Control", "no-cache");
            JsonArray jsonArray = element.getAsJsonArray();
            response.getWriter().print(jsonArray);

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
            Logger.getLogger(show_graph_S.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(show_graph_S.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(show_graph_S.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(show_graph_S.class.getName()).log(Level.SEVERE, null, ex);
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

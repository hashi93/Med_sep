/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import DAO.doctor_details;
import DAO.userLogin;
import DAO.user_details;
import controllers.doctorDetailsC;
import controllers.loginInfoC;
import controllers.userDetailsC;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.net.URLEncoder;
import java.sql.SQLException;
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
public class add_new_user_S extends HttpServlet {

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
//            out.println("<title>Servlet add_new_user_S</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet add_new_user_S at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
        //  response.sendRedirect("doctor_home.jsp");


        String fullName=request.getParameter("firstName")+request.getParameter("lastName");
        String password=request.getParameter("password");
        String userName=request.getParameter("emailAddress");
       String Ptype=request.getParameter("user type");
       int type;
       if(Ptype.equals("Patient")){
       type=1;
       
       }
       else{
       type=2;
       }
//        //set session
        
    userLogin newUserlogIn=new userLogin(userName,password,type);
        System.out.println("servlet1");
    
     
        try {
            loginInfoC.addNewUser(newUserlogIn);
            
            
           
            //check for doctor and patient and seperate
           if(Ptype.equals("Patient")){
      user_details newUserDetails=new user_details(fullName);
       userDetailsC.addNewUser(newUserDetails,newUserlogIn);
       
       }
       else{
              
            doctor_details newDoctor=new doctor_details(fullName);
          doctorDetailsC.addNewDoctor(newDoctor,newUserlogIn);
               
       
       
       }
            

            //checking for sucess
//            if(){}
//            else{}

                    //create session 
            HttpSession session = request.getSession();
            session.setAttribute("UserName",userName);

            response.sendRedirect("user_home.jsp");
            
        } catch (Exception ex) {
//            System.out.println("SQL ex");
//            System.out.println(ex.getErrorCode());
//            System.out.println("above");
//            if(ex.getErrorCode()==1062){
//            
          //   for duplicate input 
           // String msign="primary";
            
           // response.sendRedirect("index.jsp?message=" + URLEncoder.encode(msg, "UTF-8"));
            
             response.sendRedirect("index.jsp?msign=primary");
            
            
        //    }
            
            
            
            
            
            
            Logger.getLogger(add_new_user_S.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(add_new_user_S.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(add_new_user_S.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(add_new_user_S.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(add_new_user_S.class.getName()).log(Level.SEVERE, null, ex);
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

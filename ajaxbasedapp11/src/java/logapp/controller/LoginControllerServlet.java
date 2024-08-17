/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logapp.dao.UserDAO;
import logapp.dto.UserDTO;

/**
 *
 * @author pc
 */
public class LoginControllerServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           String userid=request.getParameter("uid");
           String password=request.getParameter("pwd");
           if(userid.isEmpty() || password.isEmpty())
           {
               out.println("<h3 style=color:red;>Please fill all the fields</h3>");
               
           }
           else
           {
               System.out.println("uid:"+userid+"pwd:"+password);
               try{
                   boolean userFound = UserDAO.findUser(userid,password);
                   if(!userFound){
                       UserDTO user=new UserDTO();
                       user.setUserId(userid);
                       user.setPassword(password);
                   out.println("<h3 style=color:red;>Login Denied<br>Username/Password incorrect?....Try Again.");
                   }
            else
            {
                    out.println("<h3 style=color:green;>Login sucessful!Welcome...Enjoy Surfing</h3>");
                    
             }
       }
                   catch(Exception ex)
                           {
                           out.println("<h3 style=color:red;>Server is experiencing some problem!! Try again later......</h3>"+ex);
                           
                           }
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

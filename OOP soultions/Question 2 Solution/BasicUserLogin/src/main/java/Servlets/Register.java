/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DAO.UserDAO;
import PasswordEncryption.ProtectUserPassword;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;

/**
 *
 * @author ahnaf
 */
public class Register extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */

            boolean emailFlag = false, passFlag = false;

            UserDAO db = new UserDAO();
            HttpSession session = request.getSession();

            String email = request.getParameter("email");

            String newPassword = request.getParameter("newPassword");
            String confirmPassword = request.getParameter("confirmPassword");
            String salt = "";
            String securePassword = "";

            if (!db.checkAvailableEmail(email)) {

                if (email == "" || email == null) {
                    out.println("<font color=red><b>" + email + "</b> Email id is required!</font>");
                    emailFlag = false;
                } else if (db.isValid(email)) {

                    out.println("<font color=green><b>" + email + "</b> is avaliable</font>");
                    emailFlag = true;

                } else {
                    out.println("<font color=red><b>" + email + "</b> is an invalid email!</font>");
                    emailFlag = false;
                }
            } else {
                out.println("<font color=red><b>" + email + "</b> is already in use</font>");
                emailFlag = false;
            }

            if (confirmPassword.equals(newPassword) && newPassword != "") {

                //out.println("cAme!");
                passFlag = true;

                ProtectUserPassword pup = new ProtectUserPassword();
                salt = pup.getSaltValue();
                securePassword = pup.getSecurePassword(newPassword, salt);

            } else {
                request.setAttribute("wrongPassword", "Password Doesn't match! Please try again! ");
                RequestDispatcher rd = request.getRequestDispatcher("RegisterUser.jsp");
                rd.forward(request, response);
            }
            
            
            //all field correct , regiter user and handover to userprofile
            if (emailFlag == true && passFlag == true) {

                User user = new User(email, securePassword, salt);

                db.insertUser(user, out);
                request.setAttribute("LoginSuccess", email+"("+"Registration Success!"+")");
                RequestDispatcher rd = request.getRequestDispatcher("UserProfile.jsp");
                rd.forward(request, response);

            } else {//registration failed , handover to register again
                out.println("<font color=red> Insert failed!</font>");
                request.setAttribute("failedRegister", "All fields including valid email is required for registration!");
                RequestDispatcher rd = request.getRequestDispatcher("RegisterUser.jsp");
                rd.forward(request, response);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import loc.dao.UserDAO;
import loc.dto.UserDTO;
import loc.dto.UserErrorDTO;

/**
 *
 * @author TungLoc
 */
public class CreateAccountServlet extends HttpServlet {

    private static final String SUCCESS = "login.html";
    private static final String ERROR = "createNewAccount.jsp";

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
        String url = ERROR;
        UserErrorDTO errorDTO = new UserErrorDTO();
        try {
            String userID = request.getParameter("txtUsername");
            String fullname = request.getParameter("txtFullname");
            String address = request.getParameter("txtAddress");
            String phone = request.getParameter("txtPhone");
            String password = request.getParameter("txtPassword");
            String repassword = request.getParameter("txtRePassword");
            boolean check = false;

            if (userID.trim().length() < 4 || userID.trim().length() > 20) {
                check = true;
                errorDTO.setUserIDError("Username is required from 4 to 20 characters");
            }
            if (fullname.trim().length() < 2 || fullname.trim().length() > 40) {
                check = true;
                errorDTO.setFullnameError("Fullname is required from 2 to 40 characters");
            }
            if (password.trim().length() < 3 || password.trim().length() > 20) {
                check = true;
                errorDTO.setPasswordError("Password is required from 3 to 20 characters");
            } else if (!password.trim().equals(repassword.trim())) {
                check = true;
                errorDTO.setRePasswordError("Repassword must be matched password");
            }

            if (check) {
                request.setAttribute("ERROR", errorDTO);
            } else {
                UserDTO dto = new UserDTO(userID, password, fullname, address, phone, "US");
                UserDAO dao = new UserDAO();
                boolean result = dao.createAccount(dto);
                if (result){
                    url = SUCCESS;
                }
            }
        } catch (NamingException e) {
            log("Error at CreateController:" + e.toString());
        } catch (SQLException e) {
            String msg = e.getMessage();
            log("Error at CreateController" + msg);
            if (msg.contains("duplicate")){
                errorDTO.setUserIDError("Username is existed");
                request.setAttribute("ERROR", errorDTO);
            }
            
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import loc.dao.BookDAO;
import loc.dto.BookDTO;
import loc.dto.UserDTO;

/**
 *
 * @author TungLoc
 */
public class SearchServlet extends HttpServlet {

    private static final String SUCCESS = "adminpage.jsp";
    private static final String SUCCESS_FOR_USER = "userpage.jsp";
    private static final String ERROR = "invalid.jsp";

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
        try {
            String searchValue = request.getParameter("txtSearch");
            BookDAO dao = new BookDAO();
            HttpSession session = request.getSession();
            UserDTO userDTO = (UserDTO) session.getAttribute("LOGIN");

            if (userDTO.getRole().equals("Admin")) {
                List<BookDTO> list = dao.getListBook(searchValue);
                if (list != null) {
                    url = SUCCESS;
                    request.setAttribute("LIST_BOOK", list);
                }
            }
            else if (userDTO.getRole().equals("User")){
                List<BookDTO> list = dao.getListBookForUser(searchValue);
                if (list != null) {
                    url = SUCCESS_FOR_USER;
                    request.setAttribute("LIST_BOOK", list);
                }
            }
        } catch (NamingException | SQLException e) {
            log("Error at SearchServlet " + e.toString());
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

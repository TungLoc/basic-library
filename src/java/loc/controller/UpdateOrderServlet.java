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
import loc.dto.CartDTO;

/**
 *
 * @author TungLoc
 */
public class UpdateOrderServlet extends HttpServlet {

    private static final String SUCCESS = "view.jsp";
    private static final String ERORR = "invalid.jsp";

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
        String url = ERORR;
        try {
            String id = request.getParameter("txtBookID");
            String quantity = request.getParameter("txtQuantity");
            BookDTO book = null;
            HttpSession session = request.getSession();
            CartDTO cart = (CartDTO) session.getAttribute("CART");

            if (cart == null) {
                cart = new CartDTO();
            }
            if (Integer.parseInt(quantity) > 0) {
                for (BookDTO dto : cart.getCart().values()) {
                    if (dto.getBookID().equals(id)) {
                        book = new BookDTO(dto.getBookID(), dto.getBookname(), Integer.parseInt(quantity), dto.getPrice(), dto.getAuthor(), dto.getUrl());
                    }
                }
                cart.update(id, book);
                session.setAttribute("CART", cart);
            }
            else{
                request.setAttribute("QUANTITY", "Quantity is a positive number");
            }
            url = SUCCESS;
        } catch (NumberFormatException e) {
            log("Error at UpdateOrderServlet " + e.toString());
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

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
import loc.dao.BookDAO;
import loc.dto.BookDTO;
import loc.dto.BookErrorDTO;
import loc.utils.DBUtils;

/**
 *
 * @author TungLoc
 */
public class UpdateServlet extends HttpServlet {

    private static final String SUCCESS = "SearchServlet";
    private static final String ERROR = "update.jsp";

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
        BookErrorDTO errorDTO = new BookErrorDTO();
        try {
            String bookID = request.getParameter("txtBookID");
            String bookname = request.getParameter("txtBookname");
            String author = request.getParameter("txtAuthor");
            String quantity = request.getParameter("txtQuantity");
            String price = request.getParameter("txtPrice");
            String image = request.getParameter("txtUrl");
            String chkbox = request.getParameter("chkAvailable");
            boolean status = false;
            boolean check = false;

            if (chkbox != null) {
                if (chkbox.equals("ON")) {
                    status = true;
                }
            }
            if (bookname.trim().isEmpty()) {
                check = true;
                errorDTO.setBookNameError("Bookname is not empty");
            }
            if (author.trim().isEmpty()) {
                check = true;
                errorDTO.setAuthorError("Author is not empty");
            }
            if (quantity.trim().isEmpty()) {
                check = true;
                errorDTO.setQuantityError("Quantity is not empty");
            }
            if (price.trim().isEmpty()) {
                check = true;
                errorDTO.setPriceError("Price is not empty");
            }

            if (check) {
                request.setAttribute("ERROR_BOOK", errorDTO);
            } else {
                if (DBUtils.checkFormat(quantity.trim(), "^[0-9]{1,9}$")) {
                    check = true;
                    errorDTO.setQuantityError("Quantity is a number");
                }
                if (DBUtils.checkFormat(price.trim(), "^[0-9\\.]{1,9}$")) {
                    check = true;
                    errorDTO.setPriceError("Price is a possitive number");
                }

                if (check) {
                    request.setAttribute("ERROR_BOOK", errorDTO);
                } else {
                    BookDTO dto = new BookDTO(bookID, bookname, Integer.parseInt(quantity), Double.parseDouble(price), author, status, image);
                    BookDAO dao = new BookDAO();
                    boolean result = dao.updateBook(dto);
                    if (result) {
                        url = SUCCESS;
                    }
                }
            }
        } catch (NamingException | SQLException | NumberFormatException e) {
            log("Error at UpdateServlet " + e.toString());
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

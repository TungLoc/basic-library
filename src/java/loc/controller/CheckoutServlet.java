/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loc.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import loc.dao.BookDAO;
import loc.dao.OrderDAO;
import loc.dto.BookDTO;
import loc.dto.CartDTO;
import loc.dto.OrderDTO;
import loc.dto.UserDTO;
import loc.utils.DBUtils;

/**
 *
 * @author TungLoc
 */
public class CheckoutServlet extends HttpServlet {

    private static final String SUCCESS = "SearchServlet";
    private static final String ERROR = "view.jsp";

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
            String total = request.getParameter("txtTotal");
            OrderDAO orderDAO = new OrderDAO();
            BookDAO bookDAO = new BookDAO();
            long getDate = System.currentTimeMillis();
            long returnDate = getDate + 1209600000;
            java.sql.Date date = new java.sql.Date(getDate);
            java.sql.Date date2 = new java.sql.Date(returnDate);
            String orderID = DBUtils.randomAlphaNumeric(10);
            String errorBook = "";
            boolean check3 = false;

            HttpSession session = request.getSession();
            UserDTO user = (UserDTO) session.getAttribute("LOGIN");
            CartDTO cart = (CartDTO) session.getAttribute("CART");
            OrderDTO orderDTO = new OrderDTO(orderID, user.getUserID(), date, date2, Double.parseDouble(total));
            Map<String, BookDTO> items = cart.getCart();

            for (BookDTO bookDTO : cart.getCart().values()) {
                int checkQuantity = bookDAO.checkQuantity(bookDTO.getBookID());
                BookDTO dto = bookDAO.getBook(bookDTO.getBookID());
                if (checkQuantity >= bookDTO.getQuantity()) {
                } else {
                    errorBook = "Quantity of " + bookDTO.getBookname() + " is too much, please choose quantity base on our's product quantity: " + dto.getQuantity();
                }
                request.setAttribute("MESSAGE", errorBook);
            }
            String msg = (String) request.getAttribute("MESSAGE");
            if (msg == null || msg.isEmpty()) {
                if (!items.isEmpty()) {
                    boolean check = orderDAO.insertOrder(orderDTO);
                    if (check) {
                        boolean check2 = orderDAO.checkoutOrder(orderID, items);
                        if (check2) {
                            for (BookDTO bookDTO : cart.getCart().values()) {
                                BookDTO dto = bookDAO.getBook(bookDTO.getBookID());
                                check3 = bookDAO.updateQuantity(dto.getQuantity() - bookDTO.getQuantity(), bookDTO.getBookID());
                            }
                            if (check3) {
                                url = SUCCESS;
                                session.removeAttribute("CART");
                            }
                        }
                    }
                }
                else {
                    request.setAttribute("MESSAGE", "Cart is not product to checkout");
                }
            }
        } catch (NamingException | NumberFormatException | SQLException e) {
            log("Error at CheckoutServlet " + e.toString());
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

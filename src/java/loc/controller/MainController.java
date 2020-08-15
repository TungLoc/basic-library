/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author TungLoc
 */
public class MainController extends HttpServlet {

    private static final String LOGIN = "LoginServlet";
    private static final String ERROR = "invalid.jsp";
    private static final String LOGOUT = "LogoutServlet";
    private static final String CREATE = "CreateAccountServlet";
    private static final String SEARCH = "SearchServlet";
    private static final String DELETE_BOOK = "DeleletBookServlet";
    private static final String UPDATE_PAGE = "update.jsp";
    private static final String UPDATE = "UpdateServlet";
    private static final String CREATE_BOOK = "CreateBookServlet";
    private static final String BORROW_BOOK = "BorrowBookServlet";
    private static final String VIEW = "view.jsp";
    private static final String DELETE_ORDER = "DeleletOrderServlet";
    private static final String UPDATE_ORDER = "UpdateOrderServlet";
    private static final String CHECKOUT = "CheckoutServlet";

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
        String btn = request.getParameter("btnAction");
        String url = ERROR;
        try {
            if (btn.equals("Login")) {
                url = LOGIN;
            }
            else if (btn.equals("Logout")) {
                url = LOGOUT;
            }
            else if (btn.equals("Create")) {
                url = CREATE;
            }
            else if (btn.equals("Search")) {
                url = SEARCH;
            }
            else if (btn.equals("Delete")) {
                url = DELETE_BOOK;
            }
            else if (btn.equals("Update")) {
                url = UPDATE_PAGE;
            }
            else if (btn.equals("Update Book")) {
                url = UPDATE;
            }
            else if (btn.equals("Create Book")) {
                url = CREATE_BOOK;
            }
            else if (btn.equals("Add to Cart")) {
                url = BORROW_BOOK;
            }
            else if (btn.equals("View")) {
                url = VIEW;
            }
            else if (btn.equals("Delete Order")) {
                url = DELETE_ORDER;
            }
            else if (btn.equals("Update Order")) {
                url = UPDATE_ORDER;
            }
            else if (btn.equals("Checkout")) {
                url = CHECKOUT;
            }
        } catch (Exception e) {
            log("Error at MC" + e.toString());
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

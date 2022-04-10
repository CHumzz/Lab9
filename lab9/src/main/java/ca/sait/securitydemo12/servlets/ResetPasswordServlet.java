package ca.sait.securitydemo12.servlets;

import ca.sait.securitydemo12.services.AccountService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cole
 */
public class ResetPasswordServlet extends HttpServlet {
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
        String uuid = request.getParameter("uuid");
        
        if (uuid != null){
            request.setAttribute("uuid", uuid);
            getServletContext().getRequestDispatcher("/WEB-INF/newResetPassword.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/reset.jsp").forward(request, response);
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
        String email = request.getParameter("email");
        String url = request.getRequestURI().toString();
        String message;
        String path = getServletContext().getRealPath("/WEB-INF");
        AccountService as = new AccountService();
        
        as.resetPassword(email, path, url);
        message = "If your email is valid, we will send you a link to reset your password. Please check your email for your request.";
        request.setAttribute("message", message);
        
        getServletContext().getRequestDispatcher("/WEB-INF/reset.jsp").forward(request, response);
    }
}

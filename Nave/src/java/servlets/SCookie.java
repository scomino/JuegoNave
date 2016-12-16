/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Entidades.CogarGames;
import Entidades.CogarUsers;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.GamesServices;
import services.UsersService;

/**
 *
 * @author sergi
 */
public class SCookie extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SCookie</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SCookie at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
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
       Cookie[] galletas = request.getCookies();
//        
        
          EntityManagerFactory emf = (EntityManagerFactory)getServletContext().getAttribute("emf");
  EntityManager em = emf.createEntityManager();
        
        
        CogarUsers usuario =  new CogarUsers();
        CogarGames partida =  new CogarGames();
        UsersService us = new UsersService(em);
        GamesServices gs = new GamesServices(em);
        
        try {
            for (int i = 0; i < galletas.length; i++) {
                if (us.findUser(galletas[i].getValue(),galletas[i+1].getValue())) {
                    usuario=us.copyUser(galletas[i].getValue(),galletas[i+1].getValue());
                    partida.setIdPlayer(usuario);
                    Date d = new Date();
                    partida.setPlayBegin(d);
                    gs.addUser(partida);
                    RequestDispatcher a = request.getRequestDispatcher("/jsp/index.jsp");
                    a.forward(request, response);
                }
            }
                    RequestDispatcher a = request.getRequestDispatcher("/jsp/login.jsp");
                    a.forward(request, response);
                    
        } catch (Exception e) {
            RequestDispatcher a = request.getRequestDispatcher("/jsp/login.jsp");
            a.forward(request, response);

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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Entidades.CogarGames;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.GamesServices;

/**
 *
 * @author sergi
 */
public class SFecha extends HttpServlet {

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
            out.println("<title>Servlet SFecha</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SFecha at " + request.getContextPath() + "</h1>");
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
       Date d = new Date();
     EntityManagerFactory emf = (EntityManagerFactory)getServletContext().getAttribute("emf");
     EntityManager em = emf.createEntityManager();
  
        GamesServices gs= new GamesServices(em);
        CogarGames cg= new CogarGames();
        CogarGames cg2= new CogarGames();
        cg2=gs.lastPlay();
        cg.setIdPlayer(cg2.getIdPlayer());
        cg.setPlayBegin(d);
        gs.addUser(cg);
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
          EntityManagerFactory emf = (EntityManagerFactory)getServletContext().getAttribute("emf");
  EntityManager em = emf.createEntityManager();
        GamesServices gs= new GamesServices(em);
        int sco=54;
        Date d =new Date();
    try {
            // GUARDAMOS Y ENVIAMOS AL SERVIDOR LOS RESULTADOS, METEMOS LOS OBJETOS...
            //Integer speed2 = Integer.parseInt(request.getParameter("speed"));
            float speed = Float.parseFloat(request.getParameter("speed"));
            float speed2=(speed*(-100));
            sco=(int)speed2;
            gs.addFullGame(sco, d);

        } catch (Exception e) {
            e.printStackTrace();
        }
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

<%-- 
    Document   : menu
    Created on : 28-nov-2016, 17:58:05
    Author     : sergi
--%>

<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="services.GamesServices"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Entidades.CogarGames"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    List<CogarGames> rs = (List) request.getAttribute("listado");
    List<CogarGames> lo = (List) request.getAttribute("listado2");
%>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;">
        <title>Puntuaciones</title>
        <link rel="stylesheet" href="css/estilo.css">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
        <script src="js/cambiarPestanna.js"></script>


    </head>
    <body onload="javascript:cambiarPestanna(pestanas, pestana1);">
        <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
        <div class="contenedor">
            <div class="titulo">Estadísticas</div>
            <div id="pestanas">
                <ul id=lista>
                    <li id="pestana1"><a href='javascript:cambiarPestanna(pestanas,pestana1);'>TOP 5 Puntuaciones</a></li>
                    <li id="pestana2"><a href='javascript:cambiarPestanna(pestanas,pestana2);'>ULTIMAS CONEXIONES</a></li>
                </ul>
            </div>
            


            <div id="contenidopestanas">
                <div id="cpestana1">
                    <%
                        EntityManagerFactory emf = Persistence.createEntityManagerFactory("NavePU");
                        EntityManager em = emf.createEntityManager();
                        GamesServices ps = new GamesServices(em);
                        out.println("<p>TOP 5</p>");
                        out.println("<p>(cuanto menos mejor :) )</p>");
                        for (int i = 0; i < rs.size(); i++) {
                            out.println("<p>" + rs.get(i).getIdPlayer().getNick() + "     " + rs.get(i).getScore() + "</p>");

                        }

                    %>
                </div>
                <div id="cpestana2">
                    <%                    
                        
                        out.println("<p>REGISTRO DE CONEXIONES</p>");
                        for (int i = 0; i < lo.size(); i++) {
                            out.println("<p>" + lo.get(i).getIdPlayer().getNick() + "     " + lo.get(i).getPlayEnd() + "</p>");
                            
                        }
                    %>
                </div>
                <div id="cpestana3">
                </div>
            </div>
             <form action="SCookie" method="GET"><input class="boton" type="submit" value="volver a jugar" />
        </div>
                 
    </body>
</html>

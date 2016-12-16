<%-- 
    Document   : login
    Created on : 22-nov-2016, 11:31:48
    Author     : sergi
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina de Login/Registro</title>
        <link rel="stylesheet" href="css/style.css">
    </head>

    <body>
        <div id="state2">
            <div class="container">
                <form id="login" action="SLogin" method="post">
                    <h1>Iniciar sesion</h1>
                    <input type="text" name="realname"  placeholder="Nombre de usuario" />
                    <input type="password" name="mypassword"  placeholder="Contraseña" />
                    <input  class="boton" type="submit" value="Iniciar sesion" />
                </form>
 
                <form id="registrarse" action="SRegistro" method="POST">
                    <h1>Registrarse</h1>
                  <input type="text" name="realname2"  placeholder="Nombre de usuario"/>
                  <input type="password" name="mypassword2"  placeholder="Contraseña"/>
                  <input class="boton"    type="submit" value="Registrarse" />
                </form>              
            </div>
        </div>
    </body>
</html>

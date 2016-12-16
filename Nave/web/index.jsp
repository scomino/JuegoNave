<%-- 
    Document   : index
    Created on : 11-dic-2016, 17:04:41
    Author     : sergi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
   
    </head>
    <body onload='redirect()'>


      <script>
        function redirect(){
            window.location="${pageContext.request.contextPath}/SCookie";           
        }       
        </script>
    </body>
</html>
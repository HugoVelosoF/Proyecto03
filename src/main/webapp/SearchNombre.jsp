<%-- 
    Document   : SearchNombre
    Created on : 01-10-2023, 21:12:55
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="ServletSearchNombre" method="POST">
            <input type="text" id="nombre" name="nombre">
            <button type="submit">
                Buscar
            </button>
        </form>
        ${respuesta}
    </body>
</html>

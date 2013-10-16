<%-- 
    Document   : login
    Created on : 15/10/2013, 13:32:07
    Author     : Zanella
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <form action="/ControladorUsuario">
            Username: <input type="text" name="name" id="name"></br>
            Password: <input type="password" name="password" id="password">
            <input type="hiden" id="evento" name="evento" value="login">
        </form>
    </body>
</html>

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
		<style media="screen" type="text/css">
			body {padding:40px; text-align: center}
			hr {margin-bottom: 40px}
			a {text-decoration:none; font-size:30px; color: #1D29D1}
			a:hover{color:#1E0A6E}
			h1{font-size: 35px}
		</style>
    </head>
    <body>
        <h1>Sistema de Matrículas do INF</h1>
        <hr>
        <form action="ControladorConta" method="post">
            Username: <input type="text" size="14" name="name" id="name"></br>
            Password: <input type="password" size="15" name="password" id="password">
            <input type="hidden" id="evento" name="evento" value="login"><br>
            <input type="submit" name="ok" VALUE="Login">
        </form>
    </body>
</html>

<%-- 
    Document   : indexAluno
    Created on : 16/10/2013, 17:44:53
    Author     : Zanella
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IndexAluno</title>
		<style media="screen" type="text/css">
			body {padding:40px; text-align: center}
			hr {margin-bottom: 40px}
			a {text-decoration:none; font-size:25px; color: #1D29D1}
			a:hover{color:#1E0A6E}
			h1{font-size: 35px}
                        h3{font-size: 28px}
		</style>
    </head>
    <body>
       <h1>Sistema de Matrículas do INF</h1>
       <h3>Portal do Aluno</h3>
       <hr>
       <a href='ControladorConta?evento=possibilidadeMatricula'><p>Ver possibilidades de matrícula</p></a>
       <a><p>Visualizar resultado da encomenda</p></a>
       <a><p>Visualizar comprovante de matrícula</p></a>
       <a href='ControladorConta?evento=imprimirHistorico'><p>Visualizar histórico escolar</p></a>
    </body>
</html>
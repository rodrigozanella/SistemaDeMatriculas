<%-- 
    Document   : detalharAluno
    Created on : 24/11/2013, 11:15:52
    Author     : Zanella
--%>

<%@page import="Model.Persistence.DAOs.UsuarioDAO"%>
<%@page import="Model.Logic.Aluno"%>
<%@page import="Model.Persistence.DAOs.AlunoDAO"%>
<%@page import="Model.Persistence.FactoryDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema de Matrícula</title>
		<style media="screen" type="text/css">
			body {padding:70px; text-align: center}
			hr {margin-bottom: 40px}
			a {text-decoration:none; font-size:30px; color: #1D29D1}
			a:hover{color:#1E0A6E}
			h1{font-size: 35px}
		</style>
    </head>
    <body>
        <h1>Detalhar Aluno</h1>
        <%
        String cpfAluno = request.getParameter("cpfAluno"); 
        FactoryDAO factory = new FactoryDAO();
        UsuarioDAO usuarioDAO = factory.criarUsuarioDAO();
        Aluno novoAluno = (Aluno) usuarioDAO.getUsuario(cpfAluno);
        
        %>
    </body>
</html>

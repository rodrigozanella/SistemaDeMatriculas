<%-- 
    Document   : turmasAnteriores
    Created on : 23/11/2013, 23:01:30
    Author     : Zanella
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Model.Logic.Turma"%>
<%@page import="Model.Logic.Professor"%>
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
        <h1>Turmas Anteriores</h1>
        <%
        List<Turma> turmas = (List<Turma>) session.getAttribute("turmas");
        Iterator<Turma> itTurma = turmas.iterator();
        while(itTurma.hasNext()){
            Turma novaTurma = itTurma.next();
            out.println("<a href=detalharTurma.jsp?id="+
                    novaTurma.getCodigo()+"><p>"+novaTurma.getCodigoDisciplina()
                    +" - "+novaTurma.getSemestre()+"</p></a>");
        }
        session.removeAttribute("turmas");
        %>
    </body>
</html>

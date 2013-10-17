<%-- 
    Document   : possibilidadesMatricula
    Created on : 17/10/2013, 03:32:54
    Author     : Zanella
--%>

<%@page import="java.util.Iterator"%>
<%@page import="Model.Logic.Turma"%>
<%@page import="java.util.List"%>
<%@page import="Model.Logic.Aluno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Possibilidades de Matrícula</title>
    </head>
    <body>
        <form action="ControladorContas">
            <input type="hidden" value="encomenda" name="evento" id="evento">
            <%
                List<Turma> lista = (List<Turma>) application.getAttribute("lista");
                Iterator<Turma> itLista = lista.iterator();
                while(itLista.hasNext()){
                    out.println(itLista.next().getCodigoDisciplina());
                }
            %>
            <input type="submit" name="ok" VALUE="Encomendar Matrícula">
        </form>
    </body>
</html>

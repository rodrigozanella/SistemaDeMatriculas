
<%@page import="Model.Persistence.DAOs.UsuarioDAO"%>
<%@page import="Model.Logic.Professor"%>
<%@page import="Model.Logic.Usuario"%>
<%@page import="java.util.Queue"%>
<%@page import="java.util.TreeMap"%>
<%@page import="Model.Logic.Disciplina"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Persistence.DAOs.DisciplinaDAO"%>
<%@page import="Model.Persistence.FactoryDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informações dos professores</title>
        <style media="screen" type="text/css">
            body {padding:15px; text-align: center}
            hr {margin-bottom: 25px}
            table{
                  padding: 2px;
                  text-align: center;
                  font-size: 22px;
                  border:0;
            }
	</style>
    </head>
    <body>
        <h1 style="font-size: 35px; font-family:Times New Roman;">Sistema de Matrículas do INF</h1>
        <hr>
        
        <h1>Informações dos professores</h1>
        <%
            //Obtém lista dos professores cadastrados
            FactoryDAO factoryDAO = new FactoryDAO();
            UsuarioDAO usuarioDAO = factoryDAO.criarUsuarioDAO();
            ArrayList<Professor> professores = usuarioDAO.getProfessores();
            
            //Imprime cabeçalhos da tabela
            out.println("<table cellspacing=\"10\">");
            out.println("<tr>");
            out.println("<th>Nome</th>");
            out.println("<th>Email</th>");
            out.println("<th>Area de interesse</th>");
            out.println("</tr>");
            
            //Imprime informações dos professores
            for(Professor professor : professores){
                out.println("<tr>");
                out.println("<td>" + professor.getNome() + "</td>");
                out.println("<td>" + professor.getEmail() + "</td>");
                if(professor.getAreaDeInteresse() == null) out.println("<td></td>");
                else out.println("<td>" + professor.getAreaDeInteresse() + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");            
        %>
    </body>
</html>

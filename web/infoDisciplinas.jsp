
<%@page import="Model.Persistence.DAOs.DisciplinaDAO"%>
<%@page import="java.util.Queue"%>
<%@page import="java.util.TreeMap"%>
<%@page import="Model.Logic.Disciplina"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Persistence.FactoryDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informações das disciplinas</title>
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
        
        <h1>Informações das disciplinas</h1>
        <%
            //Obtém lista das disciplinas cadastradas
            FactoryDAO factoryDAO = new FactoryDAO();
            DisciplinaDAO disciplinaDAO = factoryDAO.criarDisciplinaDAO();
            ArrayList<Disciplina> disciplinas = disciplinaDAO.getDisciplinas();
            
            //Imprime cabeçalhos da tabela
            out.println("<table cellspacing=\"10\">");
            out.println("<tr>");
            out.println("<th>Codigo</th>");
            out.println("<th>Nome</th>");
            out.println("<th>Nr. de créditos</th>");
            out.println("<th>Eletiva</th>");
            out.println("<th>Nr. créditos mínimos</th>");
            out.println("<th>Pré-requisitos</th>");
            out.println("</tr>");
            
            //Imprime informações das disciplinas
            for(Disciplina disciplina : disciplinas){
                out.println("<tr>");
                out.println("<td>" + disciplina.getCodigo() + "</td>");
                out.println("<td>" + disciplina.getNome() + "</td>");
                out.println("<td>" + disciplina.getNumeroDeCreditos() + "</td>");
                out.println("<td>");
                if(disciplina.isEletiva()) out.println("Sim");
                else out.println("Não");
                out.println("</td>");
                out.println("<td>" + disciplina.getNumeroDeCreditosMinimos() + "</td>");
                String codigoPreRequisitos = "";
                for(String preRequisito : disciplina.getPreRequisitos()){
                    codigoPreRequisitos += preRequisito + " ";
                }
                out.println("<td>" + codigoPreRequisitos + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");            
        %>
    </body>
</html>

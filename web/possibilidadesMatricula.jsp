<%-- 
    Document   : possibilidadesMatricula
    Created on : 17/10/2013, 03:32:54
    Author     : Rodrigo Zanella Ribeiro
--%>

<%@page import="Model.Persistence.DAOs.DisciplinaDAO"%>
<%@page import="Model.Logic.Disciplina"%>
<%@page import="Model.Persistence.FactoryDAO"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Iterator"%>
<%@page import="Model.Logic.Turma"%>
<%@page import="Model.Logic.Aluno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Possibilidades de Matrícula</title>
		<style media="screen" type="text/css">
			body{
                            padding: 40px;
                            text-align: center;
                        }
			hr{
                            margin-bottom: 40px;
                        }
			h1{
                            font-size: 35px;
                        }
                        h3{
                            font-size: 28px;
                        }
                        div{
                            text-align: center;
                        }
                        table{
                            padding: 2px;
                            text-align: center;
                            font-size: 22px;
                            border: 0;
                        }
                        button{
                            width: 160px;
                            height: 80px;
                            background: #666666;
                            text-align: center;
                            color: #FFFFFF;
                            font-size: 18px;
                            font-weight: bold;
                        }
		</style>
    </head>
    <body>
        <h1>Sistema de Matrículas do INF</h1>
        <hr>
        <h3>Encomenda de matricula</h3>
        <div>
        <form id="form" name="form" method="post" action="ControladorContext">
            <input type="hidden" value="encomendarMatricula" name="evento" id="evento">
            <%
                //Obtém a instância do aluno logado
                Aluno aluno = (Aluno) session.getAttribute("usuario");
                
                //Obtém uma lista de turmas que o aluno pode se matricular
                Set<Turma> lista = aluno.getPossibilidadesMatricula();
               
                //Imprime cabeçalhos da tabela
                out.println("<table cellspacing=\"10\">");
                out.println("<tr>");
                out.println("<th>Disciplina</th>");
                out.println("<th>Créditos</th>");
                out.println("<th>Turma</th>");
                out.println("<th>Horario</th>");
                out.println("<th>Lance</th>");
                out.println("</tr>");
                
                //Para cada turma da lista, imprime suas informações
                FactoryDAO novaFactory = new FactoryDAO();
                DisciplinaDAO disciplinaDAO = novaFactory.criarDisciplinaDAO();
                for(Turma turma : lista){
                    Disciplina disciplina = disciplinaDAO.getDisciplina(turma.getCodigoDisciplina());
                    
                    out.println("<tr>");
                    out.print("<td>" + disciplina.getCodigo()+" - "+disciplina.getNome() + "</td>");
                    out.print("<td>" + disciplina.getNumeroDeCreditos() + "</td>");
                    out.print("<td>" + (char)turma.getCodigo() + "</td>");
                    out.print("<td>" + turma.getHorario() + "</td>");
                    out.print("<td>" + "<input type=\"text\" name=\"" + "l" + turma.getCodigoUnico() + "\" maxlength=\"5\" size=\"5\" />" + "</td>");
                    out.println("</tr>");
                }
                
                //Imprime botão que aciona o evento e encomenda
                out.println("<tr><td>");
                out.println("<button type=\"submit\">Encomendar Matrícula</button>");
                out.println("</td></tr>");
            %>
        </form>
        </div>
    </body>
</html>

<%-- 
    Document   : possibilidadesMatricula
    Created on : 17/10/2013, 03:32:54
    Author     : Zanella
--%>

<%@page import="Model.Persistence.DisciplinaDAO"%>
<%@page import="Model.Persistence.FactoryDAO"%>
<%@page import="Model.Logic.HistoricoEscolarElemento"%>
<%@page import="Model.Persistence.OperadorBD"%>
<%@page import="Model.Logic.Turma"%>
<%@page import="Model.Logic.HistoricoEscolar"%>
<%@page import="Model.Logic.Aluno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Possibilidades de Matrícula</title>
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
        <hr>
        <h3>Historico Escolar</h3>
        <div style="text-align: left">
        <form action="ControladorContas">
            <input type="hidden" value="encomenda" name="evento" id="evento">
            <%
                HistoricoEscolar historico = (HistoricoEscolar) application.getAttribute("historico");
                for(HistoricoEscolarElemento elemento : historico.getHistorico()){
                    out.println("<p>");
                    out.print(elemento.getTurma().getCodigoDisciplina()+" - ");
                    FactoryDAO novoFactory = new FactoryDAO();
                    DisciplinaDAO disciplinaDAO = novoFactory.criarDisciplinaDAO();
                    out.print(disciplinaDAO.getDisciplina(elemento.getTurma().getCodigoDisciplina()).getNome());
                    out.print("Turma "+elemento.getTurma().getCodigo()+" - ");
                    out.print("Horário: "+elemento.getTurma().getHorario()+" - ");
                    out.print("Semestre: "+elemento.getTurma().getSemestre()+" - ");
                    out.print("Professor: "+OperadorBD.getProfessor(elemento.getTurma().getCpfProfessor()));
                    out.println("</p>");
                    out.print("Conceito: "+elemento.getConceito());
                }
                application.removeAttribute("historico");
            %>
        </form>
        </div>>
    </body>
</html>

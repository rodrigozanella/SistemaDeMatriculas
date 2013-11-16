<%-- 
    Document   : possibilidadesMatricula
    Created on : 17/10/2013, 03:32:54
    Author     : Rodrigo Zanella Ribeiro
--%>

<%@page import="Model.Logic.Disciplina"%>
<%@page import="Model.Persistence.DisciplinaDAO"%>
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
        <h3>Encomenda de matricula</h3>
        <div style="text-align: left">
        <form action="ControladorContas">
            <input type="hidden" value="encomenda" name="evento" id="evento">
            <%
                Aluno aluno = (Aluno) session.getAttribute("usuario");
                Set<Turma> lista = aluno.getPossibilidadesMatricula();
                FactoryDAO novaFactory = new FactoryDAO();
                DisciplinaDAO disciplinaDAO = novaFactory.criarDisciplinaDAO();
                
                Iterator<Turma> itLista = lista.iterator();
                for(Turma turma : lista){
                    out.println("<p>");
                    out.print(turma.getCodigoDisciplina()+" - ");
                    
                    Disciplina disciplina =disciplinaDAO.getDisciplina(turma.getCodigoDisciplina());
                    out.print(disciplina.getNome()+" - ");
                    out.print("Turma "+turma.getCodigo()+" - ");
                    out.print("Horário: "+turma.getHorario()+" - ");
                    out.print("Semestre: "+turma.getSemestre()+" - ");
                    //out.print("Professor: "+OperadorBD.getProfessor(turma.getCpfProfessor()));
                    out.println("</p>");
                    out.print("Lance: " + "<input type=" + "text" + " name=" + "lance" + " maxlength=" + "20" + " size=" + "20" + " />");
                }
            %>
            <input type="submit" name="ok" VALUE="Encomendar Matrícula">
        </form>
        </div>
    </body>
</html>

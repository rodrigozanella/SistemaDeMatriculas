<%-- 
    Document   : detalharTurma
    Created on : 24/11/2013, 10:01:47
    Author     : Zanella
--%>

<%@page import="java.util.Iterator"%>
<%@page import="Model.Logic.Professor"%>
<%@page import="Model.Logic.Disciplina"%>
<%@page import="Model.Persistence.DAOs.DisciplinaDAO"%>
<%@page import="Model.Persistence.DAOs.UsuarioDAO"%>
<%@page import="Model.Logic.Turma"%>
<%@page import="Model.Logic.Aluno"%>
<%@page import="java.util.Set"%>
<%@page import="Model.Persistence.DAOs.TurmaDAO"%>
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
        <h1>Detalhar Turma</h1>
        <%
        Integer id = Integer.valueOf(request.getParameter("id"));
        FactoryDAO factory = new FactoryDAO();
        TurmaDAO turmaDAO = factory.criarTurmaDAO();
        Set<Aluno> alunos = turmaDAO.getAlunos(id);
        Turma turma = turmaDAO.getTurma(id);
        UsuarioDAO usuarioDAO = factory.criarUsuarioDAO();
        DisciplinaDAO disciplinaDAO = factory.criarDisciplinaDAO();
        
        
        out.println("<table cellspacing=\"10\">");
        out.println("<tr>");
        out.println("<th>Codigo da Turma</th>");
        out.println("<th>Nome da Disciplina</th>");
        out.println("<th>Nome do Professor</th>");
        out.println("<th>Semestre</th>");
        out.println("<th>Alunos</th>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<th>"+turma.getCodigo()+"</th>");
        Disciplina novaDisciplina = disciplinaDAO.getDisciplina(turma.getCodigoDisciplina());
        out.println("<th>"+novaDisciplina.getCodigo()+" - "+novaDisciplina.getNome()+"</th>");
        Professor novoProf = (Professor) usuarioDAO.getUsuario(turma.getCpfProfessor());
        out.println("<th>"+novoProf.getNome()+"</th>");
        out.println("<th>"+turma.getSemestre()+"</th>");
        Iterator<Aluno> itAluno = alunos.iterator();
        out.println("<th>");
                while(itAluno.hasNext()){
                    Aluno novoAluno = itAluno.next();
                    out.println("<a href=detalharAluno.jsp?cpfAluno="+novoAluno.getCpf()+">"
                            + novoAluno.getNome()+"</a>");
                }
        out.println("</th>");
        out.println("</tr>");
        
        %>
    </body>
</html>


<%@page import="Model.Logic.Usuario"%>
<%@page import="Model.Persistence.DAOs.DisciplinaDAO"%>
<%@page import="Model.Persistence.DAOs.UsuarioDAO"%>
<%@page import="Model.Logic.Disciplina"%>
<%@page import="Model.Persistence.FactoryDAO"%>
<%@page import="Model.Logic.HistoricoEscolarElemento"%>
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
        <form action="ControladorContext">
            <input type="hidden" value="encomenda" name="evento" id="evento">
            <%
                HistoricoEscolar historico = (HistoricoEscolar) session.getAttribute("historico");
                for(HistoricoEscolarElemento elemento : historico.getHistorico()){
                    out.println("<p>");
                    out.print(elemento.getTurma().getCodigoDisciplina()+" - ");
                    FactoryDAO novoFactory = new FactoryDAO();
                    DisciplinaDAO disciplinaDAO = novoFactory.criarDisciplinaDAO();
                    String codigoDaDisciplina = elemento.getTurma().getCodigoDisciplina();
                    Disciplina novaDisciplina = disciplinaDAO.getDisciplina(codigoDaDisciplina);
                    out.print(novaDisciplina.getNome());
                    out.print("Turma "+elemento.getTurma().getCodigo()+" - ");
                    out.print("Horário: "+elemento.getTurma().getHorario()+" - ");
                    out.print("Semestre: "+elemento.getTurma().getSemestre()+" - ");
                    UsuarioDAO usuarioDAO = novoFactory.criarUsuarioDAO();
                    Usuario novoUsuario = usuarioDAO.getUsuario(elemento.getTurma().getCpfProfessor());
                    out.print("Professor: "+novoUsuario.getNome());
                    out.println("</p>");
                    out.print("Conceito: "+elemento.getConceito());
                }
                application.removeAttribute("historico");
            %>
        </form>
        </div>>
    </body>
</html>

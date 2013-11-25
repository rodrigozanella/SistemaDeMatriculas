
<%@page import="javax.persistence.Convert"%>
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
                        table{
                            padding: 2px;
                            text-align: center;
                            font-size: 18px;
                            border:0;
                        }
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
                //Imprime cabeçalhos da tabela
                out.println("<table cellspacing=\"10\">");
                out.println("<tr>");
                out.println("<th>Codigo</th>");
                out.println("<th>Nome</th>");
                out.println("<th>Nr. de créditos</th>");
                out.println("<th>Eletiva</th>");
                out.println("<th>Turma</th>");
                out.println("<th>Professor</th>");
                out.println("<th>Semestre</th>");
                out.println("<th>Conceito</th>");
                out.println("</tr>");
            
                //Imprime disciplinas cursadas
                HistoricoEscolar historico = (HistoricoEscolar) session.getAttribute("historico");
                FactoryDAO novoFactory = new FactoryDAO();
                DisciplinaDAO disciplinaDAO = novoFactory.criarDisciplinaDAO();
                UsuarioDAO usuarioDAO = novoFactory.criarUsuarioDAO();
                for(HistoricoEscolarElemento elemento : historico.getHistorico()){
                    String codigoDaDisciplina = elemento.getTurma().getCodigoDisciplina();
                    Disciplina novaDisciplina = disciplinaDAO.getDisciplina(codigoDaDisciplina);
                    
                    out.println("<tr>");
                    out.print("<td>" + novaDisciplina.getCodigo() + "</td>");                    
                    out.print("<td>" + novaDisciplina.getNome() + "</td>");
                    out.print("<td>" + novaDisciplina.getNumeroDeCreditos() + "</td>");
                    if(novaDisciplina.isEletiva()) out.println("<td>Sim</td>");
                    else out.println("<td>Não</td>");
                    out.print("<td>" + (char)elemento.getTurma().getCodigo() + "</td>");
                    Usuario novoUsuario = usuarioDAO.getUsuario(elemento.getTurma().getCpfProfessor());
                    out.print("<td>" + novoUsuario.getNome() + "</td>");
                    out.print("<td>" + elemento.getTurma().getSemestre() + "</td>");
                    out.print("<td>" + elemento.getConceito() + "</td>");
                    out.println("</tr>");
                }
                out.println("</table>");
                application.removeAttribute("historico");
            %>
        </form>
        </div>
    </body>
</html>


<%@page import="Model.Persistence.DAOs.TurmaDAO"%>
<%@page import="Model.Logic.Lance"%>
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
        <title>Comprovante da matricula</title>
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
        <h3>Comprovante de matrícula</h3>
        <div>
            <input type="hidden" value="encomendaMatricula" name="evento" id="evento">
            <%
                //Obtém a instância do aluno logado
                Aluno aluno = (Aluno) session.getAttribute("usuario");
                
                //Obtém a lista de turmas do aluno
                Set<Turma> turmas = aluno.getTurmasMatriculadas();
               
                //Imprime cabeçalhos da tabela
                out.println("<table cellspacing=\"10\">");
                out.println("<tr>");
                out.println("<th>Disciplina</th>");
                out.println("<th>Créditos</th>");
                out.println("<th>Turma</th>");
                out.println("<th>Horario</th>");
                out.println("</tr>");
                
                //Para cada turma da lista, imprime suas informações
                FactoryDAO factory = new FactoryDAO();
                DisciplinaDAO disciplinaDAO = factory.criarDisciplinaDAO();
                TurmaDAO turmaDAO = factory.criarTurmaDAO();
                for(Turma turma : turmas){
                    Disciplina disciplina = disciplinaDAO.getDisciplina(turma.getCodigoDisciplina());
                    
                    out.println("<tr>");
                    out.print("<td>" + disciplina.getCodigo()+" - "+disciplina.getNome() + "</td>");
                    out.print("<td>" + disciplina.getNumeroDeCreditos() + "</td>");
                    out.print("<td>" + (char)turma.getCodigo() + "</td>");
                    out.print("<td>" + turma.getHorario() + "</td>");
                    out.println("</tr>");
                }
            %>
        </div>
    </body>
</html>

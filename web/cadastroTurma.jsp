<%@page import="Model.Persistence.DAOs.UsuarioDAO"%>
<%@page import="Model.Persistence.DAOs.DisciplinaDAO"%>
﻿<%@page import="Model.Logic.Professor"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Logic.Disciplina"%>
<%@page import="java.util.HashSet"%>
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
			body {padding:70px; text-align: center}
			hr {margin-bottom: 40px}
			a {text-decoration:none; font-size:25px; color: #1D29D1}
			a:hover{color:#1E0A6E}
                        
                        body{
                            font-family:"Lucida Grande", "Lucida Sans Unicode", Verdana, Arial, Helvetica, sans-serif;
                            font-size:12px;
                        }
                        p, h1, form, button{border:0; margin:0; padding:0;}
                        .spacer{clear:both; height:1px;}
                        .myform{
                            margin:0 auto;
                            width:400px;
                            padding:15px;
                        }
                        #stylized{
                            border:solid 2px #ddf2b7;
                            background:#f4fbeb;
                        }
                        #stylized h2 {
                            font-size:18px;
                            font-weight:bold;
                            margin-bottom:0px;
                        }
                        #stylized label{
                            float:left;
                            font-size:14px;
                            font-weight:bold;
                            text-align:right;
                            width:120px;
                            padding:1px 1px;
                            margin:0 0 2px 2px;
                        }
                        #stylized input{
                            float:left;
                            font-size:12px;
                            border:solid 1px #aacfe4;
                            width:200px;
                            padding:2px 2px;
                            margin:0 0 10px 10px;
                        }
                        #stylized button{
                            clear:both;
                            width:125px;
                            height:31px;
                            background:#666666;
                            text-align:center;
                            line-height:31px;
                            color:#FFFFFF;
                            font-size:14px;
                            font-weight:bold;
                            margin-top:10px;
                        }
		</style>
    </head>
    <body>
        <h1 style="font-size: 35px; font-family:Times New Roman;">Sistema de Matrículas do INF</h1>
        <hr>
            
        <div id="stylized" class="myform">
        <form id="form" name="form" method="post" action="ControladorContext">
        <h2>Formulário de cadastro de turma</h2>
        <hr>
        
        <div style="text-align: center;">
            <label>Professor</label>
            <%
                FactoryDAO factoryDAO = new FactoryDAO();
                UsuarioDAO usuarioDAO = factoryDAO.criarUsuarioDAO();
                ArrayList<Professor> professores = usuarioDAO.getProfessores();
                out.println("<select style=\"margin:0 0 10px 10px; width: 350px;\" size=\"10\" name=\"professor\" id=\"professor\">");
                for(Professor professor : professores){
                    out.println("<option value=\"" + professor.getCpf() + "\">" + professor.getNome() + "</option>");
                }
                out.println("</select>");
            %>
            <label>Disciplina</label>
            <%
                DisciplinaDAO disciplinaDAO = factoryDAO.criarDisciplinaDAO();
                ArrayList<Disciplina> disciplinas = disciplinaDAO.getDisciplinas();
                out.println("<select style=\"margin:0 0 10px 10px; width: 350px;\" size=\"10\" name=\"disciplina\" id=\"disciplina\">");
                for(Disciplina disciplina : disciplinas){
                    out.println("<option value=\"" + disciplina.getCodigo() + "\">" + disciplina.getCodigo()+" - "+disciplina.getNome() + "</option>");
                }
                out.println("</select>");
            %>
        </div>
            
        <label>Qtd. de Vagas</label>
        <input type="text" name="vagas" id="vagas" />
        <label>Semestre</label>
        <input type="text" name="semestre" id="semestre" value="20xx/x" />
        <label>Horário</label>
        <input type="text" name="horario" id="horario" />
            
        <button type="submit">Cadastrar</button>
        
        <input type="hidden" value="cadastrarTurma" name="evento" id="evento">
        <div class="spacer"></div>
        </form>
        </div>
    </body>
</html>

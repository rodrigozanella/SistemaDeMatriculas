<%@page import="java.util.HashSet"%>
<%@page import="Model.Persistence.DisciplinaDAO"%>
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
			hr {margin-bottom: 10px}
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
                            padding:14px;
                        }
                        #stylized{
                            border:solid 2px #b7ddf2;
                            background:#ebf4fb;
                        }
                        #stylized h1 {
                            font-size:14px;
                            font-weight:bold;
                            margin-bottom:8px;
                        }
                        #stylized label{
                            font-size:12px;
                            display:block;
                            font-weight:bold;
                            text-align:right;
                            width:140px;
                            float:left;
                        }
                        #stylized input{
                            float:left;
                            font-size:11px;
                            padding:4px 2px;
                            border:solid 1px #aacfe4;
                            width:200px;
                            margin:2px 0 10px 10px;
                        }
                        #stylized button{
                            clear:both;
                            margin-left:150px;
                            width:125px;
                            height:31px;
                            background:#666666;
                            text-align:center;
                            line-height:31px;
                            color:#FFFFFF;
                            font-size:14px;
                            font-weight:bold;
                        }
		</style>
    </head>
    <body>
        <h1 style="font-size: 35px; font-family:Times New Roman;" >Sistema de Matrículas do INF</h1>
        <hr>
        <div style="text-align: left">
            
        <div id="stylized" class="myform">
        <form id="form" name="form" method="post" action="ControladorContext">
        <h1>Formulário de cadastro de disciplina</h1>
        <hr>
        
        <label>Nome</label>
        <input type="text" name="nome" id="nome" />
        <label>Código</label>
        <input type="text" name="codigo" id="codigo" />
        <label>Número de créditos</label>
        <input type="text" name="creditos" id="creditos" />
        <label>Obrigatória</label><input style="width:20px;" type="radio" name="tipo" value="Obrigatória" checked>
        <label>Eletiva</label><input style="width:20px;" type="radio" name="tipo" value="Eletiva">
        <div style="text-align: center;">
        <label>Pré-requisitos</label>
        <%
            FactoryDAO novoFactoryDAO = new FactoryDAO();
            DisciplinaDAO novoDisciplinaDAO = novoFactoryDAO.criarDisciplinaDAO();
            HashSet<String> nomesDisciplinas = (HashSet)novoDisciplinaDAO.getNomesDisciplinas();
            out.println("<select size=\"10\" multiple>");
            for(String disciplina : nomesDisciplinas){
                out.println("<option value=\"" + disciplina.replace(' ', '_') + "\">" + disciplina + "</option>");
            }
            out.println("</select>");
        %>
        </div>
        
        <input type="hidden" value="cadastrarDisciplina" name="evento" id="evento">
        <button type="submit">Cadastrar</button>
        <div class="spacer"></div>

        </form>
        </div>
        </div>
    </body>
</html>

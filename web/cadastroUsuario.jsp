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
                        #stylized select{
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
        <h1>Formulário de cadastro de usuário</h1>
        <hr>

        <label>Tipo do usuário</label>
        <select name="tipo" id="tipo">
            <option selected value="aluno">aluno</option>
            <option value="professor">professor</option>
            <option value="administrador">administrador</option>
        </select>
        
        <label>Nome</label>
        <input type="text" name="nome" id="nome" />
        <label>Email</label>
        <input type="text" name="email" id="email" />
        <label>CPF</label>
        <input type="text" name="cpf" id="cpf" />
        <label>Data de nascimento</label>
        <input type="date" name="nascimento" id="nascimento" />        
        
        <label>Área de interesse</label>
        <input type="text" name="interesse" id="interesse" />
        <label>Método de ingresso</label>
        <input type="text" name="metodo" id="metodo" />
        <label>Pontuação no vestibular</label>
        <input type="text" name="vestibular" id="vestibular" />
        <label>Data de ingresso</label>
        <input type="date" name="ingresso" id="ingresso" />  
        <label>Número de matrícula</label>
        <input type="text" name="matricula" id="matricula" />
        
        <label>Nome de usuário</label>
        <input type="text" name="username" id="username" />
        <label>Senha</label>
        <input type="text" name="senha" id="senha" />
        
        <input type="hidden" value="cadastrarUsuario" name="evento" id="evento">
        <button type="submit">Cadastrar</button>
        <div class="spacer"></div>

        </form>
        </div>
        </div>
    </body>
</html>

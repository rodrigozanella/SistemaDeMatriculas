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
                            font-size:16px;
                            font-weight:bold;
                            margin-bottom:0px;
                        }
                        #stylized label{
                            float:left;
                            font-size:12px;
                            font-weight:bold;
                            text-align:right;
                            width:160px;
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
                        #stylized select{
                            float:left;
                            font-size:12px;
                            border:solid 1px #aacfe4;
                            width:200px;
                            padding:2px 2px;
                            margin:0 0 10px 10px;
                        }
                        #stylized button{
                            float: bottom;
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
        <h2>Formulário de cadastro de usuário</h2>
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
        <label>Semestre de ingresso</label>
        <input type="text" name="semestre" id="semestre" />  
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
    </body>
</html>

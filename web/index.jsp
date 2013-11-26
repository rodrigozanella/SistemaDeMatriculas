<%-- 
    Document   : index
    Created on : 11/10/2013, 22:35:48
    Author     : Zanella
--%>

<%@page import="Model.Persistence.DAOs.SistemaDAO"%>
<%@page import="Model.Persistence.FactoryDAO"%>
<%@page import="Model.Logic.Usuario"%>
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
        <h1>Sistema de Matrículas do INF</h1>
        <%
            Usuario umUsuario = (Usuario) session.getAttribute("usuario");
            if(umUsuario == null){
                out.println("<hr>");
                out.println("<a href="+"login.jsp"+">Login</a>");
            }
            else{
                String tipo = umUsuario.getRole();
                FactoryDAO factory = new FactoryDAO();
                SistemaDAO sistemaDAO = factory.criarSistemaDAO();
                String estadoSys = sistemaDAO.getEstado();
                if(tipo.equalsIgnoreCase("aluno")){
                    out.println("<h3>Portal do Aluno</h3>");
                    out.println("<hr>");
                    out.println("<a href='ControladorContext?evento=possibilidadeMatricula'><p>Ver possibilidades de matrícula</p></a>");
                    out.println("<a href='ControladorContext?evento=resultadoEncomenda'><p>Visualizar resultado da encomenda</p></a>");
                    out.println("<a><p>Visualizar comprovante de matrícula</p></a>");
                    out.println("<a href='ControladorContext?evento=imprimirHistorico'><p>Visualizar histórico escolar</p></a>");
                }
                if(tipo.equalsIgnoreCase("administrador")){
                    out.println("<h3>Portal do Administrador</h3>");
                    out.println("<hr>");
                    out.println("<a href=cadastroUsuario.jsp><p>Cadastrar usuário</p></a>");
                    out.println("<a href=cadastroTurma.jsp><p>Cadastrar turma</p></a>");
                    out.println("<a href=cadastroDisciplina.jsp><p>Cadastrar disciplina</p></a>");
                    if(estadoSys.equalsIgnoreCase("matricula")){
                        out.println("<a href='ControladorContext?evento=iniciarPeriodoLetivo'><p>Iniciar Período Letivo</p></a>");
                    }
                    if(estadoSys.equalsIgnoreCase("letivo")){
                        out.println("<a href='ControladorContext?evento=iniciarPeriodoFerias'><p>Iniciar Período de Férias</p></a>");
                    }
                    if(estadoSys.equalsIgnoreCase("ferias")){
                        out.println("<a href='ControladorContext?evento=iniciarPeriodoEncomenda'><p>Iniciar Encomenda de Matrículas</p></a>");
                    }
                }
                if(tipo.equalsIgnoreCase("professor")){
                    out.println("<h3>Portal do Professor</h3>");
                    out.println("<hr>");
                    out.println("<a href='ControladorContext?evento=visualizarTurmas'><p>Visualizar turmas</p></a>");
                    out.println("<a><p>Atribuir conceitos</p></a>");
                }
                
                out.println("<a href=ControladorContext?evento=logoff><p>Logoff</p></a>");
            }
            out.println("<a href=infoDisciplinas.jsp><p>Informações das disciplinas</p></a>");
            out.println("<a href=infoProfessores.jsp><p>Informações dos professores</p></a>");
        %>
    </body>
</html>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="model.Usuario"%>
<%Usuario user = (Usuario) request.getAttribute("usuarios");%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="utf-8">
	<title>Perfil</title>
	<link rel="shortcut icon" href="imagens/IF_Logo.ico" type="image/x-icon" />
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<%	String matricula = (String) session.getAttribute("matricula");
	if(matricula == null){
		response.sendRedirect("login.jsp");
	}
%>
	<header>
		<nav>
			<h1 class="logo">IFesta</h1>
			<ul class="nav-list">
				<li><a href="dashboard.jsp">Início</a></li>
				<li><a href="mainEvento">Eventos</a></li>
				<li><a href="mainMeusEventos">Meus Eventos</a></li>
				<li><a href="mainLembrete">Lembretes</a></li>
				<li><a href="main">Perfil</a></li>
				<li><a href="deslogar.jsp"><button class="botao">Logout</button></a></li>
			</ul>
		</nav>
	</header>
	<div class="perfil">
		<div class="perfil-superior">
			<div class="foto">
				<img src="imagens/perfil.png" title="Imagem de perfil">
			</div>
			<div class="infos">
				<h1>Perfil</h1>
				<h2>Matrícula: <%=user.getMatricula()%></h2>
				<h2>Nome: <%=user.getNome()%></h2>
				<h2>Email: <%=user.getEmail()%></h2>
				<h2>Telefone: <%=user.getTelefone()%></h2>
			</div>
		</div>
		<div class="perfil-inferior">
			<a href="select?matricula=<%=user.getMatricula()%>">
				<button class="botaoEditarPerfil">Editar perfil</button>
			</a> 
			<a href="javascript: confirmar('<%= session.getAttribute("matricula")%>')">
				<button class="botaoExcluirPerfil">Excluir perfil</button>
			</a>
		</div>
	</div>
	<footer class="rodape">
		<p>© 2023 por Camille Janine, Jean Barbosa e Josué da Silva</p>
	</footer>
	<script src="scripts/confirmador.js"></script>
</body>
</html>
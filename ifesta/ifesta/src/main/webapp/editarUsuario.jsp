<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" href="style.css">
	<link rel="icon" href="Imagens/If_Logo.ico">
	<title>Editar Usuario</title>
</head>
<body>	
	<%	String matricula = (String) session.getAttribute("matricula");
		if(matricula == null){
			response.sendRedirect("login.jsp");
		}%>
	<div class="main">
		<div class="right">
			<form name="formUsuario" action="update">
				<div class="card-cadastro">
					<h1>CADASTRO</h1>
					<div class="textfield">
						<label for="matricula">Matrícula</label>
						<input type="text" name="matricula" readonly value="<%out.print(request.getAttribute("matricula"));%>">
					</div>
					<div class="textfield">
						<label for="nome">Nome</label> 
						<input type="text" name="nome" value="<%out.print(request.getAttribute("nome"));%>">
					</div>
					<div class="textfield">
						<label for="telefone">Telefone</label> 
						<input type="text" name="telefone" value="<%out.print(request.getAttribute("telefone"));%>">
					</div>
					<div class="textfield">
						<label for="email">Email</label> 
						<input type="email" name="email" value="<%out.print(request.getAttribute("email"));%>">
					</div>
					<div class="textfield">
						<label for="senha">Senha</label> 
						<input type="text" name="senha" value="<%out.print(request.getAttribute("senha"));%>">
					</div>
					<input type="button" value="Salvar" class="botao-principal" onclick="validar()">
				</div>
			</form>
		</div>
	</div>
	<script src="scripts/validador.js"></script>
</body>
</html>
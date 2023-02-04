<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="model.Usuario"%>
<%@ page import="model.DAO"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" href="style.css">
	<link rel="shortcut icon" href="imagens/IF_Logo.ico" type="image/x-icon" />
	<title>Login</title>
</head>
<body>
	<form action="controller" method="post">
		<div class="main">
			<div class="left">
				<h1>IFESTA<br>Faça login agora mesmo</h1>
				<img src="imagens/festa.svg" class="left-image" alt="Festa animação">
			</div>
			<div class="right">
				<div class="card-login">
					<h1>LOGIN</h1>
					<div class="textfield">
						<label for="matricula">Matrícula</label> 
						<input type="text" name="matricula" placeholder="Matrícula">
					</div>
					<div class="textfield">
						<label for="senha">Senha</label> 
						<input type="password" name="senha" placeholder="Senha">
					</div>
					<input type="submit" value="Login" class="botao-principal">
					<a href="cadastro.html"> 
						<input type="button" value="Não tenho uma conta" class="botao-secundario">
					</a>
				</div>
			</div>
		</div>
	</form>
</body>
</html>
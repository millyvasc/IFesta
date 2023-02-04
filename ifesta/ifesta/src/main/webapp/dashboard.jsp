<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="utf-8">
	<title>Dashboard</title>
	<link rel="shortcut icon" href="imagens/IF_Logo.ico" type="image/x-icon" />
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<%	String matricula = (String) session.getAttribute("matricula");
		if(matricula == null){
			response.sendRedirect("login.jsp");
		}%>
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
    <div id="background"> 
        <h3>IFesta</h3>
        <p>Site desenvolvido para a criação e divulgação<br>de eventos no IFBaiano</p>
    </div>
</body>
</html>
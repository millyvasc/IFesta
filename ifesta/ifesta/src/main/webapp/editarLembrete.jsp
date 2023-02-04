<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="style.css">
	<link rel="shortcut icon" href="imagens/IF_Logo.ico" type="image/x-icon" />
	<title>Editar Lembrete</title>
</head>
<body>
	<%	String matricula = (String) session.getAttribute("matricula");
		if(matricula == null){
			response.sendRedirect("login.jsp");
		}
	%>
	<div class="page-Evento">
        <div class="caixa-Evento">
            <form name="formLembrete" action="updateLembrete">
                <div class="card-evento">
                    <h1>Lembrete</h1>
					<input type="hidden" name="codLembrete" readonly value="<%out.print(request.getAttribute("codLembrete"));%>">
					<div class="textfield">
						<label for="codEvento">Código do Evento</label> 
						<input type="text" name="codEvento" readonly value="<%out.print(request.getAttribute("codEvento"));%>">
					</div>
					<div class="textfield">
						<label for="organizador">Usuário</label> 
						<input type="text" name="organizador" readonly value="<%out.print(request.getAttribute("organizador"));%>">
					</div>
                    <div class="textfield">
                        <label for="nota">Nota</label> 
                        <input type="text" name="nota" value="<%out.print(request.getAttribute("nota"));%>">
                    </div>
                    <input type="hidden" name="tipo" readonly value="<%out.print(request.getAttribute("tipo"));%>">
                    <input type="button" value="Editar" class="botao-principal" onclick="validarLembrete()">
            	</div>
            </form>
        </div>
    </div>
	<script src="scripts/validadorLembrete.js"></script>
</body>
</html>
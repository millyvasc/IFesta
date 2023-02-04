<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="style.css">
	<link rel="shortcut icon" href="imagens/IF_Logo.ico" type="image/x-icon" />
	<title>Adicionar Lembrete</title>
</head>
<body>
	<%	String matricula = (String) session.getAttribute("matricula");
		if(matricula == null){
			response.sendRedirect("login.jsp");
		}
		
		int codEvento = Integer.parseInt(request.getParameter("codEvento"));
		String tipo = request.getParameter("tipo");
	%>
	<div class="page-Evento">
        <div class="caixa-Evento">
            <form name="formLembrete" action="insertLembrete">
                <div class="card-evento">
                    <h1>Lembrete</h1>
                    <div class="textfield">
                        <label for="nota">Nota</label> <input type="text" name="nota" placeholder="Nota">
                    </div>
                    <input type="hidden" name="codEvento" value="<%=codEvento%>">
                    <input type="hidden" name="tipo" value="<%=tipo%>">
                    <input type="button" value="Criar" class="botao-principal" onclick="validarLembrete()">
            	</div>
            </form>
        </div>
    </div>
  	<script src="scripts/validadorLembrete.js"></script>
</body>
</html>
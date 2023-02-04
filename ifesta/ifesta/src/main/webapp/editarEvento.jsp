<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" href="style.css">
	<link rel="shortcut icon" href="imagens/IF_Logo.ico" type="image/x-icon" />
	<title>Editar Evento</title>
</head>
<body>
	<%	String matricula = (String) session.getAttribute("matricula");
		if(matricula == null){
			response.sendRedirect("login.jsp");
		}%>

	<div class="page-Evento">
		<div class="caixa-Evento">
			<form name="formEvento" action="updateEvento">
				<div class="card-evento">
					<h1>EVENTO</h1>
					<input type="hidden" name="codEvento" readonly value="<%out.print(request.getAttribute("codEvento"));%>">
					<div class="textfield">
						<label for="organizador">Organizador</label> 
						<input type="text" name="organizador" readonly value="<%out.print(request.getAttribute("organizador"));%>">
					</div>
					<div class="textfield">
						<label for="nome">Nome</label> 
						<input type="text" name="nome" value="<%out.print(request.getAttribute("nome"));%>">
					</div>
					<div class="textfield">
						<label for="descricao">Descrição</label> 
						<input type="text" name="descricao" value="<%out.print(request.getAttribute("descricao"));%>">
					</div>
					<div class="textfield">
						<label for="data">Data</label> 
						<input type="date" name="data" value="<%out.print(request.getAttribute("data"));%>">
					</div>
					<div class="textfield">
						<label for="horario">Horário</label> 
						<input type="time" name="horario" value="<%out.print(request.getAttribute("horario"));%>">
					</div>
					<div class="textfield">
						<label for="lugar">Lugar</label> 
						<input type="text" name="lugar" value="<%out.print(request.getAttribute("lugar"));%>">
					</div>
					<div class="textfield">
						<label for="tipo">Tipo</label> 
						<input type="text" name="tipo" readonly value="<%out.print(request.getAttribute("tipo"));%>">
					</div>
					<div class="textfield">
						<% if(request.getAttribute("tipo").equals("Evento Social")){%>
						<label for="outroAtributo">Celebração</label>
						<%}else if(request.getAttribute("tipo").equals("Evento Acadêmico")){%>
						<label for="outroAtributo">Carga Horária</label>
						<%}else{%>
						<label for="outroAtributo">Apresentação</label>
						<%}%>
						<input type="text" name="outroAtributo" value="<%out.print(request.getAttribute("outroAtributo"));%>">
					</div>
					 <div class="textfield">
                        <label for="situacao">Situação</label>
                        <select id="situacao" name="situacao">
                            <option value="">Situação</option>
                            <option value="Agendado">Agendado</option>
                            <option value="Cancelado">Cancelado</option>
                            <option value="Realizado">Realizado</option>
                        </select>
                    </div>
					<input type="button" value="Salvar" class="botao-principal" onclick="validarEdicao()">
				</div>
			</form>
		</div>
	</div>
	<script src="scripts/validadorEvento.js"></script>
</body>
</html>
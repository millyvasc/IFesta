<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="model.EventoSocial"%>
<%@ page import="model.EventoCultural"%>
<%@ page import="model.EventoAcademico"%>
<%@ page import="model.Evento"%>
<%@ page import="model.Usuario"%>
<%@ page import="java.util.ArrayList"%>
<%
@ SuppressWarnings("unchecked") ArrayList<EventoAcademico> listaEAcademico = (ArrayList<EventoAcademico>) request.getAttribute("eventosAcademicos");
@ SuppressWarnings("unchecked") ArrayList<EventoCultural> listaECultural = (ArrayList<EventoCultural>) request.getAttribute("eventosCulturais");
@ SuppressWarnings("unchecked") ArrayList<EventoSocial> listaESocial = (ArrayList<EventoSocial>) request.getAttribute("eventosSociais");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="utf-8">
	<link rel="shortcut icon" href="imagens/IF_Logo.ico" type="image/x-icon" />
	<link rel="stylesheet" type="text/css" href="style.css">
	<title>Eventos</title>
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
	<div class="superior">
		<h1>Meus Eventos</h1>
	</div>
	<a href="criarEvento.html"><button class="botaoAddEvento">Adicionar evento</button></a>
	<div class="cardEventos">
		<%for (int i = 0; i < listaEAcademico.size(); i++) {
			if (listaEAcademico.get(i).getOrganizador().getMatricula().equals(matricula)) {%>
				<div class="content">
					<div class="card">
						<div class="topCard">
							<div class="botaoAcao">
								<a href="javascript: confirmar('<%=listaEAcademico.get(i).getCodEvento()%>', '<%=listaEAcademico.get(i).getTipo()%>')">
									<button class="actions-superior" type="button">
										<img src="imagens/lixeira.png" title="Excluir evento" height="23" width="23" />
									</button>
								</a>
								<a href="selectEvento?codEvento=<%=listaEAcademico.get(i).getCodEvento()%>&tipo=<%=listaEAcademico.get(i).getTipo()%>">
									<button class="actions-superior" type="button">
										<img src="imagens/lapis.png" title="Editar evento" height="23" width="23" />
									</button>
								</a>
							</div>
							<h2 class="title"><%=listaEAcademico.get(i).getNome()%></h2>
							<span class="secondText">Organizador: <%=listaEAcademico.get(i).getOrganizador().getNome()%></span>
							<span class="secondText">Data: <%=listaEAcademico.get(i).getData()%></span>
							<span class="secondText">Horário: <%=listaEAcademico.get(i).getHorario()%></span>
							<span class="secondText">Local: <%=listaEAcademico.get(i).getLugar()%></span>
							<span class="secondText">Carga Horária: <%=listaEAcademico.get(i).getCargaHoraria()%></span>
							<span class="secondText">Situação: <%=listaEAcademico.get(i).getSituacao()%></span>
							<span class="secondText">Tipo: <%=listaEAcademico.get(i).getTipo()%></span>
							<span class="secondText">Descrição: <%=listaEAcademico.get(i).getDescricao()%></span>
						</div>
						<div class="bottonCard">
							<div class="actionCard">
								<a class="bt_lembrete" href="adicionarLembrete.jsp?codEvento=<%=listaEAcademico.get(i).getCodEvento()%>&tipo=<%=listaEAcademico.get(i).getTipo()%>">
									<button class="actions" type="button">
										<h4>Adicionar Lembrete</h4>
										<img src="imagens/nota.png" title="Adicionar Lembrete" height="27" width="27" />
									</button>
								</a>
							</div>
						</div>
					</div>
				</div>
			<%}
		}for (int i = 0; i < listaECultural.size(); i++) {
			if (listaECultural.get(i).getOrganizador().getMatricula().equals(matricula)) {%>
				<div class="content">
					<div class="card">
						<div class="topCard">
							<div class="botaoAcao">
								<a href="javascript: confirmar('<%=listaECultural.get(i).getCodEvento()%>', '<%=listaECultural.get(i).getTipo()%>')">
									<button class="actions-superior" type="button">
										<img src="imagens/lixeira.png" title="Excluir evento" height="23" width="23" />
									</button>
								</a>
								<a href="selectEvento?codEvento=<%=listaECultural.get(i).getCodEvento()%>&tipo=<%=listaECultural.get(i).getTipo()%>">
									<button class="actions-superior" type="button">
										<img src="imagens/lapis.png" title="Editar evento" height="23" width="23" />
									</button>
								</a>
							</div>
							<h2 class="title"><%=listaECultural.get(i).getNome()%></h2>
							<span class="secondText">Organizador: <%=listaECultural.get(i).getOrganizador().getNome()%></span>
							<span class="secondText">Data: <%=listaECultural.get(i).getData()%></span>
							<span class="secondText">Horário: <%=listaECultural.get(i).getHorario()%></span>
							<span class="secondText">Local: <%=listaECultural.get(i).getLugar()%></span>
							<span class="secondText">Apresentação <%=listaECultural.get(i).getApresentacao()%></span>
							<span class="secondText">Situação: <%=listaECultural.get(i).getSituacao()%></span>
							<span class="secondText">Tipo: <%=listaECultural.get(i).getTipo()%></span>
							<span class="secondText">Descrição: <%=listaECultural.get(i).getDescricao()%></span>
						</div>
						<div class="bottonCard">
							<div class="actionCard">
								<a class="bt_lembrete" href="adicionarLembrete.jsp?codEvento=<%=listaECultural.get(i).getCodEvento()%>&tipo=<%=listaECultural.get(i).getTipo()%>">
									<button class="actions" type="button">
										<h4>Adicionar Lembrete</h4>
										<img src="imagens/nota.png" title="Adicionar Lembrete" height="27" width="27" />
									</button>
								</a>
							</div>
						</div>
					</div>
				</div>
			<%}
		}for (int i = 0; i < listaESocial.size(); i++) {
			if (listaESocial.get(i).getOrganizador().getMatricula().equals(matricula)) {%>
				<div class="content">
					<div class="card">
						<div class="topCard">
							<div class="botaoAcao">
								<a href="javascript: confirmar('<%=listaESocial.get(i).getCodEvento()%>', '<%=listaESocial.get(i).getTipo()%>')">
									<button class="actions-superior" type="button">
										<img src="imagens/lixeira.png" title="Excluir evento" height="23" width="23" />
									</button>
								</a>
								<a href="selectEvento?codEvento=<%=listaESocial.get(i).getCodEvento()%>&tipo=<%=listaESocial.get(i).getTipo()%>">
									<button class="actions-superior" type="button">
										<img src="imagens/lapis.png" title="Editar evento" height="23" width="23" />
									</button>
								</a>
							</div>
							<h2 class="title"><%=listaESocial.get(i).getNome()%></h2>
							<span class="secondText">Organizador: <%=listaESocial.get(i).getOrganizador().getNome()%></span>
							<span class="secondText">Data: <%=listaESocial.get(i).getData()%></span>
							<span class="secondText">Horário: <%=listaESocial.get(i).getHorario()%></span>
							<span class="secondText">Local: <%=listaESocial.get(i).getLugar()%></span>
							<span class="secondText">Celebração: <%=listaESocial.get(i).getCelebracao()%></span>
							<span class="secondText">Situação: <%=listaESocial.get(i).getSituacao()%></span>
							<span class="secondText">Tipo: <%=listaESocial.get(i).getTipo()%></span>
							<span class="secondText">Descrição: <%=listaESocial.get(i).getDescricao()%></span>
						</div>
						<div class="bottonCard">
							<div class="actionCard">
								<a class="bt_lembrete" href="adicionarLembrete.jsp?codEvento=<%=listaESocial.get(i).getCodEvento()%>&tipo=<%=listaESocial.get(i).getTipo()%>">
									<button class="actions" type="button">
										<h4>Adicionar Lembrete</h4>
										<img src="imagens/nota.png" title="Adicionar Lembrete" height="27" width="27" />
									</button>
								</a>
							</div>
						</div>
					</div>
				</div>
			<%}
		}%>
	</div>
	<footer class="rodape">
		<p>© 2023 por Camille Janine, Jean Barbosa e Josué da Silva</p>
	</footer>  
	<script src="scripts/confirmadorEvento.js"></script>
</body>
</html>
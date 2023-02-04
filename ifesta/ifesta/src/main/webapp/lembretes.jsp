<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="model.Lembrete"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="utf-8">
	<link rel="shortcut icon" href="imagens/IF_Logo.ico" type="image/x-icon"/>
	<link rel="stylesheet" type="text/css" href="style.css">
	<title>Lembretes</title>
</head>
<body>
<%	
@ SuppressWarnings("unchecked") ArrayList<Lembrete> lembretesAcademicos = (ArrayList<Lembrete>) request.getAttribute("lembretesAcademicos");
@ SuppressWarnings("unchecked") ArrayList<Lembrete> lembretesCulturais = (ArrayList<Lembrete>) request.getAttribute("lembretesCulturais");
@ SuppressWarnings("unchecked") ArrayList<Lembrete> lembretesSociais = (ArrayList<Lembrete>) request.getAttribute("lembretesSociais");

	String matricula = (String) session.getAttribute("matricula");
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
		<h1>Lembretes</h1>
	</div>
	<div class="cardEventos">
		<%for (int i = 0; i < lembretesAcademicos.size(); i++) {
			if(lembretesAcademicos.get(i).getUsuario().getMatricula().equals(matricula)) {%>
				<div class="content">
					<div class="card">
						<div class="topCard">
							<div class="botaoAcao">
								<a href="javascript: confirmarLembrete('<%=lembretesAcademicos.get(i).getCodLembrete()%>', '<%=lembretesAcademicos.get(i).getEvento().getTipo()%>')">
									<button class="actions-superior" type="button">
										<img src="imagens/lixeira.png" title="Excluir evento" height="23" width="23" />
									</button>
								</a>
								<a href="selectLembrete?tipo=<%=lembretesAcademicos.get(i).getEvento().getTipo()%>&codLembrete=<%=lembretesAcademicos.get(i).getCodLembrete()%>">
									<button class="actions-superior" type="button">
										<img src="imagens/lapis.png" title="Editar evento" height="23" width="23" />
									</button>
								</a>
							</div>
							<h2 class="title"><%=lembretesAcademicos.get(i).getEvento().getNome() %></h2>
							<span class="secondText">Data: <%=lembretesAcademicos.get(i).getEvento().getData()%></span>
							<span class="secondText">Horário: <%=lembretesAcademicos.get(i).getEvento().getHorario()%></span>
							<span class="secondText">Local: <%=lembretesAcademicos.get(i).getEvento().getLugar()%></span>
							<span class="secondText">Situação: <%=lembretesAcademicos.get(i).getEvento().getSituacao()%></span>
							<span class="secondText">Tipo: <%=lembretesAcademicos.get(i).getEvento().getTipo()%></span>
							<span class="secondText">Nota: <%=lembretesAcademicos.get(i).getNota() %></span>
						</div>
					</div>
				</div>
			<%}
		}for (int i = 0; i < lembretesCulturais.size(); i++) {
			if(lembretesCulturais.get(i).getUsuario().getMatricula().equals(matricula)) {%>
				<div class="content">
					<div class="card">
						<div class="topCard">
							<div class="botaoAcao">
								<a href="javascript: confirmarLembrete('<%=lembretesCulturais.get(i).getCodLembrete()%>', '<%=lembretesCulturais.get(i).getEvento().getTipo()%>')">
									<button class="actions-superior" type="button">
										<img src="imagens/lixeira.png" title="Excluir evento" height="23" width="23" />
									</button>
								</a>
								<a href="selectLembrete?tipo=<%=lembretesCulturais.get(i).getEvento().getTipo()%>&codLembrete=<%=lembretesCulturais.get(i).getCodLembrete()%>">
									<button class="actions-superior" type="button">
										<img src="imagens/lapis.png" title="Editar evento" height="23" width="23" />
									</button>
								</a>
							</div>
							<h2 class="title"><%=lembretesCulturais.get(i).getEvento().getNome() %></h2>
							<span class="secondText">Data: <%=lembretesCulturais.get(i).getEvento().getData()%></span>
							<span class="secondText">Horário: <%=lembretesCulturais.get(i).getEvento().getHorario()%></span>
							<span class="secondText">Local: <%=lembretesCulturais.get(i).getEvento().getLugar()%></span>
							<span class="secondText">Situação: <%=lembretesCulturais.get(i).getEvento().getSituacao()%></span>
							<span class="secondText">Tipo: <%=lembretesCulturais.get(i).getEvento().getTipo()%></span>
							<span class="secondText">Nota: <%=lembretesCulturais.get(i).getNota() %></span>
						</div>
					</div>
				</div>
			<%}
		}for (int i = 0; i < lembretesSociais.size(); i++) {
			if(lembretesSociais.get(i).getUsuario().getMatricula().equals(matricula)) {%>
				<div class="content">
					<div class="card">
						<div class="topCard">
							<div class="botaoAcao">
								<a href="javascript: confirmarLembrete('<%=lembretesSociais.get(i).getCodLembrete()%>', '<%=lembretesSociais.get(i).getEvento().getTipo()%>')">
									<button class="actions-superior" type="button">
										<img src="imagens/lixeira.png" title="Excluir evento" height="23" width="23" />
									</button>
								</a>
								<a href="selectLembrete?tipo=<%=lembretesSociais.get(i).getEvento().getTipo()%>&codLembrete=<%=lembretesSociais.get(i).getCodLembrete()%>">
									<button class="actions-superior" type="button">
										<img src="imagens/lapis.png" title="Editar evento" height="23" width="23" />
									</button>
								</a>
							</div>
							<h2 class="title"><%=lembretesSociais.get(i).getEvento().getNome() %></h2>
							<span class="secondText">Data: <%=lembretesSociais.get(i).getEvento().getData()%></span>
							<span class="secondText">Horário: <%=lembretesSociais.get(i).getEvento().getHorario()%></span>
							<span class="secondText">Local: <%=lembretesSociais.get(i).getEvento().getLugar()%></span>
							<span class="secondText">Situação: <%=lembretesSociais.get(i).getEvento().getSituacao()%></span>
							<span class="secondText">Tipo: <%=lembretesSociais.get(i).getEvento().getTipo()%></span>
							<span class="secondText">Nota: <%=lembretesSociais.get(i).getNota() %></span>
						</div>
					</div>
				</div>
			<%}
			}%>
	</div>
	<footer class="rodape">
		<p>© 2023 por Camille Janine, Jean Barbosa e Josué da Silva</p>
	</footer>
	<script src="scripts/confirmadorLembrete.js"></script>
</body>
</html>
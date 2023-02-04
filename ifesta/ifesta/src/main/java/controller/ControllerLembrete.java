package controller;

import java.io.IOException;
import java.util.ArrayList;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DAO;
import model.DAOLembreteSocial;
import model.EventoAcademico;
import model.EventoCultural;
import model.EventoSocial;
import model.Lembrete;
import model.Usuario;

@WebServlet(urlPatterns = { "/controllerLembrete", "/mainLembrete", "/insertLembrete", "/selectLembrete", "/updateLembrete", "/deleteLembrete" }) 

public class ControllerLembrete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Lembrete lembrete = new Lembrete();
	DAOLembreteSocial lembreteSocial = new DAOLembreteSocial();
     
    public ControllerLembrete() { //CONTROLLER DE LEMBRETE
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		if (action.equals("/mainLembrete")) {
			lembretes(request, response);
		} else if (action.equals("/insertLembrete")) {
			adicionarLembrete(request, response);
		} else if (action.equals("/selectLembrete")) {
			listarLembrete(request, response);
		} else if (action.equals("/updateLembrete")) {
			editarLembrete(request, response);
		} else if (action.equals("/deleteLembrete")) {
			removerLembrete(request, response);
		} else {
			response.sendRedirect("login.jsp");
		}
	}
	
	// Ver Lembrete
	protected void lembretes(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Lembrete> lembretesEAcademico = lembrete.verLembreteAcademico();
		ArrayList<Lembrete> lembretesECultural = lembrete.verLembreteCultural();
		ArrayList<Lembrete> lembretesESocial = lembrete.verLembreteSocial();
		
		request.setAttribute("lembretesAcademicos", lembretesEAcademico);
		request.setAttribute("lembretesCulturais", lembretesECultural);
		request.setAttribute("lembretesSociais", lembretesESocial);
		
		RequestDispatcher rd = request.getRequestDispatcher("lembretes.jsp");
		rd.forward(request, response);
	}

	// Adicionar lembrete
	protected void adicionarLembrete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String matricula = (String) request.getSession().getAttribute("matricula");
		String senha = (String) request.getSession().getAttribute("senha");

		Usuario user = new Usuario();
		user = user.fazerLogin(matricula, senha);
		
		int codEvento = Integer.parseInt(request.getParameter("codEvento"));
		String tipo = request.getParameter("tipo");
		String nota = request.getParameter("nota");
		
		if (tipo.equals("Evento Social")) {
			EventoSocial ESocial = new EventoSocial();
			ESocial.selecionarEvento(codEvento);
			lembrete = new Lembrete(ESocial, user, nota);
			lembrete.adicionarLembrete(lembrete);
			
		} else if (tipo.equals("Evento Acadêmico")) {
			EventoAcademico EAcademico = new EventoAcademico();
			EAcademico.selecionarEvento(codEvento);
			lembrete = new Lembrete(EAcademico, user, nota);
			lembrete.adicionarLembrete(lembrete);
			
		} else {
			EventoCultural ECultural = new EventoCultural();
			ECultural.selecionarEvento(codEvento);
			lembrete = new Lembrete(ECultural, user, nota);
			lembrete.adicionarLembrete(lembrete);
		}
		response.sendRedirect("mainLembrete");
	}

	// Editar Lembrete 
	protected void listarLembrete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int codLembrete = Integer.parseInt(request.getParameter("codLembrete"));
		String tipo = request.getParameter("tipo");
		
		lembrete.selecionarLembrete(codLembrete, tipo);
		request.setAttribute("codLembrete", lembrete.getCodLembrete());
		request.setAttribute("codEvento", lembrete.getEvento().getCodEvento());
		request.setAttribute("organizador", lembrete.getUsuario().getNome());
		request.setAttribute("nota", lembrete.getNota());
		request.setAttribute("tipo", lembrete.getEvento().getTipo());
			
		RequestDispatcher rd = request.getRequestDispatcher("editarLembrete.jsp");
		rd.forward(request, response);
	}

	protected void editarLembrete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int codLembrete = Integer.parseInt(request.getParameter("codLembrete"));
		int codEvento = Integer.parseInt(request.getParameter("codEvento"));
		String tipo = request.getParameter("tipo");
		String nota = request.getParameter("nota");
		
		String organizador = request.getParameter("organizador");
		DAO dao = new DAO();
		Usuario user = new Usuario(organizador);
		user = dao.verUsuario(user);

		if (tipo.equals("Evento Social")) {
			lembrete.setCodLembrete(codLembrete);
			EventoSocial ESocial = new EventoSocial();
			ESocial.selecionarEvento(codEvento);
			lembrete = new Lembrete(codLembrete, ESocial, user, nota);
			lembrete.editarLembrete(lembrete, tipo);

		} else if (tipo.equals("Evento Acadêmico")) {
			lembrete.setCodLembrete(codLembrete);
			EventoAcademico EAcademico = new EventoAcademico();
			EAcademico.selecionarEvento(codEvento);
			lembrete = new Lembrete(codLembrete, EAcademico, user, nota);
			lembrete.editarLembrete(lembrete, tipo);
			
		} else {
			lembrete.setCodLembrete(codLembrete);
			EventoCultural ECultural = new EventoCultural();
			ECultural.selecionarEvento(codEvento);
			lembrete = new Lembrete(codLembrete, ECultural, user, nota);
			lembrete.editarLembrete(lembrete, tipo);
		}
		response.sendRedirect("mainLembrete");
	}
	
	// Remover Lembrete
	protected void removerLembrete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int codLembrete = Integer.parseInt(request.getParameter("codLembrete"));
		String tipo = request.getParameter("tipo");
		lembrete.removerLembrete(codLembrete, tipo);
	
		response.sendRedirect("mainLembrete");
	}
}
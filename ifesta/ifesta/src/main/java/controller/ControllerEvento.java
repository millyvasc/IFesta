package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DAO;
import model.EventoAcademico;
import model.EventoCultural;
import model.EventoSocial;
import model.Usuario;

@WebServlet(urlPatterns = { "/controllerEvento", "/mainEvento", "/mainMeusEventos", "/insertEvento", "/selectEvento",
		"/updateEvento", "/deleteEvento" }) 

public class ControllerEvento extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EventoSocial ESocial = new EventoSocial();
	EventoAcademico EAcademico = new EventoAcademico();
	EventoCultural ECultural = new EventoCultural();

	public ControllerEvento() { //CONTROLLER DE EVENTO
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		if (action.equals("/mainEvento")) {
			eventos(request, response);
		} else if (action.equals("/mainMeusEventos")) {
			meusEventos(request, response);
		} else if (action.equals("/insertEvento")) {
			novoEvento(request, response);
		} else if (action.equals("/selectEvento")) {
			listarEvento(request, response);
		} else if (action.equals("/updateEvento")) {
			editarEvento(request, response);
		} else if (action.equals("/deleteEvento")) {
			removerEvento(request, response);
		} else {
			response.sendRedirect("login.jsp");
		}
	}

	// Listar Eventos
	protected void eventos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ArrayList<EventoAcademico> listaEAcademico = EAcademico.verEvento();
		ArrayList<EventoCultural> listaECultural = ECultural.verEvento();
		ArrayList<EventoSocial> listaESocial = ESocial.verEvento();
		
		request.setAttribute("eventosAcademicos", listaEAcademico);
		request.setAttribute("eventosCulturais", listaECultural);
		request.setAttribute("eventosSociais", listaESocial);
		
		RequestDispatcher rd = request.getRequestDispatcher("eventos.jsp");
		rd.forward(request, response);
	}

	// Listar Meus Eventos 
	protected void meusEventos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		ArrayList<EventoAcademico> listaEAcademico = EAcademico.verEvento();
		ArrayList<EventoCultural> listaECultural = ECultural.verEvento();
		ArrayList<EventoSocial> listaESocial = ESocial.verEvento();
		
		request.setAttribute("eventosAcademicos", listaEAcademico);
		request.setAttribute("eventosCulturais", listaECultural);
		request.setAttribute("eventosSociais", listaESocial);
		
		RequestDispatcher rd = request.getRequestDispatcher("meusEventos.jsp");
		rd.forward(request, response);
	}

	// Criar evento
	protected void novoEvento(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String matricula = (String) request.getSession().getAttribute("matricula");
		String senha = (String) request.getSession().getAttribute("senha");

		Usuario user = new Usuario();
		user = user.fazerLogin(matricula, senha);
		String tipo = request.getParameter("tipo");

		if (tipo.equals("Evento Social")) {
			ESocial = new EventoSocial(user, request.getParameter("nome"), request.getParameter("descricao"), request.getParameter("data"), request.getParameter("horario"), tipo, request.getParameter("lugar"), "Agendado", request.getParameter("outroAtributo"));
			ESocial.criarEvento(ESocial);
			
		} else if (tipo.equals("Evento Acadêmico")) {
			int cargaHoraria = Integer.parseInt(request.getParameter("outroAtributo"));
			EAcademico = new EventoAcademico(user, request.getParameter("nome"), request.getParameter("descricao"), request.getParameter("data"), request.getParameter("horario"), tipo, request.getParameter("lugar"), "Agendado", cargaHoraria);
			EAcademico.criarEvento(EAcademico);
			
		} else {
			ECultural = new EventoCultural(user, request.getParameter("nome"), request.getParameter("descricao"), request.getParameter("data"), request.getParameter("horario"), tipo, request.getParameter("lugar"), "Agendado", request.getParameter("outroAtributo"));
			ECultural.criarEvento(ECultural);
		}
		response.sendRedirect("mainMeusEventos");
	}

	// Editar Evento -> seleção
	protected void listarEvento(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int codEvento = Integer.parseInt(request.getParameter("codEvento"));
		String tipo = request.getParameter("tipo");
		if (tipo.equals("Evento Social")) {
			ESocial.selecionarEvento(codEvento);
			request.setAttribute("codEvento", ESocial.getCodEvento());
			request.setAttribute("organizador", ESocial.getOrganizador().getNome());
			request.setAttribute("nome", ESocial.getNome());
			request.setAttribute("descricao", ESocial.getDescricao());
			request.setAttribute("data", ESocial.getData());
			request.setAttribute("horario", ESocial.getHorario());
			request.setAttribute("lugar", ESocial.getLugar());
			request.setAttribute("tipo", ESocial.getTipo());
			request.setAttribute("outroAtributo", ESocial.getCelebracao());
			request.setAttribute("situacao", ESocial.getSituacao());

		} else if (tipo.equals("Evento Acadêmico")) {
			EAcademico.selecionarEvento(codEvento);
			request.setAttribute("codEvento", EAcademico.getCodEvento());
			request.setAttribute("organizador", EAcademico.getOrganizador().getNome());
			request.setAttribute("nome", EAcademico.getNome());
			request.setAttribute("descricao", EAcademico.getDescricao());
			request.setAttribute("data", EAcademico.getData());
			request.setAttribute("horario", EAcademico.getHorario());
			request.setAttribute("lugar", EAcademico.getLugar());
			request.setAttribute("tipo", EAcademico.getTipo());
			request.setAttribute("outroAtributo", EAcademico.getCargaHoraria());
			request.setAttribute("situacao", EAcademico.getSituacao());

		} else {
			ECultural.selecionarEvento(codEvento);
			request.setAttribute("codEvento", ECultural.getCodEvento());
			request.setAttribute("organizador", ECultural.getOrganizador().getNome());
			request.setAttribute("nome", ECultural.getNome());
			request.setAttribute("descricao", ECultural.getDescricao());
			request.setAttribute("data", ECultural.getData());
			request.setAttribute("horario", ECultural.getHorario());
			request.setAttribute("lugar", ECultural.getLugar());
			request.setAttribute("tipo", ECultural.getTipo());
			request.setAttribute("outroAtributo", ECultural.getApresentacao());
			request.setAttribute("situacao", ECultural.getSituacao());
		}

		RequestDispatcher rd = request.getRequestDispatcher("editarEvento.jsp");
		rd.forward(request, response);
	}

	// Editar Evento
	protected void editarEvento(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int codEvento = Integer.parseInt(request.getParameter("codEvento"));
		String tipo = request.getParameter("tipo");

		String organizador = request.getParameter("organizador");
		DAO dao = new DAO();
		Usuario user = new Usuario(organizador);
		user = dao.verUsuario(user);

		if (tipo.equals("Evento Social")) {
			ESocial.setCodEvento(codEvento);
			ESocial = new EventoSocial(codEvento, user, request.getParameter("nome"), request.getParameter("descricao"), request.getParameter("data"), request.getParameter("horario"), request.getParameter("tipo"), request.getParameter("lugar"), request.getParameter("situacao"), request.getParameter("outroAtributo"));
			ESocial.editarEvento(ESocial);

		} else if (tipo.equals("Evento Acadêmico")) {
			int cargaHoraria = Integer.parseInt(request.getParameter("outroAtributo"));
			EAcademico.setCodEvento(codEvento);
			EAcademico = new EventoAcademico(codEvento, user, request.getParameter("nome"), request.getParameter("descricao"), request.getParameter("data"), request.getParameter("horario"), request.getParameter("tipo"), request.getParameter("lugar"), request.getParameter("situacao"), cargaHoraria);
			EAcademico.editarEvento(EAcademico);

		} else {
			ECultural.setCodEvento(codEvento);
			ECultural = new EventoCultural(codEvento, user, request.getParameter("nome"), request.getParameter("descricao"), request.getParameter("data"), request.getParameter("horario"), request.getParameter("tipo"), request.getParameter("lugar"), request.getParameter("situacao"), request.getParameter("outroAtributo"));
			ECultural.editarEvento(ECultural);
		}
		response.sendRedirect("mainMeusEventos");
	}

	// Remover Evento
	protected void removerEvento(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int codEvento = Integer.parseInt(request.getParameter("codEvento"));
		String tipo = request.getParameter("tipo");
		
		if (tipo.equals("Evento Social")) {
			ESocial.selecionarEvento(codEvento);
			if(ESocial.getSituacao().equals("Agendado")) {
				JOptionPane.showMessageDialog(null, "Você não pode excluir um evento agendado!", "alert", JOptionPane.ERROR_MESSAGE);
			}else {
				ESocial.excluirEvento(codEvento);				
			}

		} else if (tipo.equals("Evento Acadêmico")) {
			EAcademico.selecionarEvento(codEvento);
			if(EAcademico.getSituacao().equals("Agendado")) {
				JOptionPane.showMessageDialog(null, "Você não pode excluir um evento agendado!", "alert", JOptionPane.ERROR_MESSAGE);
			}else {
				EAcademico.excluirEvento(codEvento);				
			}

		} else {
			ECultural.selecionarEvento(codEvento);
			if(ECultural.getSituacao().equals("Agendado")) {
				JOptionPane.showMessageDialog(null, "Você não pode excluir um evento agendado!", "alert", JOptionPane.ERROR_MESSAGE);
			}else {
				ECultural.excluirEvento(codEvento);				
			}
		}
		response.sendRedirect("mainMeusEventos");
	}
}
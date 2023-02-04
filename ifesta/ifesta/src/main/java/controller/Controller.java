package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;

@WebServlet(urlPatterns = { "/controller", "/main", "/insert", "/select", "/update", "/delete"})

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Usuario usuario = new Usuario();

	public Controller() { //CONTROLLER DE USUARIO
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		if (action.equals("/main")) {
			usuarios(request, response);
		} else if (action.equals("/insert")) {
			adicionarUsuario(request, response);
		} else if (action.equals("/select")) {
			listarUsuario(request, response);
		} else if (action.equals("/update")) {
			editarUsuario(request, response);
		} else if (action.equals("/delete")) {
			removerUsuario(request, response);
		} else {
			response.sendRedirect("login.jsp");
		}
	}

	//Autenticar Usuário
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Usuario userAltenticado = usuario.fazerLogin(request.getParameter("matricula"), request.getParameter("senha"));
		if (userAltenticado != null) {
			usuario = userAltenticado;
			request.getSession().setAttribute("matricula", usuario.getMatricula());
			request.getSession().setAttribute("senha", usuario.getSenha());
			request.getRequestDispatcher("dashboard.jsp").forward(request, response);																// tiver altenticado
		} else {
			response.sendRedirect("login.jsp");
		}
	}

	// Ver Usuário 
	protected void usuarios(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Usuario user = usuario.verUsuario();
		request.setAttribute("usuarios", user);
		RequestDispatcher rd = request.getRequestDispatcher("perfil.jsp");
		rd.forward(request, response);
	}

	// Cadastrar Usuário
	protected void adicionarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		usuario.cadastrar(request.getParameter("matricula"), request.getParameter("nome"), request.getParameter("telefone"), request.getParameter("email"), request.getParameter("senha"));
		response.sendRedirect("login.jsp");
	}

	// Editar Usuário
	protected void listarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		usuario = usuario.selecionarUsuario(request.getParameter("matricula"));
		request.setAttribute("matricula", usuario.getMatricula());
		request.setAttribute("nome", usuario.getNome());
		request.setAttribute("telefone", usuario.getTelefone());
		request.setAttribute("email", usuario.getEmail());
		request.setAttribute("senha", usuario.getSenha());
		RequestDispatcher rd = request.getRequestDispatcher("editarUsuario.jsp");
		rd.forward(request, response);
	}

	protected void editarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		usuario.editarUsuario(request.getParameter("matricula"), request.getParameter("nome"), request.getParameter("telefone"), request.getParameter("email"), request.getParameter("senha"));
		response.sendRedirect("main");
	}
	
	//Remover Usuário
	protected void removerUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		usuario.deletarUsuario(request.getParameter("matricula"));
		response.sendRedirect("login.jsp");
	}
}
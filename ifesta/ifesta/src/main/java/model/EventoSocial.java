package model;

import java.util.ArrayList;

public class EventoSocial extends Evento{
	
	private String celebracao;

	public EventoSocial() {
		super();
	}

	public EventoSocial(int codEvento, Usuario organizador, String nome, String descricao, String data, String horario, String tipo, String lugar, String situacao, String celebracao) {
		super(codEvento, organizador, nome, descricao, data, horario, tipo, lugar, situacao);
		this.celebracao = celebracao;
	}
	
	public EventoSocial(Usuario organizador, String nome, String descricao, String data, String horario, String tipo, String lugar, String situacao, String celebracao) {
		super(organizador, nome, descricao, data, horario, tipo, lugar, situacao);
		this.celebracao = celebracao;
	}

	public void criarEvento(EventoSocial evento) {
		new DAOEventoSocial().inserirEvento(evento);
	}
	
	public void selecionarEvento(int codEvento) {
		this.setCodEvento(codEvento);
		new DAOEventoSocial().selecionarEvento(this);
	}

	public void editarEvento(EventoSocial evento) {
		new DAOEventoSocial().alterarEvento(evento);
	}
	
	public ArrayList<EventoSocial> verEvento() {
		ArrayList<EventoSocial> listaESocial;
		listaESocial = new DAOEventoSocial().listarESociais();
		return listaESocial;
		
	}

	public void excluirEvento(int codEvento) {
		this.setCodEvento(codEvento);
		new DAOEventoSocial().deletarEvento(this);
	}
	
	//Getters e setters
	public String getCelebracao() {
		return celebracao;
	}

	public void setCelebracao(String celebracao) {
		this.celebracao = celebracao;
	}
}
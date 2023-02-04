package model;

import java.util.ArrayList;

public class EventoCultural extends Evento{
	
	private String apresentacao;
	
	public EventoCultural() {
		super();
	}

	public EventoCultural(int codEvento, Usuario organizador, String nome, String descricao, String data, String horario, String tipo, String lugar, String situacao, String apresentacao) {
		super(codEvento, organizador, nome, descricao, data, horario, tipo, lugar, situacao);
		this.apresentacao = apresentacao;
	}
	
	public EventoCultural(Usuario organizador, String nome, String descricao, String data, String horario, String tipo, String lugar, String situacao, String apresentacao) {
		super(organizador, nome, descricao, data, horario, tipo, lugar, situacao);
		this.apresentacao = apresentacao;
	}

	public EventoCultural(String apresentacao) {
		super();
		this.apresentacao = apresentacao;
	}
	
	public void criarEvento(EventoCultural evento) {
		new DAOEventoCultural().inserirEvento(evento);
	}
	
	public void selecionarEvento(int codEvento) {
		this.setCodEvento(codEvento);
		new DAOEventoCultural().selecionarEvento(this);
	}

	public void editarEvento(EventoCultural evento) {
		new DAOEventoCultural().alterarEvento(evento);	
	}
	
	public ArrayList<EventoCultural> verEvento() {
		ArrayList<EventoCultural> listaECultural;
		listaECultural = new DAOEventoCultural().listarECulturais();
		return listaECultural;
	}
	
	public void excluirEvento(int codEvento) {
		this.setCodEvento(codEvento);
		new DAOEventoCultural().deletarEvento(this);
	}
	
	//Getters e setters
	public String getApresentacao() {
		return apresentacao;
	}

	public void setApresentacao(String apresentacao) {
		this.apresentacao = apresentacao;
	}	
}
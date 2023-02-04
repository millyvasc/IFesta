package model;

import java.util.ArrayList;

public class EventoAcademico extends Evento{
	
	private int cargaHoraria;

	public EventoAcademico() {
		super();
	}
	
	public EventoAcademico(int codEvento, Usuario organizador, String nome, String descricao, String data, String horario, String tipo, String lugar, String situacao, int cargaHoraria) {
		super(codEvento, organizador, nome, descricao, data, horario, tipo, lugar, situacao);
		this.cargaHoraria = cargaHoraria;
	}
	
	public EventoAcademico(Usuario organizador, String nome, String descricao, String data, String horario, String tipo, String lugar, String situacao, int cargaHoraria) {
		super(organizador, nome, descricao, data, horario, tipo, lugar, situacao);
		this.cargaHoraria = cargaHoraria;
	}

	public void criarEvento(EventoAcademico evento) {
		new DAOEventoAcademico().inserirEvento(evento);
	}
	
	public void selecionarEvento(int codEvento) {
		this.setCodEvento(codEvento);
		new DAOEventoAcademico().selecionarEvento(this);
	}

	public void editarEvento(EventoAcademico evento) {
		new DAOEventoAcademico().alterarEvento(evento);	
	}
	
	public ArrayList<EventoAcademico> verEvento() {
		ArrayList<EventoAcademico> listaEAcademico;
		listaEAcademico = new DAOEventoAcademico().listarEAcademicos();
		return listaEAcademico;	
	}
	
	public void excluirEvento(int codEvento) {
		this.setCodEvento(codEvento);
		new DAOEventoAcademico().deletarEvento(this);
	}
	
	//Getters e setters
	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
}
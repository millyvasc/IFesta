package model;

public class Evento {
	
	private int codEvento;
	private Usuario organizador;
	private String nome, descricao, data, horario, tipo, lugar, situacao;
	
	public Evento() {

	}
	
	public Evento(int codEvento, Usuario organizador, String nome, String descricao, String data, String horario,
			String tipo, String lugar, String situacao) {
		super();
		this.codEvento = codEvento;
		this.organizador = organizador;
		this.nome = nome;
		this.descricao = descricao;
		this.data = data;
		this.horario = horario;
		this.tipo = tipo;
		this.lugar = lugar;
		this.situacao = situacao;
	}
	
	public Evento(Usuario organizador, String nome, String descricao, String data, String horario,
			String tipo, String lugar, String situacao) {
		super();
		this.organizador = organizador;
		this.nome = nome;
		this.descricao = descricao;
		this.data = data;
		this.horario = horario;
		this.tipo = tipo;
		this.lugar = lugar;
		this.situacao = situacao;
	}
	
	public void selecionarEvento(int codEvento) {
//		this.setCodEvento(codEvento);
//		new DAOEvento().selecionarEvento(this);
	}

	public void excluirEvento(int codEvento) {
//		this.setCodEvento(codEvento);
//		new DAOEvento().deletarEvento(this);
	}
	
	//Getters e setters
	public int getCodEvento() {
		return codEvento;
	}

	public void setCodEvento(int codEvento) {
		this.codEvento = codEvento;
	}
	
	public Usuario getOrganizador() {
		return organizador;
	}

	public void setOrganizador(Usuario organizador) {
		this.organizador = organizador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}


	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
}
package model;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Lembrete {

	private int codLembrete;
	private Evento evento;
	private Usuario usuario;
	private String nota;

	public Lembrete() {

	}

	public Lembrete(Evento evento, Usuario usuario, String nota) {
		this.evento = evento;
		this.usuario = usuario;
		this.nota = nota;
	}

	public Lembrete(int codLembrete, Evento evento, Usuario usuario, String nota) {
		this.codLembrete = codLembrete;
		this.evento = evento;
		this.usuario = usuario;
		this.nota = nota;
	}

	public void adicionarLembrete(Lembrete lembrete) {
		if (lembrete.getEvento().getTipo().equals("Evento Social")) {
			Lembrete lembreteES = new Lembrete();
			lembreteES = new DAOLembreteSocial().verificarLembrete(lembrete);
			if(lembreteES.getNota() == null) {
				new DAOLembreteSocial().inserirLembrete(lembrete);
			}else {
				JOptionPane.showMessageDialog(null, "Você já adicionou um lembrete ao evento!", "alert", JOptionPane.ERROR_MESSAGE);
			}
		} else if (lembrete.getEvento().getTipo().equals("Evento Acadêmico")) {
			Lembrete lembreteEA = new Lembrete();
			lembreteEA = new DAOLembreteAcademico().verificarLembrete(lembrete);
			if(lembreteEA.getNota() == null) {
				new DAOLembreteAcademico().inserirLembrete(lembrete);
			}else {
				JOptionPane.showMessageDialog(null, "Você já adicionou um lembrete ao evento!", "alert", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			Lembrete lembreteEC = new Lembrete();
			lembreteEC = new DAOLembreteCultural().verificarLembrete(lembrete);
			if(lembreteEC.getNota() == null) {
				new DAOLembreteCultural().inserirLembrete(lembrete);
			}else {
				JOptionPane.showMessageDialog(null, "Você já adicionou um lembrete ao evento!", "alert", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public void selecionarLembrete(int codLembrete, String tipo) {
		if (tipo.equals("Evento Social")) {
			this.setCodLembrete(codLembrete);
			new DAOLembreteSocial().selecionarLembrete(this);
		} else if (tipo.equals("Evento Acadêmico")) {
			this.setCodLembrete(codLembrete);
			new DAOLembreteAcademico().selecionarLembrete(this);
		} else {
			this.setCodLembrete(codLembrete);
			new DAOLembreteCultural().selecionarLembrete(this);
		}
	}

	public void editarLembrete(Lembrete lembrete, String tipo) {
		if (tipo.equals("Evento Social")) {
			new DAOLembreteSocial().alterarLembrete(lembrete);
		} else if (tipo.equals("Evento Acadêmico")) {
			new DAOLembreteAcademico().alterarLembrete(lembrete);
		} else {
			new DAOLembreteCultural().alterarLembrete(lembrete);
		}
	}

	public ArrayList<Lembrete> verLembreteAcademico() {
		ArrayList<Lembrete> lembretesEAcademico;
		lembretesEAcademico = new DAOLembreteAcademico().listarLembretes();
		return lembretesEAcademico;
	}

	public ArrayList<Lembrete> verLembreteCultural() {
		ArrayList<Lembrete> lembretesECultural;
		lembretesECultural = new DAOLembreteCultural().listarLembretes();
		return lembretesECultural;
	}

	public ArrayList<Lembrete> verLembreteSocial() {
		ArrayList<Lembrete> lembretesESocial;
		lembretesESocial = new DAOLembreteSocial().listarLembretes();
		return lembretesESocial;
	}

	public void removerLembrete(int codLembrete, String tipo) {
		if (tipo.equals("Evento Social")) {
			this.setCodLembrete(codLembrete);
			new DAOLembreteSocial().deletarLembrete(this);
		} else if (tipo.equals("Evento Acadêmico")) {
			this.setCodLembrete(codLembrete);
			new DAOLembreteAcademico().deletarLembrete(this);
		} else {
			this.setCodLembrete(codLembrete);
			new DAOLembreteCultural().deletarLembrete(this);
		}
	}

	// Getters e setters
	public int getCodLembrete() {
		return codLembrete;
	}

	public void setCodLembrete(int codLembrete) {
		this.codLembrete = codLembrete;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}
}
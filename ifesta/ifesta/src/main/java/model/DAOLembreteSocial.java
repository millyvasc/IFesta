package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAOLembreteSocial {
	// Parametros de conexão
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/ifesta?useTimezone=true&serverTimezone=UTC"; 
	private String user = "root";
	private String password = "root";

	// Método de conexão
	protected Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	// CRUD CREATE
	public void inserirLembrete(Lembrete lembrete) {
		String create = "insert into Lembrete_Social(codEvento,usuario,nota) values (?,?,?)";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setInt(1, lembrete.getEvento().getCodEvento());
			pst.setString(2, lembrete.getUsuario().getMatricula());
			pst.setString(3, lembrete.getNota());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	//CRUD READ
	public ArrayList<Lembrete> listarLembretes(){
		ArrayList<Lembrete> lembretesSociais = new ArrayList<>();
		String read = "select * from Lembrete_Social";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				int codLembrete = rs.getInt(1);
				
				int codEvento = rs.getInt(2);
				EventoSocial ESocial = new EventoSocial();
				ESocial.selecionarEvento(codEvento);
				
				String usuario = rs.getString(3);
				DAO dao = new DAO();
				Usuario user = new Usuario (usuario);
				user = dao.verUsuario(user);
			
				String nota = rs.getString(4);
				lembretesSociais.add(new Lembrete(codLembrete, ESocial, user, nota));
			}
			con.close();
			return lembretesSociais;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	//CRUD UPDATE -> seleção
	public void selecionarLembrete(Lembrete lembrete) {
		String read2 = "select * from Lembrete_Social where codLembrete = ?";
		
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setInt(1, lembrete.getCodLembrete());
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				lembrete.setCodLembrete(rs.getInt(1));
				
				int codEvento = rs.getInt(2);
				EventoSocial ESocial = new EventoSocial();
				ESocial.selecionarEvento(codEvento);
				lembrete.setEvento(ESocial);
				
				String organizador = rs.getString(3);
				DAO dao = new DAO();
				Usuario usuario = new Usuario (organizador);
				usuario = dao.verUsuario(usuario);
				lembrete.setUsuario(usuario);
				lembrete.setNota(rs.getString(4));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//Verifica se ja existe
	public Lembrete verificarLembrete(Lembrete lembrete) {
		String read3 = "select * from Lembrete_Social where codEvento = ? and usuario = ?";
		Lembrete lembre = new Lembrete();
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read3);
			pst.setInt(1, lembrete.getEvento().getCodEvento());
			pst.setString(2, lembrete.getUsuario().getMatricula());
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				lembre.setCodLembrete(rs.getInt(1));
				
				int codEvento = rs.getInt(2);
				EventoSocial ESocial = new EventoSocial();
				ESocial.selecionarEvento(codEvento);
				lembre.setEvento(ESocial);
				
				String organizador = rs.getString(3);
				DAO dao = new DAO();
				Usuario usuario = new Usuario (organizador);
				usuario = dao.verUsuario(usuario);
				lembre.setUsuario(usuario);
				lembre.setNota(rs.getString(4));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return lembre;
	}
	
	//CRUD UPDATE 
	public void alterarLembrete(Lembrete lembrete) {
		String update = "update Lembrete_Social set nota=? where codLembrete=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(update);
			pst.setString(1, lembrete.getNota());
			pst.setInt(2, lembrete.getCodLembrete());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//CRUD DELETE
	public void deletarLembrete(Lembrete lembrete) {
		String delete = "delete from Lembrete_Social where codLembrete = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setInt(1, lembrete.getCodLembrete());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
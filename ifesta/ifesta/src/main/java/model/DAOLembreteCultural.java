package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAOLembreteCultural extends DAOLembreteSocial{
	
	// CRUD CREATE
	@Override
	public void inserirLembrete(Lembrete lembrete) {
		String create = "insert into Lembrete_Cultural(codEvento,usuario,nota) values (?,?,?)";
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
	@Override
	public ArrayList<Lembrete> listarLembretes(){
		ArrayList<Lembrete> lembretesCulturais = new ArrayList<>();
		String read = "select * from Lembrete_Cultural";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				int codLembrete = rs.getInt(1);
				
				int codEvento = rs.getInt(2);
				EventoCultural ECultural = new EventoCultural();
				ECultural.selecionarEvento(codEvento);
				
				String usuario = rs.getString(3);
				DAO dao = new DAO();
				Usuario user = new Usuario (usuario);
				user = dao.verUsuario(user);
			
				String nota = rs.getString(4);
				lembretesCulturais.add(new Lembrete(codLembrete, ECultural, user, nota));
			}
			con.close();
			return lembretesCulturais;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	//CRUD UPDATE -> seleção
	@Override
	public void selecionarLembrete(Lembrete lembrete) {
		String read2 = "select * from Lembrete_Cultural where codLembrete = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setInt(1, lembrete.getCodLembrete());
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				lembrete.setCodLembrete(rs.getInt(1));
				
				int codEvento = rs.getInt(2);
				EventoCultural ECultural = new EventoCultural();
				ECultural.selecionarEvento(codEvento);
				lembrete.setEvento(ECultural);
				
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
	@Override
	public Lembrete verificarLembrete(Lembrete lembrete) {
		String read3 = "select * from Lembrete_Cultural where codEvento = ? and usuario = ?";
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
				EventoCultural ECultural = new EventoCultural();
				ECultural.selecionarEvento(codEvento);
				lembre.setEvento(ECultural);
				
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
	@Override
	public void alterarLembrete(Lembrete lembrete) {
		String update = "update Lembrete_Cultural set nota=? where codLembrete=?";
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
	@Override
	public void deletarLembrete(Lembrete lembrete) {
		String delete = "delete from Lembrete_Cultural where codLembrete = ?";
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
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class DAOEventoSocial {
	// Parametros de conexão
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/ifesta?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "root";

	// Método de conexão
	private Connection conectar() {
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
	
	//CRUD CREATE
	public void inserirEvento(EventoSocial ESocial) {
		String create = "insert into Evento_Social (organizador, nome, descricao, dt, horario, tipo, lugar, situacao, celebracao) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			Connection con = conectar();
			PreparedStatement pst= con.prepareStatement(create);
			pst.setString(1, ESocial.getOrganizador().getMatricula());
			pst.setString(2, ESocial.getNome());
			pst.setString(3, ESocial.getDescricao());
			pst.setString(4, ESocial.getData());
			pst.setString(5, ESocial.getHorario());
			pst.setString(6, ESocial.getTipo());
			pst.setString(7, ESocial.getLugar());
			pst.setString(8, ESocial.getSituacao());
			pst.setString(9, ESocial.getCelebracao());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "Você não pode excluir um evento agendado!", "alert", JOptionPane.ERROR_MESSAGE);
		}
	}

	//CRUD READ  - EVENTO SOCIAL
	public ArrayList<EventoSocial> listarESociais(){
		ArrayList<EventoSocial> eventosSociais = new ArrayList<>();
		String read = "select * from Evento_Social order by dt, horario";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				int codEvento = rs.getInt(1);
				String organizador = rs.getString(2);
				
				DAO dao = new DAO();
				Usuario usuario = new Usuario (organizador);
				usuario = dao.verUsuario(usuario);
			
				String nome = rs.getString(3);
				String descricao = rs.getString(4);
				String data = rs.getString(5);
				String horario = rs.getString(6);
				String tipo = rs.getString(7);
				String lugar = rs.getString(8);
				String situacao = rs.getString(9);
				String celebracao = rs.getString(10);
				eventosSociais.add(new EventoSocial(codEvento, usuario, nome, descricao, data, horario, tipo, lugar, situacao, celebracao));
			}
			con.close();
			return eventosSociais;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	//CRUD UPDATE -> selecionar evento
	public void selecionarEvento(EventoSocial ESocial) {
		String read2 = "select * from Evento_Social where codEvento = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setInt(1, ESocial.getCodEvento());
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				ESocial.setCodEvento(rs.getInt(1));
				
				String organizador = rs.getString(2);
				DAO dao = new DAO();
				Usuario usuario = new Usuario (organizador);
				usuario = dao.verUsuario(usuario);
				ESocial.setOrganizador(usuario);
				
				ESocial.setNome(rs.getString(3));
				ESocial.setDescricao(rs.getString(4));
				ESocial.setData(rs.getString(5));
				ESocial.setHorario(rs.getString(6));
				ESocial.setTipo(rs.getString(7));
				ESocial.setLugar(rs.getString(8));
				ESocial.setSituacao(rs.getString(9));
				ESocial.setCelebracao(rs.getString(10));			
			}
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//CRUD UPDATE -> editar evento
	public void alterarEvento(EventoSocial ESocial) {
		String update = "update Evento_Social set nome=?, descricao=?, dt=?, horario=?, tipo=?, lugar=?, situacao=?, celebracao=? where codEvento=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(update);
			pst.setString(1, ESocial.getNome());
			pst.setString(2, ESocial.getDescricao());
			pst.setString(3, ESocial.getData());
			pst.setString(4, ESocial.getHorario());
			pst.setString(5, ESocial.getTipo());
			pst.setString(6, ESocial.getLugar());
			pst.setString(7, ESocial.getSituacao());
			pst.setString(8, ESocial.getCelebracao());
			pst.setInt(9, ESocial.getCodEvento());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//CRUD DELETE
	public void deletarEvento(EventoSocial evento) {
		String delete = "delete from Evento_Social where codEvento= ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setInt(1, evento.getCodEvento());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
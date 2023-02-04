package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAOEventoCultural {
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

	// CRUD CREATE
	public void inserirEvento(EventoCultural ECultural) {
		String create = "insert into Evento_Cultural (organizador, nome, descricao, dt, horario, tipo, lugar, situacao, apresentacao) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, ECultural.getOrganizador().getMatricula());
			pst.setString(2, ECultural.getNome());
			pst.setString(3, ECultural.getDescricao());
			pst.setString(4, ECultural.getData());
			pst.setString(5, ECultural.getHorario());
			pst.setString(6, ECultural.getTipo());
			pst.setString(7, ECultural.getLugar());
			pst.setString(8, ECultural.getSituacao());
			pst.setString(9, ECultural.getApresentacao());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// CRUD READ - EVENTO CULTURAL
	public ArrayList<EventoCultural> listarECulturais() {
		ArrayList<EventoCultural> eventosCulturais = new ArrayList<>();
		String read = "select * from Evento_Cultural order by dt, horario";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int codEvento = rs.getInt(1);
				String organizador = rs.getString(2);

				DAO dao = new DAO();
				Usuario usuario = new Usuario(organizador);
				usuario = dao.verUsuario(usuario);

				String nome = rs.getString(3);
				String descricao = rs.getString(4);
				String data = rs.getString(5);
				String horario = rs.getString(6);
				String tipo = rs.getString(7);
				String lugar = rs.getString(8);
				String situacao = rs.getString(9);
				String apresentacao = rs.getString(10);
				eventosCulturais.add(new EventoCultural(codEvento, usuario, nome, descricao, data, horario, tipo, lugar, situacao, apresentacao));
			}
			con.close();
			return eventosCulturais;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	// CRUD UPDATE -> selecionar evento
	public void selecionarEvento(EventoCultural ECultural) {
		String read2 = "select * from Evento_Cultural where codEvento = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setInt(1, ECultural.getCodEvento());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				ECultural.setCodEvento(rs.getInt(1));

				String organizador = rs.getString(2);
				DAO dao = new DAO();
				Usuario usuario = new Usuario(organizador);
				usuario = dao.verUsuario(usuario);
				ECultural.setOrganizador(usuario);

				ECultural.setNome(rs.getString(3));
				ECultural.setDescricao(rs.getString(4));
				ECultural.setData(rs.getString(5));
				ECultural.setHorario(rs.getString(6));
				ECultural.setTipo(rs.getString(7));
				ECultural.setLugar(rs.getString(8));
				ECultural.setSituacao(rs.getString(9));
				ECultural.setApresentacao(rs.getString(10));
			}
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// CRUD UPDATE -> editar evento
	public void alterarEvento(EventoCultural ECultural) {
		String update = "update Evento_Cultural set nome=?, descricao=?, dt=?, horario=?, tipo=?, lugar=?, situacao=?, apresentacao=? where codEvento=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(update);
			pst.setString(1, ECultural.getNome());
			pst.setString(2, ECultural.getDescricao());
			pst.setString(3, ECultural.getData());
			pst.setString(4, ECultural.getHorario());
			pst.setString(5, ECultural.getTipo());
			pst.setString(6, ECultural.getLugar());
			pst.setString(7, ECultural.getSituacao());
			pst.setString(8, ECultural.getApresentacao());
			pst.setInt(9, ECultural.getCodEvento());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// CRUD DELETE
	public void deletarEvento(EventoCultural ECultural) {
		String delete = "delete from Evento_Cultural where codEvento= ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setInt(1, ECultural.getCodEvento());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
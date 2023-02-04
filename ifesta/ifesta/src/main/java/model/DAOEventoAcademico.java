package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAOEventoAcademico {
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
	public void inserirEvento(EventoAcademico EAcademico) {
		String create = "insert into Evento_Academico (organizador, nome, descricao, dt, horario, tipo, lugar, situacao, cargaHoraria) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, EAcademico.getOrganizador().getMatricula());
			pst.setString(2, EAcademico.getNome());
			pst.setString(3, EAcademico.getDescricao());
			pst.setString(4, EAcademico.getData());
			pst.setString(5, EAcademico.getHorario());
			pst.setString(6, EAcademico.getTipo());
			pst.setString(7, EAcademico.getLugar());
			pst.setString(8, EAcademico.getSituacao());
			pst.setInt(9, EAcademico.getCargaHoraria());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// CRUD READ - EVENTO ACADÊMICO
	public ArrayList<EventoAcademico> listarEAcademicos() {
		ArrayList<EventoAcademico> eventosAcademicos = new ArrayList<>();
		String read = "select * from Evento_Academico order by dt, horario";
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
				int cargaHoraria = rs.getInt(10);
				eventosAcademicos.add(new EventoAcademico(codEvento, usuario, nome, descricao, data, horario, tipo, lugar, situacao, cargaHoraria));
			}
			con.close();
			return eventosAcademicos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	// CRUD UPDATE -> selecionar evento
	public void selecionarEvento(EventoAcademico EAcademico) {
		String read2 = "select * from Evento_Academico where codEvento = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setInt(1, EAcademico.getCodEvento());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				EAcademico.setCodEvento(rs.getInt(1));

				String organizador = rs.getString(2);
				DAO dao = new DAO();
				Usuario usuario = new Usuario(organizador);
				usuario = dao.verUsuario(usuario);
				EAcademico.setOrganizador(usuario);

				EAcademico.setNome(rs.getString(3));
				EAcademico.setDescricao(rs.getString(4));
				EAcademico.setData(rs.getString(5));
				EAcademico.setHorario(rs.getString(6));
				EAcademico.setTipo(rs.getString(7));
				EAcademico.setLugar(rs.getString(8));
				EAcademico.setSituacao(rs.getString(9));
				EAcademico.setCargaHoraria(rs.getInt(10));
			}
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// CRUD UPDATE -> editar evento
	public void alterarEvento(EventoAcademico EAcademico) {
		String update = "update Evento_Academico set nome=?, descricao=?, dt=?, horario=?, tipo=?, lugar=?, situacao=?, cargaHoraria=? where codEvento=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(update);
			pst.setString(1, EAcademico.getNome());
			pst.setString(2, EAcademico.getDescricao());
			pst.setString(3, EAcademico.getData());
			pst.setString(4, EAcademico.getHorario());
			pst.setString(5, EAcademico.getTipo());
			pst.setString(6, EAcademico.getLugar());
			pst.setString(7, EAcademico.getSituacao());
			pst.setInt(8, EAcademico.getCargaHoraria());
			pst.setInt(9, EAcademico.getCodEvento());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// CRUD DELETE
	public void deletarEvento(EventoAcademico EAcademico) {
		String delete = "delete from Evento_Academico where codEvento= ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setInt(1, EAcademico.getCodEvento());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
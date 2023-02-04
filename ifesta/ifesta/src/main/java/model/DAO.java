package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class DAO {
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
	
	public Usuario userLogado = new Usuario();
	
	//Autenticar Usuário 
	public Usuario autenticarUsuario(Usuario user) {
		userLogado=null;
		String sql = "select * from Usuario where matricula = ? and senha=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, user.getMatricula());
			pst.setString(2, user.getSenha());
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				userLogado = new Usuario();
				userLogado.setMatricula(rs.getString(1));
				userLogado.setNome(rs.getString(2));
				userLogado.setTelefone(rs.getString(3));
				userLogado.setEmail(rs.getString(4));
				userLogado.setSenha(rs.getString(5));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return userLogado;
	}
	
	// CRUD CREATE
	public void inserirUsuario(Usuario usuario) {
		String create = "insert into Usuario(matricula,nome,telefone,email,senha) values (?,?,?,?,?)";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, usuario.getMatricula());
			pst.setString(2, usuario.getNome());
			pst.setString(3, usuario.getTelefone());
			pst.setString(4, usuario.getEmail());
			pst.setString(5, usuario.getSenha());
			pst.executeUpdate();
			con.close();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Já existe um usuário com essa matrícula!", "alert", JOptionPane.ERROR_MESSAGE);
			System.out.println(e);
		}
	}

	// CRUD READ
	public Usuario verUsuario(Usuario userPerfil) {
		String read = "select * from Usuario where matricula = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			pst.setString(1, userPerfil.getMatricula());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				userPerfil.setMatricula(rs.getString(1));
				userPerfil.setNome(rs.getString(2));
				userPerfil.setTelefone(rs.getString(3));
				userPerfil.setEmail(rs.getString(4));
				userPerfil.setSenha(rs.getString(5));
			}
			con.close();
			return userPerfil;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	//CRUD UPDATE 
	public void alterarUsuario(Usuario usuario) {
		String update = "update Usuario set nome=?, telefone=?, email=?, senha=? where matricula=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(update);
			pst.setString(1, usuario.getNome());
			pst.setString(2, usuario.getTelefone());
			pst.setString(3, usuario.getEmail());
			pst.setString(4, usuario.getSenha());
			pst.setString(5, usuario.getMatricula());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//CRUD DELETE
	public void deletarUsuario(Usuario user) {
		String delete = "delete from Usuario where matricula = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, user.getMatricula());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Você não pode excluir sua conta tendo eventos ativos!", "alert", JOptionPane.ERROR_MESSAGE);
			System.out.println(e);
		}
	}
}
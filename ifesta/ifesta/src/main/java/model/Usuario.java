package model;

public class Usuario {
	
	private String matricula, nome, telefone, email, senha;
	
	public Usuario() {
		
	}
	
	public Usuario(String matricula) {
		this.matricula = matricula;
	}
	
	public Usuario(String matricula, String senha) {
		this.matricula = matricula;
		this.senha = senha;
	}

	public Usuario(String matricula, String nome, String telefone, String email, String senha) {
		this.matricula = matricula;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
	}
	
	public void cadastrar(String matricula, String nome, String telefone, String email, String senha) {
		Usuario user = new Usuario(matricula, nome, telefone, email, senha);
		new DAO().inserirUsuario(user);
	}

	public Usuario fazerLogin(String matricula, String senha) {
		Usuario user = new Usuario(matricula, senha);
		DAO dao = new DAO();
		Usuario usuario = dao.autenticarUsuario(user);
		return usuario;
	}

	public Usuario selecionarUsuario(String matricula) {
		this.setMatricula(matricula);
		new DAO().verUsuario(this);
		return this;
	}
	
	public void editarUsuario(String matricula, String nome, String telefone, String email, String senha) {
		Usuario user = new Usuario(matricula, nome, telefone, email, senha);
		new DAO().alterarUsuario(user);
	}
	
	public Usuario verUsuario() {
		new DAO().verUsuario(this);
		return this;
	}
	
	public void deletarUsuario(String matricula) {
		this.setMatricula(matricula);
		new DAO().deletarUsuario(this);
	}

	//Getters e setters
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
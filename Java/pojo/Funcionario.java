package pojo;

public class Funcionario {

	private long id_funcionario;
	private String login;
	private String senha;
	private String nome;
	private String sobrenome;
	private String telefone;
	private String cpf;

	public Funcionario() {
		
	}

	public Funcionario(long id_funcionario, String login, String senha, String nome, String sobrenome, String telefone,
			String cpf) {
		this.id_funcionario = id_funcionario;
		this.login = login;
		this.senha = senha;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
		this.cpf = cpf;
	}

	public long getId_funcionario() {
		return id_funcionario;
	}

	public void setId_funcionario(long id_funcionario) {
		this.id_funcionario = id_funcionario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}

package pojo;

public class Administrador {
	private static String login = "admin";
	private static String senha = "admin";
	
	public static String getLogin() {
		return login;
	}
	public static void setLogin(String login) {
		Administrador.login = login;
	}
	public static String getSenha() {
		return senha;
	}
	public static void setSenha(String senha) {
		Administrador.senha = senha;
	}

	
}

package pojo;

import java.util.Scanner;
import persistencia.AutenticacaoDAO;

public class Autenticacao {

    Scanner sc = new Scanner(System.in);

    private long id;
    private String login;
    private String senha;
    private int tipo;

    AutenticacaoDAO autenticacaoDAO = new AutenticacaoDAO();

    public Autenticacao() {

    }

    public Autenticacao autenticar(Autenticacao autenticacao) {
        do {
            System.out.printf("Login: ");
            autenticacao.setLogin(sc.next());
            System.out.printf("Senha: ");
            autenticacao.setSenha(sc.next());
            if (autenticacao.getLogin().equalsIgnoreCase(Administrador.getLogin()) && autenticacao.getSenha().equalsIgnoreCase(Administrador.getSenha())) {
                autenticacao.setTipo(3);
            } else {
                autenticacaoDAO.autenticar(autenticacao, "cliente");
                if (autenticacao.getTipo() != 1) {
                    autenticacaoDAO.autenticar(autenticacao, "funcionario");
                }
                if (autenticacao.getTipo() == 0) {
                    System.out.println("Usuario ou senha incorretos, tente novamente.\n");
                }
            }
        } while (autenticacao.getTipo() != 1 && autenticacao.getTipo() != 2 && autenticacao.getTipo() != 3);
        System.out.println("Entrou com sucesso!\n");
        return autenticacao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

}

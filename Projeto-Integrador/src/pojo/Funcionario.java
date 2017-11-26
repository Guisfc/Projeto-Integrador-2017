package pojo;

import java.util.ArrayList;
import java.util.List;

public class Funcionario {

    private long idFuncionario;
    private String login;
    private String senha;
    private String nome;
    private String sobrenome;
    private String telefone;
    private String cpf;
    private Setor setor;
    
    private List<Limpeza> listaLimpeza;

    public Funcionario() {
        this.listaLimpeza = new ArrayList<Limpeza>();
    }

    public Funcionario(long idFuncionario, String login, String senha, String nome, String sobrenome, String telefone,
            String cpf, Setor setor, List<Limpeza> listaLimpeza) {
        this.idFuncionario = idFuncionario;
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.setor = setor;
        this.listaLimpeza = listaLimpeza;
    }

    public long getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(long idFuncionario) {
        this.idFuncionario = idFuncionario;
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

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public List<Limpeza> getListaLimpeza() {
        return listaLimpeza;
    }

    public void setListaLimpeza(List<Limpeza> listaLimpeza) {
        this.listaLimpeza = listaLimpeza;
    }

    
    

}

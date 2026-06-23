package model;

public class Usuario {

    private String nome, senha;

    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome + " | Senha criptografada: " + this.senha;
    }
}

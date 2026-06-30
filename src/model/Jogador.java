package model;

public class Jogador {

    private String nome;
    private Integer baralhoAtual;

    public Jogador(String nome, Integer baralhoAtual) {
        this.nome = nome;
        this.baralhoAtual = baralhoAtual;
    }

    public String getNome() {
        return nome;
    }

    public Integer getBaralhoAtual() { return baralhoAtual; }

    @Override
    public String toString() {
        return "Nome: " + this.nome;
    }
}

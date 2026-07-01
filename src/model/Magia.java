package model;

public class Magia extends Carta {

    private String efeito;

    public Magia(String nome, String descricao, String efeito) {
        this.nome = nome;
        this.descricao = descricao;
        this.efeito = efeito;
    }

    public String getEfeito() { return efeito;}

}

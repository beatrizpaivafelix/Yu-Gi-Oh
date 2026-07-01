package model;

public class Monstro extends Carta {

    private int ATK, DEF;

    public Monstro(String nome, String descricao, int ATK, int DEF) {
        this.nome = nome;
        this.descricao = descricao;
        this.ATK = ATK;
        this.DEF = DEF;
    }

    public int getATK() { return ATK; }

    public int getDEF() { return DEF; }
}

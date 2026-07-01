package model;

import java.util.ArrayList;

public class Baralho {

    private int idBaralho;
    private String nomeBaralho;
    private ArrayList<Carta> cartas;
    private boolean atual;

    public Baralho(String nomeBaralho, ArrayList<Carta> cartas, boolean atual) {
        this.nomeBaralho = nomeBaralho;
        this.cartas = cartas;
        this.atual = atual;
    }

    public Baralho(int idBaralho, String nomeBaralho, ArrayList<Carta> cartas, boolean atual) {
        this.idBaralho = idBaralho;
        this.nomeBaralho = nomeBaralho;
        this.cartas = cartas;
        this.atual = atual;
    }

    public String getNomeBaralho() { return nomeBaralho; }

    public ArrayList<Carta> getCartas() { return cartas; }

    public boolean isAtual() { return atual; }

    @Override
    public String toString() {
        return this.nomeBaralho;
    }
}

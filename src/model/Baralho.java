package model;

import java.util.ArrayList;

public class Baralho {

    private String nomeBaralho;
    private ArrayList<Carta> cartas;

    public Baralho(String nomeBaralho, ArrayList<Carta> cartas) {
        this.nomeBaralho = nomeBaralho;
        this.cartas = cartas;
    }

    public String getNomeBaralho() { return nomeBaralho; }

    public ArrayList<Carta> getCartas() { return cartas; }

}

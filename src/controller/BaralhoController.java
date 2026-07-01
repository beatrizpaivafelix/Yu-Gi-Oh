package controller;

import dao.BaralhoDAO;
import model.Baralho;
import model.Jogador;

import java.util.ArrayList;

public class BaralhoController {

    private BaralhoDAO baralhoDAO;

    public BaralhoController() {
        this.baralhoDAO = new BaralhoDAO();
    }

    public ArrayList<Baralho> getBaralhos(Jogador jogadorAtual) {
        return this.baralhoDAO.getBaralhos(jogadorAtual);
    }

}

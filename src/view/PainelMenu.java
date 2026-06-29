package view;

import model.Jogador;

import javax.swing.*;

public class PainelMenu extends JPanel {

    private Jogador jogador;
    private TelaInicial tela;
    private int x, y;

    public PainelMenu(Jogador jogador, TelaInicial tela, int x, int y) {
        this.jogador = jogador;
        this.tela = tela;
        this.x = x; this.y = y;

    }
}

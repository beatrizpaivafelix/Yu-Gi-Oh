package view;

import model.Baralho;
import model.Jogador;

import javax.swing.*;

public class PainelEdicao extends JPanel {

    private TelaInicial tela;
    private Jogador jogador;
    private Baralho baralhoAtual;

    public PainelEdicao(TelaInicial tela, Jogador jogador) {
        this.tela = tela;
        this.jogador = jogador;



    }

}

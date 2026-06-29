package view;

import model.Jogador;

import javax.swing.*;
import java.awt.*;

public class PainelMenu extends JPanel {

    private Jogador jogador;
    private TelaInicial tela;

    public PainelMenu(Jogador jogador, TelaInicial tela) {
        this.jogador = jogador;
        this.tela = tela;
        this.setLayout(null);

        // Definição das fontes
        Font fonteBotoes = new Font("Arial", Font.PLAIN, 28);

        // Base de largura para o cálculo de centralização (X)
        int larguraTela = this.tela.getWidth();

        //Texto de Boas-vindas
        JLabel lblBoasVindas = new JLabel("Bem vindo " + this.jogador.getNome() + "!");
        lblBoasVindas.setFont(new Font("Arial", Font.PLAIN, 36));
        lblBoasVindas.setBounds(100, 100, 600, 50);
        add(lblBoasVindas);

        //Botão para iniciar uma partida
        JButton btnJogar = new JButton("JOGAR");
        btnJogar.setFont(fonteBotoes);

        int larguraJogar = 180;
        int xJogar = (larguraTela - larguraJogar) / 2;
        btnJogar.setBounds(xJogar, 240, larguraJogar, 50);
        add(btnJogar);

        //Botão para edição de baralhos
        JButton btnEditar = new JButton("EDITAR BARALHOS");
        btnEditar.setFont(fonteBotoes);

        int larguraEdicao = 320;
        int xEditar = (larguraTela - larguraEdicao) / 2;
        btnEditar.setBounds(xEditar, 315, larguraEdicao, 50);
        add(btnEditar);

        //Botão para mostrar o placar
        JButton btnPlacar = new JButton("PLACAR DE PONTUAÇÕES");
        btnPlacar.setFont(fonteBotoes);

        int larguraPlacar = 440;
        int xPlacar = (larguraTela - larguraPlacar) / 2;
        btnPlacar.setBounds(xPlacar, 390, larguraPlacar, 50);
        add(btnPlacar);

        // 5. Botão: SAIR
        JButton btnSair = new JButton("SAIR");
        btnSair.addActionListener(e -> {
            this.tela.trocarTela("INICIAL", new PainelInicial(this.tela));
        });

        btnSair.setFont(fonteBotoes);
        int largSair = 140;
        int xSair = (larguraTela - largSair) / 2; // 330
        btnSair.setBounds(xSair, 465, largSair, 50);
        add(btnSair);

    }
}

package view;

import controller.JogadorController;
import model.Jogador;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Vector;

public class PainelMenu extends JPanel {

    private Jogador jogador;
    private TelaInicial tela;
    private JogadorController jogadorController;

    public PainelMenu(Jogador jogador, TelaInicial tela) {
        this.jogador = jogador;
        this.tela = tela;
        this.jogadorController = new JogadorController();
        this.setLayout(null);

        // Definição das fontes
        Font fonteBotoes = new Font("Arial", Font.PLAIN, 30);

        // Base de largura para o cálculo de centralização (X)
        int larguraTela = this.tela.getWidth();

        //Texto de Boas-vindas
        JLabel lblBoasVindas = new JLabel("Bem vindo " + this.jogador.getNome() + "!");
        lblBoasVindas.setFont(new Font("Arial", Font.PLAIN, 36));
        lblBoasVindas.setBounds(100, 100, 600, 50);
        add(lblBoasVindas);

        //Botão para iniciar uma partida
        JButton btnJogar = new JButton("JOGAR");
        btnJogar.addActionListener(e -> {

            //Verifica se há um baralho ativo
            if(this.jogador.getBaralhoAtual() == null) {
                JOptionPane.showMessageDialog(this.tela, "Selecione um baralho na tela de edição para jogar",
                        "ERRO", JOptionPane.ERROR_MESSAGE);
            } else { //Há um baralho ativo

                //Obtendo oponentes do banco
                Vector<Jogador> listaOponentes = this.jogadorController.getOponentes(this.jogador);

                if(listaOponentes == null) { //Erro
                    JOptionPane.showMessageDialog(this.tela, "ERRO ao conectar-se com o banco de dados",
                            "ERRO", JOptionPane.ERROR_MESSAGE);

                } else if(listaOponentes.isEmpty()) { //Não há outros jogadores cadastrados
                    JOptionPane.showMessageDialog(this.tela, "ERRO: não há outros jogadores cadastrados",
                            "ERRO", JOptionPane.ERROR_MESSAGE);

                } else { //Pode jogar
                    new TelaSelecao(this, listaOponentes); //Abre a tela de seleção de adversários
                }
            }
        });
        btnJogar.setFont(fonteBotoes);

        int larguraJogar = 180;
        int xJogar = (larguraTela - larguraJogar) / 2;
        btnJogar.setBounds(xJogar, 240, larguraJogar, 50);
        add(btnJogar);

        //Botão para edição de baralhos
        JButton btnEditar = new JButton("EDITAR BARALHOS");
        btnEditar.addActionListener(e -> {
            this.tela.trocarTela(new PainelEdicao(this.tela, this.jogador));
        });
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
            this.tela.trocarTela(new PainelInicial(this.tela));
        });

        btnSair.setFont(fonteBotoes);
        int largSair = 140;
        int xSair = (larguraTela - largSair) / 2; // 330
        btnSair.setBounds(xSair, 465, largSair, 50);
        add(btnSair);

    }

    public void iniciarPartida(Jogador oponente) {
        System.out.println("DEU CERTO!");
    }

}

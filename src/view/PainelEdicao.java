package view;

import controller.BaralhoController;
import controller.CartaController;
import model.Baralho;
import model.Carta;
import model.Jogador;
import javax.swing.*;
import java.awt.*;

public class PainelEdicao extends JPanel {

    private TelaInicial tela;
    private Jogador jogador;
    private Baralho baralhoAtual;
    private CartaController cartaController;
    private BaralhoController baralhoController;

    //Componentes declarados como atributos para uso nos eventos
    private JList<Baralho> listBaralhos;
    private DefaultListModel<Baralho> modeloBaralhos;

    private JList<Carta> listCartasBaralho;
    private DefaultListModel<Carta> modeloCartasBaralho;

    private JList<Carta> listTodasCartas;
    private DefaultListModel<Carta> modeloTodasCartas;

    private JTextField txtDescricaoCarta;
    private JLabel lblContador;
    private JButton btnNovoBaralho;
    private JButton btnSalvar;
    private JButton btnVoltar;

    public PainelEdicao(TelaInicial tela, Jogador jogador) {
        this.tela = tela;
        this.jogador = jogador;
        this.cartaController = new CartaController();
        this.baralhoController = new BaralhoController();

        this.setLayout(null);

        // Definição das fontes
        Font fonteTitulos = new Font("Arial", Font.PLAIN, 22);
        Font fonteBotoes = new Font("Arial", Font.PLAIN, 18);

        //Coluna 1 (Esquerda)
        JLabel lblBaralhos = new JLabel("Baralhos", SwingConstants.LEFT);
        lblBaralhos.setFont(fonteTitulos);
        lblBaralhos.setBounds(30, 20, 200, 25);
        this.add(lblBaralhos);

        this.modeloBaralhos = new DefaultListModel<>();
        this.listBaralhos = new JList<>(this.modeloBaralhos);
        JScrollPane scrollBaralhos = new JScrollPane(this.listBaralhos);
        scrollBaralhos.setBounds(30, 55, 220, 560);
        this.add(scrollBaralhos);

        this.btnNovoBaralho = new JButton("Novo Baralho");
        this.btnNovoBaralho.setFont(fonteBotoes);
        this.btnNovoBaralho.setBounds(30, 630, 150, 40);
        this.add(this.btnNovoBaralho);

        //Coluna 2 (Meio)
        JLabel lblCartasBaralho = new JLabel("Cartas no Baralho", SwingConstants.LEFT);
        lblCartasBaralho.setFont(fonteTitulos);
        lblCartasBaralho.setBounds(280, 20, 220, 25);
        this.add(lblCartasBaralho);

        this.modeloCartasBaralho = new DefaultListModel<>();
        this.listCartasBaralho = new JList<>(this.modeloCartasBaralho);
        JScrollPane scrollCartasBaralho = new JScrollPane(this.listCartasBaralho);
        scrollCartasBaralho.setBounds(280, 55, 220, 300);
        this.add(scrollCartasBaralho);

        this.lblContador = new JLabel("n/40", SwingConstants.CENTER);
        this.lblContador.setFont(fonteTitulos);
        this.lblContador.setBounds(280, 360, 220, 20);
        this.add(this.lblContador);

        JLabel lblDetalhes = new JLabel("Detalhes da carta", SwingConstants.LEFT);
        lblDetalhes.setFont(fonteTitulos);
        lblDetalhes.setBounds(280, 395, 220, 25);
        this.add(lblDetalhes);

        //JTextField para os Detalhes da Carta
        this.txtDescricaoCarta = new JTextField();
        this.txtDescricaoCarta.setBounds(280, 425, 220, 190);
        this.txtDescricaoCarta.setEditable(false);
        this.add(this.txtDescricaoCarta);

        //Coluna 3 (Direita)
        JLabel lblTodasCartas = new JLabel("Todas as cartas", SwingConstants.LEFT);
        lblTodasCartas.setFont(fonteTitulos);
        lblTodasCartas.setBounds(530, 20, 240, 25);
        this.add(lblTodasCartas);

        this.modeloTodasCartas = new DefaultListModel<>();
        this.listTodasCartas = new JList<>(this.modeloTodasCartas);
        JScrollPane scrollTodasCartas = new JScrollPane(this.listTodasCartas);
        scrollTodasCartas.setBounds(530, 55, 240, 560);
        this.add(scrollTodasCartas);

        this.btnSalvar = new JButton("SALVAR");
        this.btnSalvar.setFont(fonteBotoes);
        this.btnSalvar.setBounds(530, 630, 110, 40);
        this.add(this.btnSalvar);

        this.btnVoltar = new JButton("VOLTAR");
        this.btnVoltar.addActionListener(e -> {
            this.tela.trocarTela(new PainelMenu(this.jogador, this.tela));
        });
        this.btnVoltar.setFont(fonteBotoes);
        this.btnVoltar.setBounds(660, 630, 110, 40);
        this.add(this.btnVoltar);

        configurarEventos();
    }

    private void configurarEventos() {
        //
    }

}

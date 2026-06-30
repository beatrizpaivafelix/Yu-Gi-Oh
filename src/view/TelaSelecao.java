package view;

import controller.JogadorController;
import model.Jogador;
import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class TelaSelecao extends JFrame {

    private PainelMenu tela;
    private JogadorController jogadorController;
    private Vector<Jogador> listaOponentes;

    public TelaSelecao(PainelMenu tela, Vector<Jogador> listaOponentes)  {
        this.tela = tela;
        this.jogadorController = new JogadorController();
        this.listaOponentes = listaOponentes;

        int x = 500;
        int y = 300;

        this.setTitle("Seleção de oponente");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(null);
        this.setSize(x, y);

        //Posiciona o JFrame no centro da tela
        Point centro = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        this.setBounds((centro.x - (x/2)), (centro.y - (y/2)), x, y);

        //Título da tela
        JLabel titulo = new JLabel("Escolha seu oponente:");
        titulo.setFont(new Font("Arial", Font.PLAIN, 18));
        titulo.setBounds(50, 100, 200, 50);
        this.add(titulo);

        //Menu de seleção
        JComboBox<Jogador> opcoesOponentes = new JComboBox<>(this.listaOponentes); //JComboBox para seleção
        opcoesOponentes.setFont(new Font("Arial", Font.PLAIN, 18));
        opcoesOponentes.setBounds(260, 110, 200, 30);
        opcoesOponentes.setEditable(false);
        this.add(opcoesOponentes);

        Font fonteBotoes = new Font("Arial", Font.PLAIN, 22);

        //Botão de confirmação
        JButton ok = new JButton("OK");
        ok.addActionListener(e -> { //Chama o metodo para iniciar a partida com o jogador selecionado
            this.dispose();
            Jogador oponente = (Jogador) opcoesOponentes.getSelectedItem();

            //Inicia a partida se o oponente possui um baralho ativo
            if(oponente.getBaralhoAtual() == 0) {
                JOptionPane.showMessageDialog(this.tela, "O jogador selecionado não possui um baralho ativo",
                        "ERRO", JOptionPane.ERROR_MESSAGE);
            } else {
                this.tela.iniciarPartida(oponente);
            }
        });

        ok.setFont(fonteBotoes);
        ok.setBounds(80, 180, 80, 45);
        this.add(ok);

        //Botão de cancelar
        JButton cancelar = new JButton("Cancelar");
        cancelar.addActionListener(e -> this.dispose());
        cancelar.setFont(fonteBotoes);
        cancelar.setBounds(310, 180, 120, 45);
        this.add(cancelar);

        this.setVisible(true);
    }
}

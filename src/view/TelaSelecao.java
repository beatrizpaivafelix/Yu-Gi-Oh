package view;

import controller.JogadorController;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TelaSelecao extends JFrame {

    private TelaInicial tela;
    private JogadorController jogadorController;

    public TelaSelecao(TelaInicial tela)  {
        this.tela = tela;
        this.jogadorController = new JogadorController();

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
        titulo.setFont(new Font("Atial", Font.PLAIN, 18));
        titulo.setBounds(50, 100, 200, 50);
        this.add(titulo);

        //Obtendo oponentes do banco
        String[] listaOponentes = this.jogadorController.getOponentes();
        JComboBox<String> oponentes = new JComboBox<>(listaOponentes); //JComboBox para seleção

        this.setVisible(true);
    }
}

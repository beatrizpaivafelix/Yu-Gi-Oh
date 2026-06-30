package view;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class TelaInicial extends JFrame {

    private JPanel painelPrincipal;
    private final int x = 800, y = 800;

    public TelaInicial(String title) {
        //Inicializa o novo JFrame
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        //Posiciona o JFrame no centro da tela
        Point centro = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        this.setBounds((centro.x - (this.x/2)), (centro.y - (this.y/2)), this.x, this.y);

        //Adiciona o painel principal ao JFrame
        this.painelPrincipal = new JPanel(new BorderLayout());
        this.add(this.painelPrincipal);

        //Abre a tela inicial do programa
        this.trocarTela(new PainelInicial(this));

        this.setVisible(true); //Mostra o JFrame pronto
    }

    public void trocarTela(JPanel painel) {
        //Troca o painel atual pelo novo, centralizado
        this.painelPrincipal.removeAll();
        this.painelPrincipal.add(painel, BorderLayout.CENTER);

        //Exibe o novo painel
        this.painelPrincipal.revalidate();
        this.painelPrincipal.repaint();
    }

    static void main(String[] args) {
        TelaInicial tela = new TelaInicial("CardWars");
    }

}

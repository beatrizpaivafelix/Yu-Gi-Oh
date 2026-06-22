package view;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Set;

public class TelaInicial extends JFrame {

    private final int x = 800, y = 800;

    private JPanel painelPrincipal;
    private JScrollPane painelFundo;
    private HashMap<String, JPanel> historicoPaineis;
    private CardLayout baralhoPaineis;

    public TelaInicial(String title) {
        //Inicializa o novo JFrame com um título e define que a operação de encerramento
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Posiciona o JFrame no centro da tela
        Point centro = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        this.setBounds((centro.x - (this.x/2)), (centro.y - (this.y/2)), this.x, this.y);

        //Inicializa componentes de gerenciamento de telas
        this.historicoPaineis = new HashMap<>();
        this.baralhoPaineis = new CardLayout();

        //Adiciona painel com scrolling ao JFrame
        this.painelPrincipal = new JPanel(this.baralhoPaineis);
        this.painelFundo = new JScrollPane(this.painelPrincipal);
        this.add(this.painelFundo);

        this.trocarTela("INICIAL", new PainelInicial()); //Abre a tela inicial do programa

        this.setVisible(true); //Mostra o JFrame pronto
    }

    public void trocarTela(String title, JPanel painel) {
        Set<String> nomes = this.historicoPaineis.keySet();

        //Se o painel não existe, adiciona ao histórico e ao layout
        if(!nomes.contains(title)) {
            this.historicoPaineis.put(title, painel);
            this.painelPrincipal.add(painel, title);
        }

        this.baralhoPaineis.show(this.painelPrincipal, title); //Troca de tela
    }

}

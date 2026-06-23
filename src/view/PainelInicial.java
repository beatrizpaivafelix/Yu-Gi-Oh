package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PainelInicial extends JPanel {

    private TelaInicial tela;
    private int x, y;

    public PainelInicial(TelaInicial tela, int x, int y) {
        this.tela = tela;
        this.x = x; this.y = y;
        this.setLayout(null);

        JLabel titulo = new JLabel("Bem vindo ao CardWars!");

        //Botão de cadastro
        JButton cadastrar = new JButton("Cadastrar-se");
        cadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tela.trocarTela("CADASTRAR", new PainelCadastro(tela, x, y));
            }
        });

        //Botão de login
        JButton login = new JButton("Entrar");
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tela.trocarTela("LOGIN", new PainelLogin(tela, x, y));
            }
        });

        //Botão de sair
        JButton sair = new JButton("SAIR");
        sair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        //Posicionamento dos componentes gráficos
        titulo.setBounds(this.x/2 - 200, this.y/2 - 200, 420, 50);
        titulo.setFont(new Font("Arial", Font.PLAIN, 36));
        this.add(titulo);

        cadastrar.setBounds(this.x/2 - 110, this.y/2 - 110, 220, 50);
        cadastrar.setFont(new Font("Arial", Font.PLAIN, 30));
        this.add(cadastrar);

        login.setBounds(this.x/2 - 110, this.y/2 - 50, 220, 50);
        login.setFont(new Font("Arial", Font.PLAIN, 30));
        this.add(login);

        sair.setBounds(this.x/2 - 110, this.y/2 + 10, 220, 50);
        sair.setFont(new Font("Arial", Font.PLAIN, 30));
        this.add(sair);
    }
}

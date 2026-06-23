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

            }
        });

        //Botão de login
        JButton login = new JButton("Entrar");
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
        titulo.setBounds(this.x/2 - 200, 140, 420, 50);
        titulo.setFont(new Font("Arial", Font.PLAIN, 36));
        this.add(titulo);

        int larguraBotoes = 220;
        int xCentralizado = (this.x - larguraBotoes) / 2;

        JLabel lblUsuario = new JLabel("Username:");
        lblUsuario.setFont(new Font("Arial", Font.PLAIN, 30));
        lblUsuario.setBounds(xCentralizado - 100, 265, larguraBotoes, 25);
        this.add(lblUsuario);

        JTextField txtUsuario = new JTextField();
        txtUsuario.setFont(new Font("Arial", Font.PLAIN, 30));
        txtUsuario.setBounds(xCentralizado + 50, 260, larguraBotoes, 40);
        add(txtUsuario);

        // 3. Campo: Senha (Label + Input)
        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setFont(new Font("Arial", Font.PLAIN, 30));
        lblSenha.setBounds(xCentralizado - 50, 320, larguraBotoes, 25);
        add(lblSenha);

        JPasswordField txtSenha = new JPasswordField();
        txtSenha.setFont(new Font("Arial", Font.PLAIN, 30));
        txtSenha.setBounds(xCentralizado + 50, 310, larguraBotoes, 40);
        add(txtSenha);

        cadastrar.setBounds(xCentralizado, 390, 220, 50);
        cadastrar.setFont(new Font("Arial", Font.PLAIN, 30));
        this.add(cadastrar);

        login.setBounds(xCentralizado, 450, 220, 50);
        login.setFont(new Font("Arial", Font.PLAIN, 30));
        this.add(login);

        sair.setBounds(xCentralizado, 510, 220, 50);
        sair.setFont(new Font("Arial", Font.PLAIN, 30));
        this.add(sair);
    }
}

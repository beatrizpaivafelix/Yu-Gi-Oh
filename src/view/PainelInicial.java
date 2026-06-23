package view;

import controller.UsuarioController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PainelInicial extends JPanel {

    private TelaInicial tela;
    private int x, y;

    private UsuarioController userController;

    public PainelInicial(TelaInicial tela, int x, int y) {
        this.tela = tela;
        this.x = x; this.y = y;
        this.setLayout(null);

        this.userController = new UsuarioController();

        //Posicionamento dos componentes gráficos
        JLabel titulo = new JLabel("Bem vindo ao CardWars!");
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
        this.add(txtUsuario);

        // 3. Campo: Senha (Label + Input)
        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setFont(new Font("Arial", Font.PLAIN, 30));
        lblSenha.setBounds(xCentralizado - 50, 320, larguraBotoes, 25);
        this.add(lblSenha);

        JPasswordField txtSenha = new JPasswordField();
        txtSenha.setFont(new Font("Arial", Font.PLAIN, 30));
        txtSenha.setBounds(xCentralizado + 50, 310, larguraBotoes, 40);
        this.add(txtSenha);

        //Botão de cadastro
        JButton cadastrar = new JButton("Cadastrar-se");
        cadastrar.addActionListener(e -> {

            //Credenciais do usuário
            String username = txtUsuario.getText();
            String password = String.valueOf(txtSenha.getPassword());

            //Verificar se os campos estão preenchidos
            if(username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(tela, "ERRO: Preencha ambos os campos", "ERRO",
                        JOptionPane.ERROR_MESSAGE);

            } else if(userController.isCadastrado(username)) { //Verifica se o usuário já está cadastrado


            }
        });
        cadastrar.setBounds(xCentralizado, 390, 220, 50);
        cadastrar.setFont(new Font("Arial", Font.PLAIN, 30));
        this.add(cadastrar);

        //Botão de login
        JButton login = new JButton("Entrar");
        login.addActionListener(e -> {

        });
        login.setBounds(xCentralizado, 450, 220, 50);
        login.setFont(new Font("Arial", Font.PLAIN, 30));
        this.add(login);

        //Botão de sair
        JButton sair = new JButton("SAIR");
        sair.addActionListener(e -> System.exit(0));
        sair.setBounds(xCentralizado, 510, 220, 50);
        sair.setFont(new Font("Arial", Font.PLAIN, 30));
        this.add(sair);
    }
}

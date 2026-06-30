package view;

import controller.JogadorController;
import model.Jogador;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PainelInicial extends JPanel {

    private TelaInicial tela;
    private JogadorController jogadorController;

    public PainelInicial(TelaInicial tela) {
        this.tela = tela;
        this.setLayout(null);

        this.jogadorController = new JogadorController();

        //Posicionamento dos componentes gráficos
        JLabel titulo = new JLabel("Bem vindo ao CardWars!");
        titulo.setBounds(400 - 200, 140, 420, 50);
        titulo.setFont(new Font("Arial", Font.PLAIN, 36));
        this.add(titulo);

        int larguraBotoes = 220;
        int xCentralizado = (800 - larguraBotoes) / 2;

        JLabel lblUsuario = new JLabel("Username:");
        lblUsuario.setFont(new Font("Arial", Font.PLAIN, 30));
        lblUsuario.setBounds(xCentralizado - 100, 265, larguraBotoes, 25);
        this.add(lblUsuario);

        JTextField txtUsuario = new JTextField();
        txtUsuario.setFont(new Font("Arial", Font.PLAIN, 30));
        txtUsuario.setBounds(xCentralizado + 50, 260, larguraBotoes, 40);
        this.add(txtUsuario);

        //Botão de login
        JButton login = new JButton("Entrar");
        login.addActionListener(e -> {
            //Credenciais do usuário
            String username = txtUsuario.getText();

            //Verificar se o campo está preenchido
            if(username.isEmpty()) {
                JOptionPane.showMessageDialog(tela, "ERRO: Informe um nome de usuário", "ERRO",
                        JOptionPane.ERROR_MESSAGE);

            } else { //Os campos estão preenchidos
                ArrayList<Jogador> jogadores = this.jogadorController.getJogadores();

                if(jogadores == null) { //Erro
                    JOptionPane.showMessageDialog(tela, "ERRO: ao conectar-se com o banco de dados",
                            "ERRO", JOptionPane.ERROR_MESSAGE);

                } else {
                    boolean isCadastrado = false;

                    //Verifica se é um novo usuário
                    for(Jogador j : jogadores) {
                        if (j.getNome().equals(username)) {//Usuário já existente
                            isCadastrado = true; break;
                        }
                    }

                    if(!isCadastrado) { //Cadastra antes de entrar
                        if(!this.jogadorController.cadastrar(username)) { //Erro: Não faz login
                            JOptionPane.showMessageDialog(tela, "ERRO: ao conectar-se com o banco de dados",
                                    "ERRO", JOptionPane.ERROR_MESSAGE);
                        } else {
                            fazerLogin(username); //Entra com o username
                        }
                    } else {
                        fazerLogin(username); //Entra com o username
                    }
                }
            }
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

    //Entra com o username
    private void fazerLogin(String username) {
        ArrayList<Jogador> jogadores = this.jogadorController.getJogadores();

        for(Jogador j : jogadores) {
            if(j.getNome().equals(username))
                this.tela.trocarTela("MENU", new PainelMenu(j, this.tela));
        }
    }
}

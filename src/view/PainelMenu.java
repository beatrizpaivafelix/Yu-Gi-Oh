package view;

import model.Usuario;

import javax.swing.*;

public class PainelMenu extends JPanel {

    private Usuario usuario;
    private TelaInicial tela;
    private int x, y;

    public PainelMenu(Usuario usuario, TelaInicial tela, int x, int y) {
        this.usuario = usuario;
        this.tela = tela;
        this.x = x; this.y = y;

    }
}

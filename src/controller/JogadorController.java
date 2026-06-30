package controller;

import dao.JogadorDAO;
import model.Jogador;
import java.util.ArrayList;

public class JogadorController {

    private JogadorDAO jogadorDAO;

    public JogadorController() {
        this.jogadorDAO = new JogadorDAO();
    }

    public String isCadastrado(String username) { return this.jogadorDAO.existeJogador(username); }

    public boolean cadastrar(String username) {
        return this.jogadorDAO.insertJogador(username);
    }

    public ArrayList<Jogador> getJogadores() { return this.jogadorDAO.getJogadores(); }

    public String[] getOponentes() { return this.jogadorDAO.getOponentes(); }

}

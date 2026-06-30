package controller;

import dao.JogadorDAO;
import model.Jogador;
import java.util.ArrayList;
import java.util.Vector;

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

    public Vector<Jogador> getOponentes(Jogador j) { return this.jogadorDAO.getOponentes(j); }

}

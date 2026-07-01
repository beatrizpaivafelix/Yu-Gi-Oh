package controller;

import dao.CartaDAO;
import model.Carta;

import java.util.ArrayList;

public class CartaController {

    private CartaDAO cartaDAO;

    public CartaController() {
        this.cartaDAO = new CartaDAO();
    }

    public ArrayList<Carta> getCartas() {
        return this.cartaDAO.getCartas();
    }

}

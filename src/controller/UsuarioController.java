package controller;

import dao.UsuarioDAO;

public class UsuarioController {

    private UsuarioDAO userSQL;

    public UsuarioController() {
        this.userSQL = new UsuarioDAO();
    }

    public boolean isCadastrado(String username) { return userSQL.getUsuario(username); }

}

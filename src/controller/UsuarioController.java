package controller;

import dao.UsuarioDAO;
import model.Usuario;
import java.util.ArrayList;

public class UsuarioController {

    private UsuarioDAO userSQL;

    public UsuarioController() {
        this.userSQL = new UsuarioDAO();
    }

    public String isCadastrado(String username) { return userSQL.existeUsuario(username); }

    public boolean cadastrar(String username, String password) {
        return userSQL.insertUsuario(username, password);
    }

    public ArrayList<Usuario> getUsuarios() { return userSQL.getUsuarios(); }

}

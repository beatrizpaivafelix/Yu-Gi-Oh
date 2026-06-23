package dao;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    //Retorna se existe um usuário no banco com o nome informado
    public String existeUsuario(String username) {
        try (Connection conexao = ConexaoMySQL.getConnection()) { //Abre conexão com o banco

            //Preparando SQL de consulta
            String sql = "SELECT * FROM usuario WHERE idUsuario = ?;";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, username);

            ResultSet resultados = statement.executeQuery(); //Executa a SQL
            return resultados.next() ? "SIM" : "NAO"; //Retorna SIM se o usuário está cadastrado

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return "ERRO"; //Erro
        }
    }

    public boolean insertUsuario(String username, String password) {
        try (Connection conexao = ConexaoMySQL.getConnection()) { //Abre conexão com o banco

            //Preparando SQL de inserção
            String sql = "INSERT INTO usuario (nome, senha) VALUES (?, ?);";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);

            statement.executeUpdate(); //Executa a SQL
            return true; //Sucesso na inserção

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false; //Erro
        }
    }

}

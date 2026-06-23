package dao;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    //Retorna se existe um usuário no banco com o nome informado
    public boolean getUsuario(String username) {
        try (Connection conexao = ConexaoMySQL.getConnection()) { //Abre conexão com o banco

            //Preparando SQL de consulta
            String sql = "SELECT * FROM usuario WHERE idUsuario = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, username);

            ResultSet resultados = statement.executeQuery(); //Executa a SQL
            return resultados.next(); //Retorna verdadeiro se há retorno na consulta

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "ERRO ao conectar com o banco", "ERRO",
                    JOptionPane.ERROR_MESSAGE);
            return false; //Erro
        }
    }
}

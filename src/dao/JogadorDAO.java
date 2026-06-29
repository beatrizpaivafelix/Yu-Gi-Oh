package dao;

import model.Jogador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class JogadorDAO {

    //Retorna se existe um usuário no banco com o nome informado
    public String existeJogador(String username) {
        try (Connection conexao = ConexaoMySQL.getConnection()) { //Abre conexão com o banco

            //Preparando SQL de consulta
            String sql = "SELECT * FROM jogador WHERE nome = ?;";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, username);

            ResultSet resultados = statement.executeQuery(); //Executa a SQL
            return resultados.next() ? "SIM" : "NAO"; //Retorna SIM se o usuário está cadastrado

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return "ERRO"; //Erro
        }
    }

    //Registra um usuario no banco
    public boolean insertJogador(String username) {
        try (Connection conexao = ConexaoMySQL.getConnection()) { //Abre conexão com o banco

            //Preparando SQL de inserção
            String sql = "INSERT INTO jogador (nome) VALUES (?);";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, username);

            statement.executeUpdate(); //Executa a SQL
            return true; //Sucesso na inserção

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false; //Erro
        }
    }

    //Retorna todos os usuarios do banco
    public ArrayList<Jogador> getJogadores() {
        try (Connection conexao = ConexaoMySQL.getConnection()) {

            //Preparando SQL de consulta
            String sql = "SELECT * FROM jogador;";
            PreparedStatement statement = conexao.prepareStatement(sql);

            ResultSet resultados = statement.executeQuery();
            ArrayList<Jogador> retorno = new ArrayList<>();

            while(resultados.next()) {
                Jogador u = new Jogador(resultados.getString("nome"));
                retorno.add(u);
            }

            return retorno; //Retorna array com todos os usuarios cadastrados
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

}

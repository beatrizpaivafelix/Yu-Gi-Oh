package dao;

import model.Carta;
import model.Magia;
import model.Monstro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CartaDAO {

    //Retorna todas as cartas registradas no banco
    public ArrayList<Carta> getCartas() {
        try (Connection conexao = ConexaoMySQL.getConnection()) {

            //Preparando SQL
            String sql = "SELECT c.nome, c.descricao, m.ATK, m.DEF, ma.efeito " +
                    "FROM carta AS C " +
                    "LEFT JOIN monstro AS m ON c.idCarta = m.idCarta " +
                    "LEFT JOIN magia AS ma ON c.idCarta = ma.idCarta ";

            PreparedStatement statement = conexao.prepareStatement(sql);
            ResultSet resultados = statement.executeQuery();

            ArrayList<Carta> retorno = new ArrayList<>();
            while(resultados.next()) {
                if(resultados.getString("efeito") == null) { //É um monstro
                    Monstro m = new Monstro(resultados.getString("nome"),
                            resultados.getString("descricao"), resultados.getInt("ATK"),
                            resultados.getInt("DEF"));

                    retorno.add(m);

                } else { //É uma magia
                    Magia m = new Magia(resultados.getString("nome"),
                            resultados.getString("descricao"), resultados.getString("efeito"));

                    retorno.add(m);
                }
            }

            return retorno;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    //Retorna todas as cartas de um baralho
    public ArrayList<Carta> getCartasBaralho() {
        return null;
    }

}

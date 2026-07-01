package dao;

import model.Baralho;
import model.Carta;
import model.Jogador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BaralhoDAO {

    private CartaDAO cartaDAO;

    private BaralhoDAO() { this.cartaDAO = new CartaDAO(); }

    //Obtém todos os baralhos do jogador atual no banco
    public ArrayList<Baralho> getBaralhos(Jogador jogadorAtual) {
        try (Connection conexao = ConexaoMySQL.getConnection()) {

            //Preparando sql de consulta
            String sql = "SELECT idBaralho, nomeJogador, nomeBaralho FROM baralho JOIN jogador " +
                    "ON baralho.nomeJogador = jogador.nome;";

            PreparedStatement statement = conexao.prepareStatement(sql);
            ResultSet resultados = statement.executeQuery();

            ArrayList<Baralho> retorno = new ArrayList<>();
            while(resultados.next()) {
                String nomeBaralho = resultados.getString("nomeBaralho");
                ArrayList<Carta> cartas = this.cartaDAO.getCartas();

                Baralho b = new Baralho();
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

}

package org.example.produto;
import org.example.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutoDAO {
    public void inserir(String nome, double preco, int quantidade) {
        String sql = "INSERT INTO produtos (nome, preco, quantidade) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setDouble(2, preco);
            stmt.setInt(3, quantidade);
            stmt.executeUpdate();

            System.out.println("Produto inserido com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void AtualizarPreco(String nome, Double novoPreco){
        String sql = "UPDATE produtos SET preco = ? WHERE nome = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement st = conn.prepareStatement(sql)) {

                 st.setDouble(1,novoPreco);
                 st.setString(2,nome);
                 st.executeUpdate();

              System.out.println("Novo preço atualizado com sucesso!");
        } catch (SQLException e){
                 e.printStackTrace();
        }

    }

    public void deletarProduto(String nomeProduto){
        String sql = "DELETE FROM produtos WHERE nome = ? ";

        try(Connection conn = Conexao.conectar();
        PreparedStatement st = conn.prepareStatement(sql)){

            st.setString(1,nomeProduto);
            st.executeUpdate();



            System.out.println("Produto removido com sucesso!");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}


package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

public class PedidoDAO {
    public void inserir(String cliente, Date dataPedido, double total) {
        String sql = "INSERT INTO pedidos (cliente, data_pedido, total) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente);
            stmt.setDate(2, dataPedido);
            stmt.setDouble(3, total);
            stmt.executeUpdate();

            System.out.println("Pedido inserido com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

package org.example.pedido;

import org.example.Conexao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PedidoDAO {
    public void inserir(String cliente, Date dataPedido, double total, int id) {
        String sql = "INSERT INTO pedidos (cliente, data_pedido, total, id) VALUES (?, ?, ?, ?)";


        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {


            stmt.setString(1, cliente);
            stmt.setDate(2, dataPedido);
            stmt.setDouble(3, total);
            stmt.setDouble(4, id);
            stmt.executeUpdate();

            System.out.println("Pedido inserido com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

   public void AtualizarValorTotal(int id, double novoValor ){
        String sql = "UPDATE pedidos SET total = ?  WHERE id = ?";

        try(Connection conn = Conexao.conectar();
            PreparedStatement st = conn.prepareStatement(sql)){

            st.setDouble(1,novoValor);
            st.setInt(2,id);
            st.executeUpdate();

            System.out.println("Valor total atualizado com sucesso!");
        } catch (SQLException e){
            e.printStackTrace();
        }
   }

   public void deletarPedido( int id){
    String sql = "DELETE FROM pedidos WHERE id = ?";

    try(Connection conn = Conexao.conectar();
    PreparedStatement st = conn.prepareStatement(sql)){


        st.setInt(1,id);
        st.executeUpdate();

        System.out.println("Pedido removido com sucesso!");

    }  catch (SQLException e){
        e.printStackTrace();

    }

    }
}

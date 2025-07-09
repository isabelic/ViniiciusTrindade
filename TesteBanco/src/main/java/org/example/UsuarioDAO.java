package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDAO {
    public void inserir(String nome, String email) {
        String sql = "INSERT INTO usuarios (nome, email) VALUES (?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.executeUpdate();

            System.out.println("Usuário inserido com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

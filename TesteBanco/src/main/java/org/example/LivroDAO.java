package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LivroDAO {
    public void inserir(String titulo, String autor, int anoPublicacao) {
        String sql = "INSERT INTO livros (titulo, autor, ano_publicacao) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, titulo);
            stmt.setString(2, autor);
            stmt.setInt(3, anoPublicacao);
            stmt.executeUpdate();

            System.out.println("Livro inserido com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

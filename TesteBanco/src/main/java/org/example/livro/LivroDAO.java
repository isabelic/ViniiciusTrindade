package org.example.livro;

import org.example.Conexao;

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
    public void AtualizarAutor(String titulo, String novoAutor){
        String sql = "UPDATE livros SET autor = ? WHERE titulo = ?";

        try(Connection conn =  Conexao.conectar();
        PreparedStatement st = conn.prepareStatement(sql)){

            st.setString(1, novoAutor);
            st.setString(2,titulo);
            st.executeUpdate();

            System.out.print("Novo autor adicionado com sucesso!");

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void deletarLivro(String titulo){
        String sql = "DELETE FROM livros WHERE titulo = ? ";

        try (Connection conn = Conexao.conectar();
        PreparedStatement st = conn.prepareStatement(sql)){

            st.setString(1,titulo);
            st.executeUpdate();

            System.out.println("Livro removido com sucesso!");

        }  catch (SQLException e){
            e.printStackTrace();

}
        }
    }


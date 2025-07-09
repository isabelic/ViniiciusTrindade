package org.example.usuario;

import org.example.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDAO {

    // Método para inserir um novo usuário no banco, recebendo nome e email como parâmetros
    public void inserir(String nome, String email) {

        // Query SQL para inserir dados na tabela 'usuarios', usando placeholders (?) para evitar SQL injeção
        String sql = "INSERT INTO usuarios (nome, email) VALUES (?, ?)";

        //  Try está abrindo um conexão e preparando o comando SQL garantindo que sejam fechados automaticamente
        try (Connection conn = Conexao.conectar();                 // Abre conexão com o banco
             PreparedStatement stmt = conn.prepareStatement(sql)) { // Prepara a consulta para execução

            // Define o primeiro parâmetro (?) da query com o valor da variável 'nome' e 'email'
            stmt.setString(1, nome);
            stmt.setString(2, email);

            // Executa a query (INSERT) no banco de dados
            stmt.executeUpdate();

            System.out.println("Usuário inserido com sucesso!");
        } catch (SQLException e) {
            // Caso ocorra algum erro na operação com o banco, imprime os erros no console
            e.printStackTrace();
        }
    }


    public void atualizarEmail(String nome, String novoEmail) {
        String sql = "UPDATE usuarios SET email = ? WHERE nome = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, novoEmail);
            stmt.setString(2, nome);
            stmt.executeUpdate();

            System.out.println("Email atualizado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public void deletarUsuario(String nome) {
        String sql = "DELETE FROM usuarios WHERE nome = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.executeUpdate();

            System.out.println("Usuário deletado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

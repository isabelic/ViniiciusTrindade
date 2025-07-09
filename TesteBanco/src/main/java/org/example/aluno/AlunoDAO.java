package org.example.aluno;
import org.example.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AlunoDAO {

    public void inserir(String nome, String matricula, String curso) {
        String sql = "INSERT INTO alunos (nome, matricula, curso) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setString(2, matricula);
            stmt.setString(3, curso);
            stmt.executeUpdate();

            System.out.println("Aluno inserido com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void atualizarCurso(String matricula, String novoCurso) {

        // Comando SQL que atualiza o curso onde a matrícula for correspondente
        String sql = "UPDATE alunos SET curso = ? WHERE matricula = ?";


        try (Connection conn = Conexao.conectar(); // Obtém uma conexão com o banco de dados
             PreparedStatement stmt = conn.prepareStatement(sql)) { // Prepara a instrução SQL para execução

            // Define o novo curso no primeiro parâmetro do SQL (primeiro '?')
            stmt.setString(1, novoCurso);
            stmt.setString(2, matricula);

            // Executa a atualização no banco de dados
            stmt.executeUpdate();


            System.out.println("Curso atualizado com sucesso!");

        } catch (SQLException e) {
            // Caso ocorra um erro de SQL, imprime a stack trace para depuração
            e.printStackTrace();
        }
    }


    public void deletarAluno(String matriculaA) {
        String sql = "DELETE FROM alunos WHERE matricula = ?";


        try (Connection conn = Conexao.conectar();
             PreparedStatement st = conn.prepareStatement(sql)) {

            st.setString(1, matriculaA);


            st.executeUpdate();

            System.out.println("Aluno removido com sucesso!");

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}







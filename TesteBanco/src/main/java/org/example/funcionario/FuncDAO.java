package org.example.funcionario;

import org.example.Conexao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FuncDAO {
    public void inserir(String nome, String cargo, double salario) {
        String sql = "INSERT INTO funcionarios (nome, cargo, salario) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setString(2, cargo);
            stmt.setDouble(3, salario);
            stmt.executeUpdate();

            System.out.println("Funcionário inserido com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarSalario(String nome, double novoSalario) {
        String sql = "UPDATE funcionarios SET salario = ? WHERE nome = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement st = conn.prepareStatement(sql)) {

            st.setDouble(1, novoSalario);
            st.setString(2, nome);
            st.executeUpdate();

            System.out.println("Salário atualizado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void deletarFuncionario(String nome) {
        String sql = "DELETE FROM funcionarios WHERE nome = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.executeUpdate();

            System.out.println("Funcionário removido com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
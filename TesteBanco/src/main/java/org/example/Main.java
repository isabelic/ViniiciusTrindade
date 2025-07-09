package org.example;

import java.util.Scanner;
import java.sql.Connection;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String nome;
        String email;
        String matricula;
        String curso;


        UsuarioDAO user = new UsuarioDAO();

        System.out.println("Digite seu nome: ");
        nome = sc.nextLine();

        System.out.println("Digite seu curso: ");
        email = sc.nextLine();

        System.out.println("Digite sua matricula: ");
        matricula = sc.nextLine();

        Usuario u = new Usuario(nome, email);

        //user.inserir("iz", "teste@gmail.com");


        // ALUNO
        AlunoDAO aluno = new AlunoDAO();
        aluno.inserir("valetim", "2025001", "TI");

        //PRODUTO
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.inserir("Caneta", 2.50, 100);

        //PEDIDO
        PedidoDAO pedidoDAO = new PedidoDAO();
        pedidoDAO.inserir("bruno", "2025-12-02", 150.00);

        //LIVRO
        LivroDAO livroDAO = new LivroDAO();
        livroDAO.inserir("Dom Casmurro", "Machado de Assis", 1899);

        //FUNCIONARIO
        FuncDAO funcionarioDAO = new FuncDAO();
        funcionarioDAO.inserir("iz", "chefe", 7000.00);


    }


}

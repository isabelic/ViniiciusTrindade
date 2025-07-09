package org.example;

import org.example.aluno.AlunoDAO;
import org.example.funcionario.FuncDAO;
import org.example.livro.LivroDAO;
import org.example.pedido.PedidoDAO;
import org.example.produto.ProdutoDAO;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner iz = new Scanner(System.in);
        int op;

        AlunoDAO alunoDAO = new AlunoDAO();
        ProdutoDAO produtoDAO = new ProdutoDAO();
        PedidoDAO pedidoDAO = new PedidoDAO();
        LivroDAO livroDAO = new LivroDAO();
        FuncDAO funcionarioDAO = new FuncDAO();

        do {
            System.out.println("\n///////// MENU GERAL /////////");
            System.out.println("1. Cadastrar");
            System.out.println("2. Atualizar");
            System.out.println("3. Remover");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            op = iz.nextInt();
            iz.nextLine();

            switch (op) {// ----------- CADASTRO -----------
                case 1:
                    int opCadastrar;
                    do {
                        System.out.println("\n///////// MENU DE CADASTRO /////////");
                        System.out.println("1. Cadastrar Aluno");
                        System.out.println("2. Cadastrar Produto");
                        System.out.println("3. Cadastrar Pedido");
                        System.out.println("4. Cadastrar Livro");
                        System.out.println("5. Cadastrar Funcionário");
                        System.out.println("0. Voltar");
                        System.out.print("Escolha uma opção: ");
                        opCadastrar = iz.nextInt();
                        iz.nextLine();

                        switch (opCadastrar) {
                            case 1:
                                System.out.print("Nome do aluno: ");
                                String nomeAluno = iz.nextLine();
                                System.out.print("Matrícula: ");
                                String matricula = iz.nextLine();
                                System.out.print("Curso: ");
                                String curso = iz.nextLine();
                                alunoDAO.inserir(nomeAluno, matricula, curso);
                                break;

                            case 2:
                                System.out.print("Nome do produto: ");
                                String nomeProduto = iz.nextLine();
                                System.out.print("Preço: ");
                                double preco = iz.nextDouble();
                                System.out.print("Estoque: ");
                                int estoque = iz.nextInt();
                                produtoDAO.inserir(nomeProduto, preco, estoque);
                                break;

                            case 3:
                                System.out.print("Nome do cliente: ");
                                String cliente = iz.nextLine();
                                System.out.print("Data do pedido (AAAA-MM-DD): ");
                                String dataStr = iz.nextLine();
                                LocalDate data = LocalDate.parse(dataStr);
                                System.out.print("Total do pedido: ");
                                double total = iz.nextDouble();
                                System.out.print("Digite o ID: ");
                                int id = iz.nextInt();
                                pedidoDAO.inserir(cliente, Date.valueOf(data), total, id);
                                break;

                            case 4:
                                System.out.print("Título do livro: ");
                                String titulo = iz.nextLine();
                                System.out.print("Autor: ");
                                String autor = iz.nextLine();
                                System.out.print("Ano de publicação: ");
                                int ano = iz.nextInt();
                                livroDAO.inserir(titulo, autor, ano);
                                break;

                            case 5:
                                System.out.print("Nome do funcionário: ");
                                String nomeFunc = iz.nextLine();
                                System.out.print("Cargo: ");
                                String cargo = iz.nextLine();
                                System.out.print("Salário: ");
                                double salario = iz.nextDouble();
                                funcionarioDAO.inserir(nomeFunc, cargo, salario);
                                break;

                            case 0:
                                System.out.println("Voltando ao menu principal..");
                                break;

                            default:
                                System.out.println("Opção inválida. Tente novamente!");
                        }

                    } while (opCadastrar != 0);
                    break;

                                          // ----------- ATUALIZAÇÃO -----------
                case 2:
                    int opAtualizar;
                    do {
                        System.out.println("\n///////// MENU DE ATUALIZAÇÃO /////////");
                        System.out.println("1. Atualizar curso de um Aluno");
                        System.out.println("2. Atualizar preço de um Produto");
                        System.out.println("3. Atualizar valor total de um Pedido");
                        System.out.println("4. Atualizar autor de um Livro");
                        System.out.println("5. Atualizar salário de um Funcionário");
                        System.out.println("0. Voltar");
                        System.out.print("Escolha uma opção: ");
                        opAtualizar = iz.nextInt();
                        iz.nextLine();

                        switch (opAtualizar) {
                            case 1:
                                System.out.print("Digite a matrícula do aluno: ");
                                String matriculaUpdate = iz.nextLine();
                                System.out.print("Novo curso: ");
                                String novoCurso = iz.nextLine();

                                alunoDAO.atualizarCurso(matriculaUpdate, novoCurso);
                                break;

                            case 2:
                                System.out.print("Nome do produto que deseja fazer a alteração: ");
                                String nomeUpdate = iz.next();
                                System.out.print("Novo preço: ");
                                Double novoPreco = iz.nextDouble();

                                produtoDAO.AtualizarPreco(nomeUpdate, novoPreco);
                                break;

                            case 3:
                                System.out.print("ID do pedido: ");
                                int idUpdate = iz.nextInt();
                                System.out.print("Novo valor: ");
                                Double novoValor = iz.nextDouble();

                                pedidoDAO.AtualizarValorTotal(idUpdate, novoValor);
                                break;

                            case 4:
                                iz.nextLine();
                                System.out.print("Título do livro que deseja alterar o autor: ");
                                String tituloUpdate = iz.nextLine();
                                System.out.print("Novo autor: ");
                                String novoAutor = iz.nextLine();
                                livroDAO.AtualizarAutor(tituloUpdate, novoAutor);
                                break;

                            case 5:
                                System.out.print("Nome do funcionário: ");
                                String nUpdate = iz.next();
                                System.out.print("Novo salário: ");
                                double novoSalario = iz.nextDouble();
                                funcionarioDAO.atualizarSalario(nUpdate, novoSalario);
                                break;

                            case 0:
                                System.out.println("Voltando ao menu principal..");
                                break;

                            default:
                                System.out.println("Opção inválida. Tente novamente!");
                        }

                    } while (opAtualizar != 0);
                    break;

                case 3: // ----------- REMOÇÃO -----------
                    int opRemover;
                    do {
                        System.out.println("\n///////// MENU DE REMOÇÃO /////////");
                        System.out.println("1. Deletar Aluno");
                        System.out.println("1. Deletar Produto");
                        System.out.println("1. Deletar Pedido");
                        System.out.println("1. Deletar Livro");
                        System.out.println("1. Deletar Funcionário");
                        System.out.println("0. Voltar");
                        System.out.print("Escolha uma opção: ");
                        opRemover = iz.nextInt();
                        iz.nextLine();

                        switch (opRemover) {
                            case 1:
                                System.out.print("Informe a matrícula do aluno: ");
                                String matriculaA = iz.next();
                                alunoDAO.deletarAluno(matriculaA);
                                break;

                            case 2:
                                System.out.println("Informe o nome do Produto: ");
                                String nomePro = iz.next();

                                produtoDAO.deletarProduto(nomePro);
                                break;
                            case 3:
                                System.out.println("Informe o ID do Pedido: ");
                                int idDel = iz.nextInt();

                                pedidoDAO.deletarPedido(idDel);
                                break;

                            case 4:
                                System.out.println("Informe o titulo do Livro: ");
                                String tituloDel = iz.next();

                                livroDAO.deletarLivro(tituloDel);
                                break;


                            case 5:
                                System.out.println("Informe o nome do Funcionário: ");
                                String nomeFuncDel = iz.nextLine();

                                FuncDAO.deletarFuncionario(nomeFuncDel);
                                break;


                            case 0:
                                System.out.println("Voltando ao menu principal..");
                                break;

                            default:
                                System.out.println("Opção inválida. Tente novamente!");
                        }

                    } while (opRemover != 0);
                    break;

                case 0:
                    System.out.println("Saindo do sistema..");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente!");
            }

        } while (op != 0);

        iz.close();
    }
}

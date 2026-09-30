package br.edu.aesa.app;

import java.util.Scanner;

import br.edu.aesa.model.product;
import br.edu.aesa.service.productService;

public class app {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        productService service = new productService();

        int option = 0;

        do {
            clear();
            System.out.println("\n--- Sistema de Gerenciamento de Produtos ---");
            System.out.println("[1] Cadastrar novo registro");
            System.out.println("[2] Listar todos os registos");
            System.out.println("[3] Buscar registro por ID");
            System.out.println("[4] Atualizar registro");
            System.out.println("[5] Remover registro");
            System.out.println("[0] Sair do programa");
            System.out.print("Escolha uma opção: ");

            option = scanner.nextInt();

            try {
                switch (option) {

                    // cadastrar
                    case 1:
                        clear();

                        System.out.println("Digite a chave para o novo produto");
                        System.out.print("Inteiro:");
                        int key = scanner.nextInt();

                        scanner.nextLine();

                        System.out.println("Nome do produto");
                        String name = scanner.nextLine();

                        System.out.println("Descrição para o produto");
                        String description = scanner.nextLine();

                        product newproduct = new product(key, name, description);
                        boolean registered = service.canRegister(newproduct);

                        if (registered == true) {
                            System.out.println("Produto cadastrado com sucesso");
                        } else {
                            System.out.println("O id do Produto já existe");
                        }
                        wait(2);
                        break;

                    // listar produtos
                    case 2:

                        clear();
                        service.listAll();
                        scanner.nextLine();
                        scanner.nextLine();

                        break;

                    // Buscar registro por ID
                    case 3:

                        clear();
                        System.out.println("Digite a chave ID que deseja Buscar:");
                        int Id = scanner.nextInt();

                        boolean exists = service.productexists(Id);
                        if (exists == false) {
                            System.out.println("Esse produto não existe");
                            scanner.nextLine();
                            scanner.nextLine();
                            break;
                        } else {
                            clear();
                            product display = service.search(Id);
                            System.out.println("Id: " + display.getId() + "\nNome: " + display.getName()
                                    + "\nDescrição: " + display.getdescription());
                            scanner.nextLine();
                            scanner.nextLine();
                        }

                        break;

                    // atualizar registro
                    case 4:
                        clear();
                        System.out.println("Digite a chave ID que deseja atualizar:");
                        int oldId = scanner.nextInt();
                        boolean exists2 = service.productexists(oldId);

                        if (exists2 == true) {
                            clear();
                            System.out.print("Nova chave: ");
                            int newKey = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Novo nome: ");
                            String newName = scanner.nextLine();

                            System.out.print("Nova Descrição: ");
                            String newDescription = scanner.nextLine();

                            boolean updated = service.updateProduct(oldId, newKey, newName, newDescription);
                            if (updated == true) {
                                System.out.println("Produto atualizado");
                            } else {
                                System.out.println("erro ao atualizar Id ja utilizado");
                                scanner.nextLine();
                                scanner.nextLine();
                            }

                        } else {
                            System.out.println("O produto não existe");
                            scanner.nextLine();
                            scanner.nextLine();
                        }

                        break;

                    case 5:
                        clear();
                        System.out.println("Digite o id do produto a ser removido");
                        int id2 = scanner.nextInt();
                        boolean deleted = service.deleteProduct(id2);
                        if (deleted == true) {
                            System.out.println("Deletado com sucesso.");
                        } else {
                            System.out.println("O produto não existe");
                        }
                        scanner.nextLine();
                        scanner.nextLine();
                        break;

                    case 0:
                        System.out.println("A sair do programa...");
                        wait(2);
                        break;
                    default:
                        clear();
                        System.out.println("Digite uma opção válida!");
                        break;
                }

            } catch (Exception e) {
                scanner.nextLine(); // limpar o buffer evita o codigo ficar em loop
                System.out.println("Erro digite um número válido");
                scanner.nextLine();
            }

        } while (option != 0);

        scanner.close();
    }

    // limpa tela
    public static void clear() {
        try {
            String sistema = System.getProperty("os.name").toLowerCase();
            if (sistema.contains("windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // aguardar
    public static void wait(int segundos) {
        try {
            Thread.sleep(segundos * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
package app;

import java.util.Scanner;

public class app {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

     int option = 0;

         do {

            System.out.println("\n--- Sistema de Gerenciamento de Produtos ---");
            System.out.println("[1] Cadastrar novo registro");
            System.out.println("[2] Listar todos os registos");
            System.out.println("[3] Buscar registro por ID");
            System.out.println("[4] Atualizar registro");
            System.out.println("[5] Remover registro");
            System.out.println("[0] Sair do programa");
            System.out.print("Escolha uma opção: ");

            option = scanner.nextInt();
            
            switch (option) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 0:
                    System.out.println("A sair do programa...");
                    esperar(2);
                    break;
                default:
                    limpar();
                    System.out.println("Digite uma opção válida!");
                    break;
            }
        } while (option != 0);
        scanner.close();
    }

    //limpa tela
    public static void limpar() {
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

    //aguardar
    public static void esperar(int segundos) {
        try {
            Thread.sleep(segundos * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
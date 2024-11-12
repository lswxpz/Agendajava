import java.util.Scanner;

public class AgendaConsole {

    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("1. Adicionar Contato");
            System.out.println("2. Remover Contato");
            System.out.println("3. Listar Contatos");
            System.out.println("4. Buscar Contato");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    agenda.adicionarContato(new Contato(nome, telefone, email));
                    break;
                case 2:
                    System.out.print("Nome do contato a remover: ");
                    nome = scanner.nextLine();
                    agenda.removerContato(nome);
                    break;
                case 3:
                    for (Contato contato : agenda.listarContatos()) {
                        System.out.println(contato);
                    }
                    break;
                case 4:
                    System.out.print("Nome do contato a buscar: ");
                    nome = scanner.nextLine();
                    Contato contato = agenda.buscarContato(nome);
                    if (contato != null) {
                        System.out.println(contato);
                    } else {
                        System.out.println("Contato não encontrado.");
                    }
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 5);

        scanner.close();
    }
}
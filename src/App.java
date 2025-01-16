import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        BancoDeDados bancodeDados = new BancoDeDados();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        bancodeDados.addEntrada("salário", 500, 11, 05, 2024, true);
        bancodeDados.addEntrada("mercado", 200, 11, 06, 2024, false);
        int id;

        while (running) {
            System.out.print(
                "\n==== Menu Banco de Dados ====\n" +
                "1. Adicionar Entrada\n" +
                "2. Visualizar Entradas\n" +
                "3. Visualizar Entrada por ID\n" +
                "4. Atualizar Entrada\n" +
                "5. Remover Entrada\n" +
                "6. Sair\n" +
                "Escolha uma opção: "
            );
            switch (scanner.nextInt()) {
                case 1:
                    System.out.print("Digite o nome da entrada: ");
                    String nomee = scanner.nextLine();
                    nomee = scanner.nextLine();
                    System.out.print("Digite o valor da entrada: ");
                    double valor = scanner.nextDouble();
                    System.out.println("Digite uma data dia, após o mês e após o ano: ");
                    int dia = scanner.nextInt();
                    int mes = scanner.nextInt();
                    int ano = scanner.nextInt();
                    System.out.println("Me diga como entrada é uma Receita(true) ou Despesa(false): ");
                    boolean status = scanner.nextBoolean();
                    bancodeDados.addEntrada(nomee, valor, dia, mes, ano, status);
                    break;
                case 2:
                    bancodeDados.verEntradas();
                    break;
                case 3:
                    System.out.println("Digite o id da entrada que deseja visualizar:");
                    bancodeDados.verEntrada(scanner.nextInt());
                    break;
                case 4:
                    System.out.println("Digite o id da entrada: ");
                    id = scanner.nextInt();

                    System.out.println(
                        "Menu de Atualização de Entradas:\n" +
                        "1. Atualizar Nome\n" +
                        "2. Atualizar Valor\n" +
                        "3. Atualizar Dia\n" +
                        "4. Atualizar Mês\n" +
                        "5. Atualizar Ano\n" +
                        "6. Atualizar Status\n" +
                        "7. Sair\n" +
                        "Escolha uma opção: "
                    );
                    switch (scanner.nextInt()) {
                        case 1:
                            bancodeDados.verEntrada(id);
                            System.out.println("Qual nome você deseja colocar?");
                            bancodeDados.attNome(id, scanner.nextLine());
                            break;
                        case 2:
                        bancodeDados.verEntrada(id);
                        System.out.println("Qual valor você deseja colocar?");
                        bancodeDados.attValor(id, scanner.nextDouble());
                            break;
                        case 3:
                            bancodeDados.verEntrada(id);
                            System.out.println("Qual dia você deseja colocar?");
                            bancodeDados.attDia(id, scanner.nextInt());
                            break;
                        case 4:
                            bancodeDados.verEntrada(id);
                            System.out.println("Qual mês você deseja colocar?");
                            bancodeDados.attMes(id, scanner.nextInt());
                            break;
                        case 5:
                            bancodeDados.verEntrada(id);
                            System.out.println("Qual ano você deseja colocar?");
                            bancodeDados.attAno(id, scanner.nextInt());
                            break;
                        case 6:
                            bancodeDados.verEntrada(id);
                            System.out.println("Qual status você deseja colocar?\nTrue=Receita / False=Despesa\n");
                            bancodeDados.attStatus(id, scanner.nextBoolean());
                            break;
                        default:
                            break;
                    }
                    break;
                case 5:
                    System.out.println("Digite o id da entrada que deseja remover: ");
                    id = scanner.nextInt();
                    bancodeDados.removeEntrada(id);
                    break;
                case 6:
                running = false;
                    break;
                default:
                    break;
            }
        }
        scanner.close();
    }
}

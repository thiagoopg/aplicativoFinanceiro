package java.com.app;
import java.util.Scanner;
import java.time.LocalDate;


public class Main {
    public static LocalDate pedeData() {
        
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        int[] data = new int[3];
        
        System.out.print("Digite uma data no formato dd/mm/aaaa: ");
        //lê a data inteira como uma string
        String input = scanner.nextLine();
        
        //divide a string com base no delimitador "/"
        String[] partes = input.split("/");
        
        //converte as partes em inteiros
        data[0] = Integer.parseInt(partes[0]);
        data[1] = Integer.parseInt(partes[1]);
        data[2] = Integer.parseInt(partes[2]);
        //finaliza o scanner
        //transforma em localdate
        LocalDate localdate = LocalDate.of(data[2], data[1], data[0]);
        return localdate;
    }
    public static void main(String[] args){
        BancoDeDados bancodeDados = new BancoDeDados();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        String nome;
        double valor;
        LocalDate data;
        LocalDate dataFinal;
        boolean status;

        int switchPrincipal;
        int switchSecundario;

        bancodeDados.addEntrada("salário", 500, 11, 05, 2024, true);
        bancodeDados.addEntrada("mercado", 200, 11, 06, 2024, false);
        bancodeDados.addEntrada("13 salário", 1000, 11, 05, 2024, true);
        bancodeDados.addEntrada("carro", 150, 11, 06, 2024, false);
        int id;

        while (running) {
            System.out.print(
                "\n==== Menu Banco de Dados ====\n\n" +
                "Salto total: " + bancodeDados.getValorTotal() +
                "\n\n1. Adicionar Entrada\n" +
                "2. Visualizar Entradas\n" +
                "3. Visualizar Entrada por ID\n" +
                "4. Visualizar Entrada por Tipo\n" +
                "5. Visualizar Entradas entre Datas\n" +
                "6. Atualizar Entrada\n" +
                "7. Remover Entrada\n" +
                "8. Sair\n" +
                "Escolha uma opção: "
            );
            switchPrincipal = scanner.nextInt(); //Utilizando o ID para poder usar o nextInt fora do switch e conseguir usar a quebra de linha que o scanner não oferece nos nextInt e nextDouble. Que é solucionado, ao usar um scanner.nextLine(); após.
            scanner.nextLine();
            switch (switchPrincipal) {
                case 1:
                    System.out.print("Digite o nome da entrada: ");
                    nome = scanner.nextLine();
                    System.out.print("Digite o valor da entrada: ");
                    valor = scanner.nextDouble();
                    scanner.nextLine();
                    data = pedeData(); //método pedeData()
                    System.out.println("Me diga como entrada é uma Receita(1) ou Despesa(0): ");
                    status = (scanner.nextInt() == 1) ? true : false;
                    scanner.nextLine();
                    bancodeDados.addEntrada(nome, valor, data.getDayOfMonth(), data.getDayOfMonth(), data.getYear(), status);
                    break;
                case 2:
                    bancodeDados.verEntradas();
                    break;
                case 3:
                    System.out.println("Digite o id da entrada que deseja visualizar:");
                    bancodeDados.verEntrada(scanner.nextInt());
                    scanner.nextLine();
                    break;
                case 4:
                    System.out.println("Você deseja ver a Receita(true) ou Despesa(false)?: ");
                    status = scanner.nextBoolean();
                    bancodeDados.verEntradasPorTipo(status);
                    break;
                case 5:
                    System.out.println("Data Inicial do Período.");
                    data = pedeData();
                    System.out.println("Data Final do período.");
                    dataFinal = pedeData();
                    bancodeDados.verEntradasPorDatas(data, dataFinal);
                    break;
                case 6:
                    System.out.println("Digite o id da entrada: ");
                    id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println(
                        "Menu de Atualização de Entradas:\n" +
                        "1. Atualizar Nome\n" +
                        "2. Atualizar Valor\n" +
                        "3. Atualizar Data\n" +
                        "4. Atualizar Status\n" +
                        "5. Sair\n" +
                        "Escolha uma opção: "
                    );
                    switchSecundario = scanner.nextInt(); //Utilizando o ID para poder usar o nextInt fora do switch e conseguir usar a quebra de linha que o scanner não oferece nos nextInt e nextDouble. Que é solucionado, ao usar um scanner.nextLine(); após.
                    scanner.nextLine();
                    switch (switchSecundario) {
                        case 1:
                            bancodeDados.verEntrada(id);
                            System.out.println("Qual nome você deseja colocar?");
                            bancodeDados.attNome(id, scanner.nextLine());
                            break;
                        case 2:
                            bancodeDados.verEntrada(id);
                            System.out.println("Qual valor você deseja colocar?");
                            bancodeDados.attValor(id, scanner.nextDouble());
                            scanner.nextLine();
                            break;
                        case 3:
                            bancodeDados.verEntrada(id);
                            data = pedeData();
                            bancodeDados.attDia(id, data.getDayOfMonth());
                            bancodeDados.attMes(id, data.getMonthValue());
                            bancodeDados.attAno(id, data.getYear());
                            break;
                        case 4:
                            bancodeDados.verEntrada(id);
                            System.out.println("Qual status você deseja colocar?\nTrue=Receita / False=Despesa\n");
                            bancodeDados.attStatus(id, scanner.nextBoolean());
                            break;
                        default:
                            break;
                    }
                    break;
                case 7:
                    System.out.println("Digite o id da entrada que deseja remover: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    bancodeDados.removeEntrada(id);
                    break;
                case 8:
                running = false;
                    break;
                default:
                    break;
            }
        }
        scanner.close();
    }
}
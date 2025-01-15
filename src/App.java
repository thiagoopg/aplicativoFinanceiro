public class App {
    public static void main(String[] args) throws Exception {
        BancoDeDados bancodeDados = new BancoDeDados();
        bancodeDados.addEntrada("salário", 500, 11, 05, 2024, true);
        bancodeDados.addEntrada("salário", 200, 11, 06, 2024, true);
        bancodeDados.addEntrada("mercado", 1000, 11, 05, 2024, false);

        bancodeDados.verEntrada(3);
        bancodeDados.verEntradas();
    }
}

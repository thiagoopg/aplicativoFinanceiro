public class App {
    public static void main(String[] args) throws Exception {
        BancoDeDados bancodeDados = new BancoDeDados();
        bancodeDados.addEntrada("salário", 500, 11, 05, 2024, false);
        bancodeDados.verEntrada(1);
    }
}

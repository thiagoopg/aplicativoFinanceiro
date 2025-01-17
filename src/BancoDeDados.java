import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;


public class BancoDeDados{


    private int idDisponivel = 1;
    private Map<Integer, Entrada> banco;
    double total;
    //Método construtor - Inicialização
    public BancoDeDados(){
        this.banco = new HashMap<>();
    }

    //Gerenciamento de entradas
    public void addEntrada(String nome, double valor, int dia, int mes, int ano, boolean status){
        this.banco.put(this.idDisponivel, new Entrada(nome, valor, dia, mes, ano, status));
        idDisponivel++;
    }
    public void removeEntrada(int id){
        this.banco.remove(id);  
    }
    //Atualizando entradas
    public void attNome(int id, String nome) {
        if (banco.containsKey(id)) {
            Entrada entrada = banco.get(id);
            entrada.setNome(nome);
        } else {
            System.out.println("ID não encontrado!");
        }
    }

    public void attValor(int id, double num){
        if (banco.containsKey(id)) {
            Entrada entrada = banco.get(id);
            entrada.setValor(num);
        } else {
            System.out.println("ID não encontrado!");
        }    
    }

    public void attDia(int id, int num){
        if (banco.containsKey(id)) {
            banco.get(id).setAno(num);
        } else {
            System.out.println("ID não encontrado!");
        }
    }

    public void attMes(int id, int num){
        if (banco.containsKey(id)) {
            banco.get(id).setMes(num);
        } else {
            System.out.println("ID não encontrado!");
        }
    }

    public void attAno(int id, int num){
        if (banco.containsKey(id)) {
            banco.get(id).setAno(num);
        } else {
            System.out.println("ID não encontrado!");
        }
    }

    public void attStatus(int id, boolean status){
        this.banco.get(id).setStatus(status);
    }

    //Ver entradas
    public void verEntrada(int id){
        System.out.println("Id: " + id);
        this.banco.get(id).getEntrada();
        System.out.println("\n______________________________________\n");
    }
    public void verEntradas(){
        banco.forEach((Integer, Entrada) -> {
            System.out.println("Id: " + Integer);
            Entrada.getEntrada();
            System.out.println("\n______________________________________\n");
        });
    }
    public void verEntradasPorTipo(boolean status){
        banco.forEach((Integer, Entrada) -> {
            if (banco.get(Integer).getStatus() == status) {
                System.out.println("Id: " + Integer);
                this.banco.get(Integer).getEntrada();
                System.out.println("\n______________________________________\n");
            }
        });
    }
    public void verEntradasPorDatas(LocalDate dataInicial, LocalDate dataFinal){
        banco.forEach((Integer, Entrada) -> {
            if(LocalDate.parse(Entrada.getDataString()).isAfter(dataInicial)
            && LocalDate.parse(Entrada.getDataString()).isBefore(dataFinal)
            && (LocalDate.parse(Entrada.getDataString()).isEqual(dataInicial) || LocalDate.parse(Entrada.getDataString()).isEqual(dataFinal))){
                Entrada.getEntrada();
            }
        });
    }
    public double getValorTotal(){
        total = 0;
        this.banco.forEach((Integer, Entrada) -> {
            this.total += Entrada.getValor();
        });
        return total;
    }
}
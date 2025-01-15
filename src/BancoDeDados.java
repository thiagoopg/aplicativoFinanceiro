import java.util.ArrayList;
import java.util.List;


public class BancoDeDados{

    private int idDisponivel;
    private List<Entrada> banco;

    //Método construtor - Inicialização
    public BancoDeDados(){
        this.idDisponivel = 1;
        this.banco = new ArrayList<>();
    }

    //Gerenciamento de entradas
    public void addEntrada(String nome, double valor, int dia, int mes, int ano, boolean status){
        banco.add(new Entrada(idDisponivel, nome, valor, dia, mes, ano, status));
        idDisponivel++;
    }
    public void removeEntrada(int id){
        banco.removeIf(entrada -> entrada.getId() == id); //Sugestão da IA
    }
    //Atualizando entradas
    public void attNome(int id, String nome){
        for (Entrada entrada : banco) {
            if (entrada.getId() == id) { //Sugestão da IA, tentar achar uma função que busque o ID direto, sem precisar do for
                entrada.setNome(nome);
                break;
            }
        }
    }
    public void attValor(int id, int num){
        banco.get(id).setValor(num);
    }
    public void attDia(int id, int num){
        banco.get(id).setDia(num);
    }
    public void attMes(int id, int num){
        banco.get(id).setMes(num);
    }
    public void attAno(int id, int num){
        banco.get(id).setAno(num);
    }
    public void attStatus(int id, boolean status){
        banco.get(id).setStatus(status);
    }
    //Ver entradas
    public void verEntrada(int id){
        for (Entrada entrada : banco) {
            if (entrada.getId() == id) {
                entrada.getEntrada();
                break;
            }
        }
    }
    public void verEntradas(){
        for (Entrada entrada : banco) {
            entrada.getEntrada();
        }    
    }
}


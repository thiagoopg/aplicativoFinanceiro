import java.util.ArrayList;
import java.util.List;


public class BancoDeDados{

    private int idDisponivel;
    private List<Entrada> banco;

    public BancoDeDados(){
        this.idDisponivel = 1;
        this.banco = new ArrayList<>();
    }
    public void addEntrada(String nome, double valor, int dia, int mes, int ano, boolean status){
        banco.add(new Entrada(idDisponivel, nome, valor, dia, mes, ano, status));
        idDisponivel++;
    }
    public void verEntrada(int id){
        banco.get(id-1).getEntrada();
    }
    

}


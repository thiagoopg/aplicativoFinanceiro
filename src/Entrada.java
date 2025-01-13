public class Entrada{

    String nome;
    double valor;
    String tipo;
    boolean status;
    int dia;
    int mes;
    int ano;

    public Entrada(String nome, double valor, int dia, int mes, int ano, boolean status){
        this.nome = nome;
        this.valor = valor;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;

        if (status == true){
            this.status = true;

        }else {
            this.status = false;
            valor = valor * -1;
        }
    }
    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public String getTipo() {
        return tipo;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }
    public String getData(){
        String data = String.format("%02d/%02d/%04d", dia, mes, ano);
        return data;
    }
}

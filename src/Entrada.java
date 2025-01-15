
public class Entrada{

    private int id;
    private String nome;
    private double valor;
    private int dia;
    private int mes;
    private int ano;
    private boolean status;

    public Entrada(int id, String nome, double valor, int dia, int mes, int ano, boolean status) {
        this.id = id;
        this.nome = nome;
        this.valor = (status) ? valor : valor*-1;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.status = status;
    }   
    
    //Pega todos os valores ao mesmo tempo
    public void getEntrada(){
        System.out.println("\n______________________________________\n");
        System.out.println("nome: " + getNome() + "\nData: " + getData() + "\nTipo: " + getStatus());
    }

    //Get do Id
    public int getId() {
        return id;
    }
    
    //Get e Set do nome
    public String getNome() {
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    //Get e Set do valor
    public double getValor() {
        return valor;
    }
    public void setValor(double valor){
        this.valor = (this.status) ? valor : valor*-1;
        
    }

    //Get e Set do Dia/Mes/Ano
    public int getDia() {
        return dia;
    }
    public void setDia(int dia){
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }
    public void setMes(int mes){
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }
    public void setAno(int ano){
        this.ano = ano;
    }

    //Get e Set do Status
    public String getStatus(){
        String respostaStatus = (status) ? "Receita" : "Despesa";
        return respostaStatus;
    }
    public void setStatus(boolean status){
        this.status = status;
    }
    //Get da data completa
    public String getData(){
        String data = String.format("%02d/%02d/%04d", dia, mes, ano);
        return data;
    }
}

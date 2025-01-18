package java.com.app;

public class Entrada{

    private String nome;
    private double valor;
    private int dia;
    private int mes;
    private int ano;
    private boolean status;

    public Entrada(String nome, double valor, int dia, int mes, int ano, boolean status) {
        this.nome = nome;
        this.valor = (status) ? valor : valor*-1;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.status = status;
    }   
    
    //Pega todos os valores ao mesmo tempo
    public void getEntrada(){
        System.out.println("\nnome: " + getNome() + "\nValor: " + getValor() + "\nData: " + getDataString() + "\nTipo: " + (getStatus() ? "Receita" : "Despesa"));
    }
    //Get da data completa
    public String getDataString(){
        String data = String.format("%02d/%02d/%04d", dia, mes, ano);
        return data;
    }
    public int[] getData(){
        int[] data = new int[3];
        data[0] = dia;
        data[1] = mes;
        data[2] = ano;
        return data;
    }
//______________________________________________________________________________________________________________________________________

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
    public boolean getStatus(){
        return status;
    }
    public void setStatus(boolean status){
        this.status = status;
        this.valor = (status == this.status) ? valor : valor*-1; 
    }
}
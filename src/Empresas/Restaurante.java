package Empresas;
public class Restaurante extends Restauracao {
    protected int diasEmFuncionamento;
    protected int mesasInt;
    protected double faturacaoMesa;


    public Restaurante(String name, double latitude, double longitude, String distrito, int empregados, double salarioMedioAnual, double clientesMedioDiario, int diasEmFuncionamento, int mesasInt, double faturacaoMesa){
        super(name, latitude, longitude, distrito, empregados, salarioMedioAnual, clientesMedioDiario);
        setFaturacaoMesa(faturacaoMesa);
        setMesasInt(mesasInt);
        setDiasEmFuncionamento(diasEmFuncionamento);
    }


    @Override
    public double receitaAnual() {
        return mesasInt*faturacaoMesa*diasEmFuncionamento;
    }

    
    public void setFaturacaoMesa(double faturacaoMesa) {
        if(faturacaoMesa < 0){
            setValid(false);
        }else{
        this.faturacaoMesa = faturacaoMesa;
        }
    }
    public void setMesasInt(int mesasInt) {
        if(mesasInt < 0){
            setValid(false);
        }else{
        this.mesasInt = mesasInt;
        }
    }
    public void setDiasEmFuncionamento(int diasEmFuncionamento) {
        if(diasEmFuncionamento < 0){
            setValid(false);
        }else{
            this.diasEmFuncionamento = diasEmFuncionamento;
        }
    }   
    public double getFaturacaoMesa() {
        return faturacaoMesa;
    }
    public int getMesasInt() {
        return mesasInt;
    }
    public int getDiasEmFuncionamento() {
        return diasEmFuncionamento;
    }

    @Override
    public String toString() {
        return super.toString() + "Dias em funcionamento por ano: " + diasEmFuncionamento + "\nMesas interiores: " + mesasInt + "\nFaturacao diaria por mesa: " + faturacaoMesa + "\n";
    }

}
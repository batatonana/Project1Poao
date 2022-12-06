
public class Cafe extends Restauracao {
    private double cafeVendidoDia;
    private double faturacaoAnualCafe;

    public Cafe(String name, double latitude, double longitude, String distrito, int empregados, double salarioMedioAnual, double clientesMedioDiario, double cafeVendidoDia, double faturacaoAnualCafe){
        super(name, latitude, longitude, distrito, empregados, salarioMedioAnual, clientesMedioDiario);
        setFaturacaoAnualCafe(faturacaoAnualCafe);
        setCafeVendidoDia(cafeVendidoDia);
    }

    @Override
    public int getTipo() {
        return 0;
    }

    @Override
    public double receitaAnual() {
        return faturacaoAnualCafe * cafeVendidoDia;
    }

    public void setCafeVendidoDia(double cafeVendidoDia) {
        if(cafeVendidoDia < 0){
            setValid(false);
        }else{
            this.cafeVendidoDia = cafeVendidoDia;
        }
    }
    public void setFaturacaoAnualCafe(double faturacaoAnualCafe) {
        if(faturacaoAnualCafe < 0){
            setValid(false);
        }else{
        this.faturacaoAnualCafe = faturacaoAnualCafe;
        }
    }

    public double getCafeVendidoDia() {
        return cafeVendidoDia;
    }
    public double getFaturacaoAnualCafe() {
        return faturacaoAnualCafe;
    }

    @Override
    public String toString() {
        return "Tipo: Cafe\n" + super.toString() + "Cafe vendido por dia: " + cafeVendidoDia + "\nFaturacao anual por cafe vendidio por dia: "  + faturacaoAnualCafe + "\n";
    }
}

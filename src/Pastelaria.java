
public class Pastelaria extends Restauracao{
    private double boloVendidoDia;
    private double faturacaoAnualBolo;

    public Pastelaria(String name, double latitude, double longitude, String distrito, int empregados, double salarioMedioAnual, double clientesMedioDiario, double cafeVendidoDia, double faturacaoAnualBolo){
        super(name, latitude, longitude, distrito, empregados, salarioMedioAnual, clientesMedioDiario);
        setBoloVendidoDia(cafeVendidoDia);
        setFaturacaoAnualBolo(faturacaoAnualBolo);
    }

    @Override
    public double receitaAnual() {
        return faturacaoAnualBolo * boloVendidoDia;
    }

    @Override
    public int getTipo() {
        return 1;
    }

    @Override
    public String[] toTable() {
        String[] data = {name, "Pastelaria", distrito, String.format("%.2f", despesaAnual()), String.format("%.2f", receitaAnual()),(lucroAnual() >= 0 ? "Lucro de " : "Prejuizo de ") + String.format("%.2f", lucroAnual())};
        return data;
    }

    public void setFaturacaoAnualBolo(double faturacaoAnualBolo) {
        if(faturacaoAnualBolo < 0){
            setValid(false);
        }else{
        this.faturacaoAnualBolo = faturacaoAnualBolo;
        }
    }
    public void setBoloVendidoDia(double boloVendidoDia) {
        if(boloVendidoDia < 0){
            setValid(false);
        }else{
            this.boloVendidoDia = boloVendidoDia;
        }
    }

    public double getFaturacaoAnualBolo() {
        return faturacaoAnualBolo;
    }
    public double getBoloVendidoDia() {
        return boloVendidoDia;
    }

    @Override
    public String toString() {
        return "Tipo: Pastelaria\n" + super.toString() + "Bolo vendido por dia: " + boloVendidoDia + "\nFaturacao anual por bolo vendidio por dia: "  + faturacaoAnualBolo + "\n";
    }
}

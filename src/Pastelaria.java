/**
 * Class Pastelaria, 
 * Subclass form Restauracao
 */
public class Pastelaria extends Restauracao{
    private double boloVendidoDia;
    private double faturacaoAnualBolo;

    /**
     * Constructor for the class Pastelaria
     * @param name the name of empresa
     * @param latitude the latitude of empresa
     * @param longitude the longitude of empresa
     * @param distrito the distrito of empresa
     * @param empregados the number of empregados
     * @param salarioMedioAnual the values of salario medio anual
     * @param clientesMedioDiario the number of clientes medio diario
     * @param cafeVendidoDia the number of bolos vendidos por dia
     * @param faturacaoAnualBolo the faturacao anual por bolo
     */
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

    @Override
    public int save(String[] data) {
        try{
            super.save(data);
            setBoloVendidoDia(Double.parseDouble(data[6]));
            setFaturacaoAnualBolo(Double.parseDouble(data[7]));
            if(getValid()) return 0;
            return -1;
        }
catch(Exception e){
            return -1;
        }
    }

    /**
     * Setter for the anual faturation per cake sold per day
     * @param faturacaoAnualBolo the faturacao anual por bolo
     */
    public void setFaturacaoAnualBolo(double faturacaoAnualBolo) {
        if(faturacaoAnualBolo < 0){
            setValid(false);
        }else{
        this.faturacaoAnualBolo = faturacaoAnualBolo;
        }
    }
    
    /**
     * Setter for the average of cakes sold per day
     * @param boloVendidoDia he number of bolos vendidos por dia
     */
    public void setBoloVendidoDia(double boloVendidoDia) {
        if(boloVendidoDia < 0){
            setValid(false);
        }else{
            this.boloVendidoDia = boloVendidoDia;
        }
    }

    /**
     * Getter for the anual faturation per cake sold per day
     * @return anual faturation per cake sold per day
     */
    public double getFaturacaoAnualBolo() {
        return faturacaoAnualBolo;
    }
    /**
     * Getter for the average of cakes sold per day
     * @return average of cakes sold per day
     */
    public double getBoloVendidoDia() {
        return boloVendidoDia;
    }

    @Override
    public String toString() {
        return "Tipo: Pastelaria\n" + super.toString() + "Bolo vendido por dia: " + boloVendidoDia + "\nFaturacao anual por bolo vendidio por dia: "  + faturacaoAnualBolo + "\n";
    }
}

/**
 * Class Cafe, 
 * Subclass form {@link #Restauracao}
 */
public class Cafe extends Restauracao {
    private double cafeVendidoDia;
    private double faturacaoAnualCafe;

    /**
     * Constructor for Cafe class
     * @param name
     * @param latitude
     * @param longitude
     * @param distrito
     * @param empregados
     * @param salarioMedioAnual
     * @param clientesMedioDiario
     * @param cafeVendidoDia
     * @param faturacaoAnualCafe
     */
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
    public int save(String[] data) {
        try{
            super.save(data);
            setCafeVendidoDia(Double.parseDouble(data[6]));
            setFaturacaoAnualCafe(Double.parseDouble(data[7]));
            if(getValid()) return 0;
            return -1;
        }catch(Exception e){
            return -1;
        }

    }

    @Override
    public double receitaAnual() {
        return faturacaoAnualCafe * cafeVendidoDia;
    }

    @Override
    public String[] toTable() {
        String[] data = {name, "Cafe", distrito, String.format("%.2f", despesaAnual()), String.format("%.2f", receitaAnual()),(lucroAnual() >= 0 ? "Lucro de " : "Prejuizo de ") + String.format("%.2f", lucroAnual())};
        return data;
    }

    
    /** 
     * Setter for the average amount of coffe sold in a day
     * @param cafeVendidoDia
     */
    public void setCafeVendidoDia(double cafeVendidoDia) {
        if(cafeVendidoDia < 0){
            setValid(false);
        }else{
            this.cafeVendidoDia = cafeVendidoDia;
        }
    }
    
    /** 
     * Setter for the Anual faturation per cofe per day
     * @param faturacaoAnualCafe
     */
    public void setFaturacaoAnualCafe(double faturacaoAnualCafe) {
        if(faturacaoAnualCafe < 0){
            setValid(false);
        }else{
        this.faturacaoAnualCafe = faturacaoAnualCafe;
        }
    }

    
    /** 
     * Getter for the average amount of coffe sold by day
     * @return double
     */
    public double getCafeVendidoDia() {
        return cafeVendidoDia;
    }
    
    /** 
     * Getter for the Anual faturation per cofe per day
     * @return double
     */
    public double getFaturacaoAnualCafe() {
        return faturacaoAnualCafe;
    }

    @Override
    public String toString() {
        return "Tipo: Cafe\n" + super.toString() + "Cafe vendido por dia: " + cafeVendidoDia + "\nFaturacao anual por cafe vendidio por dia: "  + faturacaoAnualCafe + "\n";
    }
}

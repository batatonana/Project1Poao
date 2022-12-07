/**
 * Class Mercearia subclass from {@link #Empresa}
 * Superclass of market type companies
 */
public abstract class Mercearia extends Empresa {
    protected double custoLimpeza;

    /**
     * Constructor for the class {@link #Mercearia}
     * @param name
     * @param latitude
     * @param longitude
     * @param distrito
     * @param custoLimpeza
     */
    public Mercearia(String name, double latitude, double longitude, String distrito, double custoLimpeza){
        super(name, latitude, longitude, distrito);
        setCustoLimpeza(custoLimpeza);
    }
    
    @Override
    public double despesaAnual() {
        return custoLimpeza;
    }

    @Override
    public int save(String[] data){
        try {
            super.save(data);
            setCustoLimpeza(Double.parseDouble(data[3]));
            if(getValid()) return 0;
            return -1;
        } catch (Exception e) {
            return -1;
        }
    }

    /**
     * Setter for the custo de limpeza
     * @param custoLimpeza
     */
    public void setCustoLimpeza(double custoLimpeza) {
        if(custoLimpeza < 0){
            setValid(false);
        }else{
        this.custoLimpeza = custoLimpeza;
        }
    }
    /**
     * Getter for the custo de limpeza
     * @return custo de limpeza
     */
    public double getCustoLimpeza() {
        return custoLimpeza;
    }

    @Override
    public String toString() {
        return super.toString() + "Custo de Limpeza: " + custoLimpeza + "\n";
    }
}   

/**
 * Class Mercado,
 * Subclass form {@link #Mercearia}
 */
public class Mercado extends Mercearia{
    private String type;
    private double area;
    private double faturacaoArea;
    /**
     * Constructor for the class {@link #Mercado}
     * @param name
     * @param latitude
     * @param longitude
     * @param distrito
     * @param custoLimpeza
     * @param type
     * @param area
     * @param faturacaoArea
     */
    public Mercado(String name, double latitude, double longitude, String distrito, double custoLimpeza, String type, double area, double faturacaoArea){
        super(name, latitude, longitude, distrito, custoLimpeza);
        setArea(area);
        setType(type);
        setFaturacaoArea(faturacaoArea);
    }

    @Override
    public double receitaAnual() {
        return area * faturacaoArea;
    }

    @Override
    public int getTipo() {
        return 5;
    }

    @Override
    public String[] toTable() {
        String[] data = {name, type + "mercado", distrito, String.format("%.2f", despesaAnual()), String.format("%.2f", receitaAnual()),(lucroAnual() >= 0 ? "Lucro de " : "Prejuizo de ") + String.format("%.2f", lucroAnual())};
        return data;
    }

    @Override
    public int save(String[] data){
        try {
            super.save(data);
            setType(data[4]);
            setArea(Double.parseDouble(data[5]));
            setFaturacaoArea(Double.parseDouble(data[6]));
            if(getValid()) return 0;
            return -1;
        } catch (Exception e) {
            return -1;
        }
    }

    /**
     * Setter for the type of market
     * @param type
     */
    public void setType(String type) {
        if(type.equals("Mini") || type.equals("Super") || type.equals("Hiper")){
            this.type = type;
        }else{
            setValid(false);
        }
    }
    /**
     * Setter for the area
     * @param area
     */
    public void setArea(double area) {
        if(area < 0){
            setValid(false);
        }else{
        this.area = area;
        }
    }
    /**
     * Setter for the average faturation for meter squared
     * @param faturacaoArea
     */
    public void setFaturacaoArea(double faturacaoArea) {
        if(faturacaoArea < 0){
            setValid(false);
        }else{
            this.faturacaoArea = faturacaoArea;
        }
    }
    /**
     * Getter for the type of market
     * @return type of market
     */
    public String gettype() {
        return type;
    }
    /**
     * Getter for the area
     * @return area
     */
    public double getFaturacaoArea() {
        return faturacaoArea;
    }
    /**
     * Getter for the average faturation for meter squared
     * @return average faturation for meter squared
     */
    public double getArea() {
        return area;
    }

    @Override
    public String toString() {
        return "Tipo: Mercado\n" + super.toString() + "Type: " + type + "mercado\nArea: " + area + "\nFaturacao por metro quadrado: " + faturacaoArea + "\n";
    }

}

/**
 * Class Mercado,
 * Subclass form Mercearia
 */
public class Mercado extends Mercearia{
    private String type;
    private double area;
    private double faturacaoArea;
    /**
     * Constructor for the class Mercado
     * @param name the name of empresa
     * @param latitude the latitude of empresa
     * @param longitude the longitude of empresa
     * @param distrito the distrito of empresa
     * @param custoLimpeza the custo limpeza
     * @param type the type of mercado
     * @param area the area of empresa
     * @param faturacaoArea the faturacao por area 
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
     * @param type the type of mercado
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
     * @param area the area of empresa
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
     * @param faturacaoArea the faturacao por area 
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

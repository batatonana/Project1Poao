public class Mercado extends Mercearia{
    private String type;
    private double area;
    private double faturacaoArea;

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


    public void setType(String type) {
        if(type.equals("Mini") || type.equals("Super") || type.equals("Hiper")){
            this.type = type;
        }else{
            setValid(false);
        }
    }
    public void setArea(double area) {
        if(area < 0){
            setValid(false);
        }else{
        this.area = area;
        }
    }
    public void setFaturacaoArea(double faturacaoArea) {
        if(faturacaoArea < 0){
            setValid(false);
        }else{
            this.faturacaoArea = faturacaoArea;
        }
    }

    public String gettype() {
        return type;
    }
    public double getFaturacaoArea() {
        return faturacaoArea;
    }
    public double getArea() {
        return area;
    }

    @Override
    public String toString() {
        return "type: Mercado\n" + super.toString() + "type: " + type + "mercado\nArea: " + area + "\nFaturacao por metro quadrado: " + faturacaoArea + "\n";
    }

}

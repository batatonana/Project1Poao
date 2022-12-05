public class Mercado extends Mercearia{
    private String tipo;
    private double area;
    private double faturacaoArea;

    public Mercado(String name, double latitude, double longitude, String distrito, double custoLimpeza, String tipo, double area, double faturacaoArea){
        super(name, latitude, longitude, distrito, custoLimpeza);
        setArea(faturacaoArea);
        setTipo(tipo);
        setFaturacaoArea(faturacaoArea);
    }

    @Override
    public double receitaAnual() {
        return area * faturacaoArea;
    }

    public void setTipo(String tipo) {
        if(tipo.toLowerCase() != "mini" || tipo.toLowerCase() != "super" || tipo.toLowerCase() != "hiper"){
            setValid(false);
        }else{
        this.tipo = tipo;
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

    public String getTipo() {
        return tipo;
    }
    public double getFaturacaoArea() {
        return faturacaoArea;
    }
    public double getArea() {
        return area;
    }

    @Override
    public String toString() {
        return "Tipo: Mercado" + super.toString() + "Tipo: " + tipo + "mercado\nArea: " + area + "\nFaturacao por metro quadrado: " + faturacaoArea + "\n";
    }

}

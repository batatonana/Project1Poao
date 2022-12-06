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
        return "Tipo: Mercado\n" + super.toString() + "Type: " + type + "mercado\nArea: " + area + "\nFaturacao por metro quadrado: " + faturacaoArea + "\n";
    }

}

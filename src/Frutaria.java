public class Frutaria extends Mercearia{
    private int produtos;
    private double faturacaoProduto;

    public Frutaria(String name, double latitude, double longitude, String distrito, double custoLimpeza, int produtos, double faturacaoProduto){
        super(name, latitude, longitude, distrito, custoLimpeza);
        setProdutos(produtos);
        setFaturacaoProduto(faturacaoProduto);
    }

    @Override
    public double receitaAnual() {
        return produtos * faturacaoProduto;
    }

    @Override
    public int getTipo() {
        return 4;
    }

    @Override
    public String[] toTable() {
        String[] data = {name, "Furtaria", distrito, String.format("%.2f", despesaAnual()), String.format("%.2f", receitaAnual()),(lucroAnual() >= 0 ? "Lucro de " : "Prejuizo de ") + String.format("%.2f", lucroAnual())};
        return data;
    }

    @Override
    public int save(String[] data){
        try {
            super.save(data);
            setProdutos(Integer.parseInt(data[4]));
            setFaturacaoProduto(Double.parseDouble(data[5]));
            if(getValid()) return 0;
            return -1;
        } catch (Exception e) {
            return -1;
        }
    }

    public void setFaturacaoProduto(double faturacaoProduto) {
        if (faturacaoProduto < 0){
            setValid(false);
        }else{
            this.faturacaoProduto = faturacaoProduto;
        }
    }
    public void setProdutos(int produtos) {
        if(produtos < 0){
            setValid(false);
        }else{
            this.produtos = produtos;
        }
    }
    public int getProdutos() {
        return produtos;
    }
    public double getFaturacaoProduto() {
        return faturacaoProduto;
    }

    @Override
    public String toString() {
        return "Tipo: Frutaria\n" + super.toString() + "Media de produtos vendidos por ano: " + produtos + "\nFaturacao media anual por porduto vendido: " + faturacaoProduto + "\n";
    }
}


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

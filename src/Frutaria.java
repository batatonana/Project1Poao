/**
 * Class Frutaria,
 * Subclass from {@link #Mercearia}
 */
public class Frutaria extends Mercearia{
    private int produtos;
    private double faturacaoProduto;
    /**
     * Constructor for the class {@link #Frutaria}
     * @param name the name of empresa
     * @param latitude the latitude of empresa
     * @param longitude the longitude of empresa
     * @param distrito the distrito of empresa
     * @param custoLimpeza the custo limpeza
     * @param produtos the produtos
     * @param faturacaoProduto the faturacao produtos
     */
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

    /**
     * Setter for the average faturation per products sold
     * @param faturacaoProduto the faturacao produtos
     */
    public void setFaturacaoProduto(double faturacaoProduto) {
        if (faturacaoProduto < 0){
            setValid(false);
        }else{
            this.faturacaoProduto = faturacaoProduto;
        }
    }
    /**
     * Setter for the average number of products sold per year
     * @param produtos the produtos
     */
    public void setProdutos(int produtos) {
        if(produtos < 0){
            setValid(false);
        }else{
            this.produtos = produtos;
        }
    }
    /**
     * Getter for the average number of products sold per year
     * @return average number of products sold per year
     */
    public int getProdutos() {
        return produtos;
    }
    /**
     * Getter for the average faturation per products sold
     * @return average faturation per products sold
     */
    public double getFaturacaoProduto() {
        return faturacaoProduto;
    }

    @Override
    public String toString() {
        return "Tipo: Frutaria\n" + super.toString() + "Media de produtos vendidos por ano: " + produtos + "\nFaturacao media anual por porduto vendido: " + faturacaoProduto + "\n";
    }
}

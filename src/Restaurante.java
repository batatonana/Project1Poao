/**
 * Class Restaurante superclass for restaurants
 * Subclass of Restaurancao
 */
public abstract class Restaurante extends Restauracao {
    /**
     * dias de funcionamento
     */
    protected int diasEmFuncionamento;
    /**
     * number of mesas
     */
    protected int mesasInt;
    /**
     * alues of faturacao por mesa
     */
    protected double faturacaoMesa;

    /**
     * Constructor for Restaurante
     * @param name the name of empresa
     * @param latitude the latitude of empresa
     * @param longitude the longitude of empresa
     * @param distrito the distrito of empresa
     * @param empregados the number of empregados
     * @param salarioMedioAnual the values of salario medio anual
     * @param clientesMedioDiario the number of clientes medio diario
     * @param diasEmFuncionamento the dias de funcionamento
     * @param mesasInt the number of mesas
     * @param faturacaoMesa the values of faturacao por mesa
     */
    public Restaurante(String name, double latitude, double longitude, String distrito, int empregados, double salarioMedioAnual, double clientesMedioDiario, int diasEmFuncionamento, int mesasInt, double faturacaoMesa){
        super(name, latitude, longitude, distrito, empregados, salarioMedioAnual, clientesMedioDiario);
        setFaturacaoMesa(faturacaoMesa);
        setMesasInt(mesasInt);
        setDiasEmFuncionamento(diasEmFuncionamento);
    }

    @Override
    public double receitaAnual() {
        return mesasInt*faturacaoMesa*diasEmFuncionamento;
    }

    @Override
    public int save(String[] data){
        try {
            super.save(data);
            setDiasEmFuncionamento(Integer.parseInt(data[6]));
            setMesasInt(Integer.parseInt(data[7]));
            setFaturacaoMesa(Double.parseDouble(data[8]));
            if(getValid()) return 0;
            return -1;
        } catch (Exception e) {
            return -1;
        }
    }
    
    /**
     * Setter for the average faturarion per interior table
     * @param faturacaoMesa the values of faturacao por mesa
     */
    public void setFaturacaoMesa(double faturacaoMesa) {
        if(faturacaoMesa < 0){
            setValid(false);
        }else{
        this.faturacaoMesa = faturacaoMesa;
        }
    }
    /**
     * Setter for the number of interior tables
     * @param mesasInt the number of mesas
     */
    public void setMesasInt(int mesasInt) {
        if(mesasInt < 0){
            setValid(false);
        }else{
        this.mesasInt = mesasInt;
        }
    }
    /**
     * Setter for the number of working days on the year
     * @param diasEmFuncionamento the dias de funcionamento
     */
    public void setDiasEmFuncionamento(int diasEmFuncionamento) {
        if(diasEmFuncionamento < 0){
            setValid(false);
        }else{
            this.diasEmFuncionamento = diasEmFuncionamento;
        }
    }   

    /**
     * Getter for the average faturarion per interior table
     * @return average faturarion per interior table
     */
    public double getFaturacaoMesa() {
        return faturacaoMesa;
    }
    /**
     * Getter for the number of interior tables
     * @return average number of interior tables
     */
    public int getMesasInt() {
        return mesasInt;
    }
    /**
     * Getter for the number of working days on the year
     * @return number of working days on the year
     */
    public int getDiasEmFuncionamento() {
        return diasEmFuncionamento;
    }

    @Override
    public String toString() {
        return super.toString() + "Dias em funcionamento por ano: " + diasEmFuncionamento + "\nMesas interiores: " + mesasInt + "\nFaturacao diaria por mesa: " + faturacaoMesa + "\n";
    }

}
/**
 * Class Restaurante superclass for restaurants
 * Subclass of Restaurancao
 */
public abstract class Restaurante extends Restauracao {
    protected int diasEmFuncionamento;
    protected int mesasInt;
    protected double faturacaoMesa;

    /**
     * Constructor for {@link #Restaurante}
     * @param name
     * @param latitude
     * @param longitude
     * @param distrito
     * @param empregados
     * @param salarioMedioAnual
     * @param clientesMedioDiario
     * @param diasEmFuncionamento
     * @param mesasInt
     * @param faturacaoMesa
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
     * @param faturacaoMesa
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
     * @param mesasInt
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
     * @param diasEmFuncionamento
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
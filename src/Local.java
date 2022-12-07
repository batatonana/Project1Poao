/**
 * Class Local,
 * Subclass from Restaurante
 */
public class Local extends Restaurante{
    /**
     * number of mesas esplanada
     */
    private int mesasEsp;
    /**
     * values of licensa esplanada
     */
    private double licencaEsp;

    /**
     * Cosntructor for the class Local
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
     * @param mesasEsp the number of mesas esplanada
     * @param licencaEsp the values of licensa esplanada
     */
    public Local(String name, double latitude, double longitude, String distrito, int empregados, double salarioMedioAnual, double clientesMedioDiario, int diasEmFuncionamento, int mesasInt, double faturacaoMesa, int mesasEsp, double licencaEsp){
        super(name, latitude, longitude, distrito, empregados, salarioMedioAnual, clientesMedioDiario, diasEmFuncionamento, mesasInt, faturacaoMesa);
        setMesasEsp(mesasEsp);
        setLicencaEsp(licencaEsp);
    }

    @Override
    public int getTipo() {
        return 2;
    }

    @Override
    public double despesaAnual() {
        return super.despesaAnual() + (mesasEsp * licencaEsp);
    }

    @Override
    public double receitaAnual() {
        return super.receitaAnual() + mesasEsp*diasEmFuncionamento*faturacaoMesa;
    }

    @Override
    public String[] toTable() {
        String[] data = {name, "Restaurante Local", distrito, String.format("%.2f", despesaAnual()), String.format("%.2f", receitaAnual()),(lucroAnual() >= 0 ? "Lucro de " : "Prejuizo de ") + String.format("%.2f", lucroAnual())};
        return data;
    }

    @Override
    public int save(String[] data){
        try {
            super.save(data);
            setMesasEsp(Integer.parseInt(data[9]));
            setLicencaEsp(Double.parseDouble(data[10]));
            if(getValid()) return 0;
            return -1;
        } catch (Exception e) {
            return -1;
        }
    }

    /**
     * Setter for the number of outside tables
     * @param mesasEsp the number of mesas espalanda
     */
    public void setMesasEsp(int mesasEsp) {
        if(mesasEsp < 0){
            setValid(false);
        }else{
        this.mesasEsp = mesasEsp;
        }
    }
    
    /**
     * Setter for the price of licence per outside table
     * @param licencaEsp the values of licensa esplanada
     */
    public void setLicencaEsp(double licencaEsp) {
        if(licencaEsp < 0){
            setValid(false);
        }else{
            this.licencaEsp = licencaEsp;
        }
    }

    /**
     * Getter for the price of licence per outside table
     * @return price of licence per outside table
     */
    public double getLicencaEsp() {
        return licencaEsp;
    }
    /**
     * Getter for the number of outside tables
     * @return number of outside tables
     */
    public int getMesasEsp() {
        return mesasEsp;
    }

    @Override
    public String toString() {
        return "Tipo: Restaurante Local\n" + super.toString() + "Mesas de esplanada: " + mesasEsp + "\nPreco da licensa por mesa de esplanada por ano: "  + licencaEsp + "\n";
    }
}

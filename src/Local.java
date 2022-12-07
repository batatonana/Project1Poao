/**
 * Class Local,
 * Subclass from Restaurante
 */
public class Local extends Restaurante{
    private int mesasEsp;
    private double licencaEsp;

    /**
     * Cosntructor for the class {@link #Local}
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
     * @param mesasEsp
     * @param licencaEsp
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
     * @param mesasEsp
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
     */
    public void setLicencaEsp(double licencaEsp) {
        if(licencaEsp < 0){
            setValid(false);
        }else{
            this.licencaEsp = licencaEsp;
        }
    }

    /**
     * Setter for the price of licence per outside table
     * @return price of licence per outside table
     */
    public double getLicencaEsp() {
        return licencaEsp;
    }
    /**
     * Setter for the number of outside tables
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


public class Local extends Restaurante{
    private int mesasEsp;
    private double licencaEsp;

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

    public void setMesasEsp(int mesasEsp) {
        if(mesasEsp < 0){
            setValid(false);
        }else{
        this.mesasEsp = mesasEsp;
        }
    }
    public void setLicencaEsp(double licencaEsp) {
        if(licencaEsp < 0){
            setValid(false);
        }else{
            this.licencaEsp = licencaEsp;
        }
    }
    public double getLicencaEsp() {
        return licencaEsp;
    }
    public int getMesasEsp() {
        return mesasEsp;
    }

    @Override
    public String toString() {
        return "Tipo: Restaurante Local\n" + super.toString() + "Mesas de esplanada: " + mesasEsp + "\nPreco da licensa por mesa de esplanada por ano: "  + licencaEsp + "\n";
    }
}


public class FastFood extends Restaurante{
    private double clientesDrive;
    private double faturacaoDrive;

    public FastFood(String name, double latitude, double longitude, String distrito, int empregados, double salarioMedioAnual, double clientesMedioDiario, int diasEmFuncionamento, int mesasInt, double faturacaoMesa, double clientesDrive, double faturacaoDrive){
        super(name, latitude, longitude, distrito, empregados, salarioMedioAnual, clientesMedioDiario, diasEmFuncionamento, mesasInt, faturacaoMesa);
        setClientesDrive(clientesDrive);
        setFaturacaoDrive(faturacaoDrive);        
    }

    @Override
    public int getTipo() {
        return 3;
    }

    @Override
    public double receitaAnual() {
        return super.receitaAnual() + diasEmFuncionamento*clientesDrive*faturacaoDrive;
    }

    @Override
    public String[] toTable() {
        String[] data = {name, "Restaurante fast-food", distrito, String.format("%.2f", despesaAnual()), String.format("%.2f", receitaAnual()),(lucroAnual() >= 0 ? "Lucro de " : "Prejuizo de ") + String.format("%.2f", lucroAnual())};
        return data;
    }

    @Override
    public int save(String[] data){
        try {
            super.save(data);
            setClientesDrive(Double.parseDouble(data[9]));
            setFaturacaoDrive(Double.parseDouble(data[10]));
            if(getValid()) return 0;
            return -1;
        } catch (Exception e) {
            return -1;
        }
    }

    public void setClientesDrive(double clientesDrive) {
        if (clientesDrive < 0){
            setValid(false);
        }else{
            this.clientesDrive = clientesDrive;
        }
    }
    public void setFaturacaoDrive(double faturacaoDrive) {
        if(faturacaoDrive < 0){
            setValid(false);
        }else{
            this.faturacaoDrive = faturacaoDrive;
        }
    }
    public double getClientesDrive() {
        return clientesDrive;
    }
    public double getFaturacaoDrive() {
        return faturacaoDrive;
    }

    @Override
    public String toString() {
        return "Tipo: Restaurante Fast-Food\n" + super.toString() + "Numero medio de clientes Drive-thru: " + clientesDrive + "\nFaturacao media por cliente do Drive-thru: "  + faturacaoDrive + "\n";
    }
}
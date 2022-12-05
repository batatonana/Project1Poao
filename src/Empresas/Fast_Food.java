package Empresas;
public class Fast_Food extends Restaurante{
    private double clientesDrive;
    private double faturacaoDrive;

    public Fast_Food(String name, double latitude, double longitude, String distrito, int empregados, double salarioMedioAnual, double clientesMedioDiario, int diasEmFuncionamento, int mesasInt, double faturacaoMesa, double clientesDrive, double faturacaoDrive){
        super(name, latitude, longitude, distrito, empregados, salarioMedioAnual, clientesMedioDiario, diasEmFuncionamento, mesasInt, faturacaoMesa);
        setClientesDrive(clientesDrive);
        setFaturacaoDrive(faturacaoDrive);        
    }


    @Override
    public double receitaAnual() {
        return super.receitaAnual() + diasEmFuncionamento*clientesDrive*faturacaoDrive;
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
        return "Tipo: Restaurante Local\n" + super.toString() + "Numero medio de clientes Drive-thru: " + clientesDrive + "\nFaturacao media por cliente do Drive-thru: "  + faturacaoDrive + "\n";
    }
}

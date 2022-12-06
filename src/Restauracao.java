/**
 * Superclass for all the companies restaurante-like
 * This class is a subclass of the class "Empresa"
 */
public abstract class Restauracao extends Empresa {
    protected int empregados;
    protected double clientesMedioDiario;
    protected double salarioMedioAnual;

    public Restauracao(String name, double latitude, double longitude, String distrito, int empregados, double salarioMedioAnual, double clientesMedioDiario){
        super(name, latitude, longitude, distrito);
        setClientesMedioDiario(clientesMedioDiario);
        setEmpregados(empregados);
        setSalarioMedioAnual(salarioMedioAnual);
    }


    public double despesaAnual() {
        return empregados * salarioMedioAnual;
    }

    @Override
    public double capacidadeClientes() {
        return clientesMedioDiario;
    }

    public void setSalarioMedioAnual(double salarioMedioAnual) {
        if(salarioMedioAnual < 0){
            super.setValid(false);
        }else{
            this.salarioMedioAnual = salarioMedioAnual;
        }
    }
    public void setEmpregados(int empregados) {
        if(empregados < 0){
            super.setValid(false);
        }else{
            this.empregados = empregados;
        }
    }
    public void setClientesMedioDiario(double clientesMedioDiario) {
        if(clientesMedioDiario < 0){
            super.setValid(false);
        }else{
            this.clientesMedioDiario = clientesMedioDiario;
        }
    }

    @Override
    public int save(String[] data){
        super.save(data);
        setClientesMedioDiario(Double.parseDouble(data[3]));
        setSalarioMedioAnual(Double.parseDouble(data[4]));
        setEmpregados(Integer.parseInt(data[5]));
        if(getValid()) return 0;
        return -1;
    }

    public double getClientesMedioDiario() {
        return clientesMedioDiario;
    }
    public double getSalarioMedioAnual() {
        return salarioMedioAnual;
    }
    public int getEmpregados() {
        return empregados;
    }


    public String toString() {
        return super.toString() + "Numero medio de clientes por dia: " + clientesMedioDiario + "\nSalario medio anual do empregados: " + salarioMedioAnual + "\nNumero de empregados: " + empregados + "\n";
    }
}

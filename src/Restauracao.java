/**
 * Superclass for all the companies restaurante-like
 * This class is a subclass of the class "Empresa"
 */
public abstract class Restauracao extends Empresa {
    protected int empregados;
    protected double clientesMedioDiario;
    protected double salarioMedioAnual;

    /**
     * Constructor for Restauracao
     * @param name the name of empresa
     * @param latitude the latitude of empresa
     * @param longitude the longitude of empresa
     * @param distrito the distrito of empresa
     * @param empregados the number of empregados
     * @param salarioMedioAnual the values of salario medio anual
     * @param clientesMedioDiario the number of clientes medio diario
     */
    public Restauracao(String name, double latitude, double longitude, String distrito, int empregados, double salarioMedioAnual, double clientesMedioDiario){
        super(name, latitude, longitude, distrito);
        setClientesMedioDiario(clientesMedioDiario);
        setEmpregados(empregados);
        setSalarioMedioAnual(salarioMedioAnual);
    }

    @Override
    public double despesaAnual() {
        return empregados * salarioMedioAnual;
    }

    @Override
    public double capacidadeClientes() {
        return clientesMedioDiario;
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
    /**
     * Setter for the number salarioMedioAnual
     * @param salarioMedioAnual the values of salario medio anual
     */
    public void setSalarioMedioAnual(double salarioMedioAnual) {
        if(salarioMedioAnual < 0){
            super.setValid(false);
        }else{
            this.salarioMedioAnual = salarioMedioAnual;
        }
    }
     /**
     * Setter for the number empregados
     * @param empregados the number of empregados
     */
    public void setEmpregados(int empregados) {
        if(empregados < 0){
            super.setValid(false);
        }else{
            this.empregados = empregados;
        }
    }
    /**
     * Setter for the number clientesMedioDiario
     * @param clientesMedioDiario the number of clientes medio diario
     */
    public void setClientesMedioDiario(double clientesMedioDiario) {
        if(clientesMedioDiario < 0){
            super.setValid(false);
        }else{
            this.clientesMedioDiario = clientesMedioDiario;
        }
    }


    /**
     * Getter for the number clientesMedioDiario
     * @return clientesMedioDiario
     */
    public double getClientesMedioDiario() {
        return clientesMedioDiario;
    }
    /**
     * Getter for the number salarioMedioAnual
     * @return salarioMedioAnual
     */
    public double getSalarioMedioAnual() {
        return salarioMedioAnual;
    }
    /**
     * Getter for the number empregados
     * @return empregados
     */
    public int getEmpregados() {
        return empregados;
    }


    public String toString() {
        return super.toString() + "Numero medio de clientes por dia: " + clientesMedioDiario + "\nSalario medio anual do empregados: " + salarioMedioAnual + "\nNumero de empregados: " + empregados + "\n";
    }
}

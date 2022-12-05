package Empresas;
/**
 * Superclass for all the companies managed by StarThrive
 */
public abstract class Empresa {
    protected Coordenadas coordenadas;
    protected boolean valid = true;
    protected String name;
    protected String distrito;

    
    public Empresa(String name, double latitude, double longitude, String distrito){
        setName(name);
        setDistrito(distrito);
        setCoordenadas(latitude, longitude);
    }


    public abstract double despesaAnual();
    public abstract double receitaAnual();


    public double lucroAnual(){
        return (receitaAnual() - despesaAnual());
    }


    public void setName(String name) {
        this.name = name;
    }
    public void setCoordenadas(double latitude, double longitude) {
        Coordenadas coordenadasAux = new Coordenadas(latitude, longitude);
        if(coordenadasAux.getValid()){
            this.coordenadas = coordenadasAux;
        }else{
            this.setValid(false);
            this.coordenadas = new Coordenadas(0, 0);
        }  
    }
    public void setDistrito(String distrito) {
        if(distrito.charAt(0)>= 'Z' || distrito.charAt(0) <= 'A'){
            this.setValid(false);
            this.distrito = "";
        }else{
            this.distrito = distrito;
        }
    }
    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public Coordenadas getCoordenadas() {
        return coordenadas;
    }
    public String getDistrito() {
        return distrito;
    }
    public String getName() {
        return name;
    }
    public boolean getValid() {
        return valid;
    }
    

    public String toString() {
        return "Nome: " + name + "\nDistrito: " + distrito + "\n" + coordenadas + "Despesa Anual: " + despesaAnual() + "\nReceita Anual: " + receitaAnual() + "\nLucro: " + ((lucroAnual()>0) ? "Sim\n" : "Nao\n");
    }

}

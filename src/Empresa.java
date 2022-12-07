import java.io.Serializable;

/**
 * Superclass for all the companies managed by StarThrive
 */
public abstract class Empresa implements Serializable {
    protected Coordenadas coordenadas;
    protected boolean valid = true;
    protected String name;
    protected String distrito;
    protected int id;

    private static int maxId = 0;

    /**
     * Class constructor
     * @param name the name of empresa
     * @param latitude the latitude of empresa
     * @param longitude the longitude of empresa
     * @param distrito the distrito of empresa
     */
    public Empresa(String name, double latitude, double longitude, String distrito){
        setName(name);
        setDistrito(distrito);
        setCoordenadas(latitude, longitude);
        maxId +=1;
        id = maxId;
    }

    /**
     * Method used on exercice 2 to get the type of each class
     * @return tipo
     */
    public abstract int getTipo();

    /**
     * Method that returns the anual expenses
     * @return anual expenses
     */
    public abstract double despesaAnual();

    /**
     * Methos that returns the anual faturation
     * @return anual faturation
     */
    public abstract double receitaAnual();

    /**
     * Method used calculate the anual profit
     * @return anual profit
     */
    public double lucroAnual(){
        return (receitaAnual() - despesaAnual());
    }

    /**
     * Method that return some data to be displayed in the GUI 
     * @return data to be displayed in the GUI
     */
    public abstract String[] toTable();

    /**
     * Method used to update the data of each empresa
     * @param data array of data
     * @return 0 if successful, -1 if not
     */
    public int save(String[] data){
        try {
            setName(data[0]);
            setDistrito(data[1]);
            String[] aux = {data[2].replace("(", "").replace(")", "").split(",")[0],data[2].replace("(", "").replace(")", "").split(",")[1]};
            setCoordenadas(Double.parseDouble(aux[0]), Double.parseDouble(aux[1]));
            if(getValid()){
                return 0;
            }   
            else{
                return -1;
            }
        } catch (Exception e) {
            return -1;
        }
    }

    /**
     * Method used to return the "empresas" with the mos client capacity
     * @return number of client capcity
     */
    public double capacidadeClientes(){
        return -1;
    }

    /**
     * Setter for the name accepts any name greaetd than 1
     * @param name the name of empresa
     */
    public void setName(String name) {
        if(name != null && name.length()>1){
            this.name = name;
        }else{
            setValid(false);
        }
    }
    
    /**
     * Creates an instance of the class coordenadas is the params are valid
     * @param latitude the latitude of empresa
     * @param longitude the longitude of empresa
     */
    public void setCoordenadas(double latitude, double longitude) {
        Coordenadas coordenadasAux = new Coordenadas(latitude, longitude);
        if(coordenadasAux.getValid()){
            this.coordenadas = coordenadasAux;
        }else{
            this.setValid(false);
        }  
    }
    
    /**
     * Setter for distrito, accepts any name started with uppercase
     * @param distrito the distrito of empresa
     */
    public void setDistrito(String distrito) {
        if(distrito.charAt(0)>= 'Z' || distrito.charAt(0) <= 'A'){
            this.setValid(false);
        }else{
            this.distrito = distrito;
        }
    }
    
    /**
     * Setter for valid, this attribute dertemines if the object is valid or not
     * @param valid boolean
     */
    public void setValid(boolean valid) {
        this.valid = valid;
    }

    /**
     * Getter for coordenadas
     * @return coordenadas
     */
    public Coordenadas getCoordenadas() {
        return coordenadas;
    }
    
    /**
     * Getter for distrito
     * @return distrito
     */
    public String getDistrito() {
        return distrito;
    }
    
    /**
     * Getter for name
     * @return name the name of empresa
     */
    public String getName() {
        return name;
    }
    
    /**
     * getter for the attribute valid
     * @return valid
     */
    public boolean getValid() {
        return valid;
    }
    
    /**
     * Method used to return the class isntance as a string
     */
    public String toString() {
        return "ID: " + id + "\nNome: " + name + "\nDistrito: " + distrito + "\n" + coordenadas;
    }

}

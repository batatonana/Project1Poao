import java.io.Serializable;
/**
 * Class with the coordenadas
 */
public class Coordenadas implements Serializable{
    private double latitude;
    private double longitude;
    private boolean valid = true;

    /**
     * Constructor for the class coordenadas
     * @param latitude the latitude of empresa
     * @param longitude the longitude of empresa
     */
    public Coordenadas(double latitude, double longitude){
        this.setLatitude(latitude);
        this.setLongitude(longitude);
    }

    /**
     * Setter for the latitude
     * @param latitude the latitude of empresa
     */
    public void setLatitude(double latitude) {
        if(latitude < -90 || latitude > 90){ 
            this.setValid(false);
        }else{
            this.latitude = latitude;
        }
    }
    /**
     * Setter for the longitude
     * @param longitude the longitude of empresa
     */
    public void setLongitude(double longitude) {
        if(longitude < -180 || longitude > 180){
            this.setValid(false);
        }else{
            this.longitude = longitude;
        }
    }
    /**
     * Setter for valid
     * @param valid boolean
     */
    public void setValid(boolean valid) {
        this.valid = valid;
    }

    /**
     * Getter for the latitude
     * @return latitude
     */
    public double getLatitude() {
        return latitude;
    }
    /**
     * Getter for the longitude
     * @return longitude
     */
    public double getLongitude() {
        return longitude;
    }
    /**
     * Getter for valid
     * @return valid
     */
    public boolean getValid() {
        return valid;
    }
    

    public String toString() {
        return "Coordenadas: (" + latitude + ", " + longitude + ")\n";
    }
}

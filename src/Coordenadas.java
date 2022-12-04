public class Coordenadas {
    private double latitude;
    private double longitude;
    private boolean valid = true;

    public Coordenadas(double latitude, double longitude){
        this.setLatitude(latitude);
        this.setLongitude(longitude);
    }


    public void setLatitude(double latitude) {
        if(latitude < -90 || latitude > 90){ 
            this.setValid(false);
        }else{
            this.latitude = latitude;
        }
    }
    public void setLongitude(double longitude) {
        if(longitude < -180 || longitude > 180){
            this.setValid(false);
        }else{
            this.longitude = longitude;
        }
    }
    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public double getLatitude() {
        return latitude;
    }
    public double getLongitude() {
        return longitude;
    }
    public boolean getValid() {
        return valid;
    }
    

    public String toString() {
        return "Coordenadas: (" + latitude + ", " + longitude + ")\n";
    }
}

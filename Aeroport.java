// premiere class creee

public class Aeroport {

    // declaration des variables

    private String IATA;
    private String Name;
    private String country;
    private double latitude;
    private double longitude;

    // creation du constructeur Aeroport
    public Aeroport(String IATA, String Name, String country, String latitude, String longitude){
        this.IATA = IATA;
        this.Name = Name;
        this.country = country;
        this.latitude = Double.parseDouble(latitude);
        this.longitude = Double.parseDouble(longitude);
    };

    public String getIATA(){
        return IATA;
    };

    public double getLatitude(){
        return latitude;
    };

    public double getLongitude(){
        return longitude;
    };

    // override = méthode toString héritée de la classe parente Aeroport

    public String toString(){
        return "Aeroport = " + "Name : " + Name + " latitude : " + latitude + " longitude : " + longitude + " IATA : "+IATA;
    };

}

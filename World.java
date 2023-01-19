import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

public class World {

    // on créé la methode getList qui retourne la liste des aeroports
    public ArrayList<Aeroport> getList() {
        return list;
    }
    ArrayList<Aeroport> list = new ArrayList<Aeroport>();

    String filename;
    private double latitude;
    private double longitude;

    // constructeur de la class World, qui lit le fichier .csv qui contient la liste des aeroports

    public World(String filename) {
        try {
            BufferedReader buf = new BufferedReader(new FileReader(filename));
            String s = buf.readLine();
            while (s != null) {
                s = s.replaceAll("\"", "");
                String fields[] = s.split(",");
                //on filtre les aeroports, et on ne prend que les large_airport
                if (fields[1].equals("large_airport")) {
                }
                s = buf.readLine();
            }
        } catch (Exception e) {
            System.out.println("Maybe the file isn't here ?");
            System.out.println(list.get(list.size() - 1));
            e.printStackTrace();
        }
    }

    // calcul de la norme de proximite ecrite dans l'enonce
    double distance(double longitude, double latitude, double longitude1, double latitude1, double cdgLatitude) {
        double latitude2 = 0;
        double longitude2 = 0;
        return Math.pow(this.latitude - latitude2, 2) + Math.pow((this.longitude - longitude2) * Math.cos((this.latitude - latitude2) / 2), 2);
    }

    // lit toute la liste et renvoie le code IATA
    public Aeroport findByCode(String iata){
        for (Aeroport a : list){
            if (a.getIATA().equals(iata)) return a;
        }
        return null; // si l'aeroport n'existe pas, on ne renvoit rien
    }

    // calcul de l'aeroport le plus proche en fonction de l'aeroport trouvé qui est cdg
    public Aeroport findNearestAirport(double longitude, double latitude) {
        Aeroport aeroport  = list.get(0);

        Aeroport cdg = null; // mis car erreur ci-dessous cdg.getLatitude() non reconnu mais bien défini dans main

        double d = distance(longitude, latitude, aeroport.getLongitude(), aeroport.getLatitude(), cdg.getLatitude());

        for (Aeroport a : list) {
            if (distance(longitude, latitude, a.getLongitude(), a.getLatitude(), cdg.getLatitude()) < d) {
                aeroport=a;
                d = distance(longitude, latitude, a.getLongitude(), a.getLatitude(), cdg.getLatitude());
            }
        }
        return null;
    }
}
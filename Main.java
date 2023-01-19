public class Main {

    public static void main(String[] args) {
        Aeroport aeroport = new Aeroport("CDG", "Paris", "France", "45", "10");
        System.out.println(aeroport);

        World w = new World("./data/airport_codes_no_comma.csv");
        System.out.println("Found"+w.getList().size()+" airports.");
        Aeroport paris = w.findNearestAirport(2.316,48.866);
        Aeroport cdg = w.findByCode("CDG");
        double distance = w.distance(2.316,48.866,cdg.getLongitude(),cdg.getLatitude(), cdg.getLatitude());
            System.out.println(cdg);
            System.out.println(distance);
        double distanceCDG = w.distance(2.316,48,866,cdg.getLongitude(),cdg.getLatitude());
            System.out.println(cdg);
            System.out.println(distanceCDG);
   }
}
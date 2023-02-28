package lab2.compulsory;

/**
 * @author Virna Stefan Alexandru
 */
public class Main {
    public static void main(String[] args) {
        Location l1 = new Location("Bacau", 10, 10, LocationType.City);
        Location l2 = new Location("Iasi", 10, 60, LocationType.City);
        Location l3 = new Location("Otopeni", 50, 21, LocationType.Airport);
        Road r1 = new Road(RoadType.Express, 100, 10);

        System.out.println(l1.toString());
        System.out.println(l2.toString());
        System.out.println(l3.toString());
        System.out.println(r1.toString());
    }
}

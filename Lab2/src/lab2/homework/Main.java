package lab2.homework;

import lab2.homework.Locations.Airport;
import lab2.homework.Locations.City;
import lab2.homework.Roads.ExpressRoad;

/**
 * @author Virna Stefan Alexandru
 */
public class Main {
    public static void main(String[] args) {
        BestRouteProblem problemInstance = new BestRouteProblem();

        Location l1 = new City("Bacau", 10, 10);
        Location l2 = new City("Iasi", 10, 60);
        Location l3 = new Airport("Otopeni", 50, 21);
        Location l4 = new City("Bucuresti", 50, 21);

        System.out.println("-----------------------------------------------");
        System.out.println("Added l1: " + (problemInstance.AddLocation(l1) ? "OK" : "DUPLICATE"));
        System.out.println("Added l2: " + (problemInstance.AddLocation(l2) ? "OK" : "DUPLICATE"));
        System.out.println("Added l3: " + (problemInstance.AddLocation(l3) ? "OK" : "DUPLICATE"));
        System.out.println("Added l4: " + (problemInstance.AddLocation(l4) ? "OK" : "DUPLICATE"));
        System.out.println("-----------------------------------------------");

        Road r1 = new ExpressRoad(55, l1, l4);
        Road r2 = new ExpressRoad(45, l4, l3);

        System.out.println("Added r1: " + (problemInstance.AddRoad(r1) ? "OK" : "DUPLICATE"));
        System.out.println("Added r2: " + (problemInstance.AddRoad(r2) ? "OK" : "DUPLICATE"));
        System.out.println("-----------------------------------------------");

        System.out.println("Checking if instance is valid: " + (problemInstance.CheckIfInstanceIsValid() ? "OK" : "INVALID"));
        System.out.println("-----------------------------------------------");

        System.out.println("Checking if locations are connected: " + (problemInstance.CheckIfLocationIsAccessible(l1, l3) ? "YES" : "NO"));
        System.out.println("-----------------------------------------------");
    }
}

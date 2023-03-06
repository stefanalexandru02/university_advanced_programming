package lab2.homework.Roads;

import lab2.homework.Location;
import lab2.homework.Road;

/**
 * @author Virna Stefan Alexandru
 */
public class CountryRoad extends Road {

    /**
     * Returns new instance of CountryRoad
     * @param length
     */
    public CountryRoad(int length) {
        super(length, 90);
    }

    /**
     * Returns new instance of CountryRoad
     * @param length
     * @param location1
     * @param location2
     */
    public CountryRoad(int length, Location location1, Location location2) {
        super(length, 90, location1, location2);
    }
}

package lab2.homework.Roads;

import lab2.homework.Location;
import lab2.homework.Road;

/**
 * @author Virna Stefan Alexandru
 */
public class ExpressRoad extends Road {

    /**
     * Returns new instance of ExpressRoad
     * @param length
     */
    public ExpressRoad(int length) {
        super(length, 100);
    }

    /**
     * Returns new instance of ExpressRoad
     * @param length
     * @param location1
     * @param location2
     */
    public ExpressRoad(int length, Location location1, Location location2) {
        super(length, 100, location1, location2);
    }
}

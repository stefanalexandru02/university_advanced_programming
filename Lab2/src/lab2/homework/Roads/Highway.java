package lab2.homework.Roads;

import lab2.homework.Location;
import lab2.homework.Road;

/**
 * @author Virna Stefan Alexandru
 */
public class Highway extends Road {

    /**
     * Returns new instance of Highway
     * @param length
     */
    public Highway(int length) {
        super(length, 130);
    }

    /**
     * Returns new instance of Highway
     * @param length
     * @param location1
     * @param location2
     */
    public Highway(int length, Location location1, Location location2) {
        super(length, 130, location1, location2);
    }
}

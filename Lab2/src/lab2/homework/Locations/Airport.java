package lab2.homework.Locations;

import lab2.homework.Location;

/**
 * @author Virna Stefan Alexandru
 */
public class Airport extends Location {
    private Integer FlightsCount;
    private Integer NumberOfTerminals;


    /**
     * Returns a new instance of Airport
     * @param name
     * @param x
     * @param y
     */
    public Airport(String name, Integer x, Integer y) {
        super(name, x, y);
    }

    /**
     * @return Number of flights
     */
    public Integer getFlightsCount() {
        return FlightsCount;
    }

    /**
     * Sets the number of flights
     * @param flightsCount
     */
    public void setFlightsCount(Integer flightsCount) {
        FlightsCount = flightsCount;
    }


    /**
     * @return Number of terminal
     */
    public Integer getNumberOfTerminals() {
        return NumberOfTerminals;
    }

    /**
     * Sets the number of terminals
     * @param numberOfTerminals
     */
    public void setNumberOfTerminals(Integer numberOfTerminals) {
        NumberOfTerminals = numberOfTerminals;
    }
}

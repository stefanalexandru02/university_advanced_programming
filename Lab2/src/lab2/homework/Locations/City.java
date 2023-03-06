package lab2.homework.Locations;

import lab2.homework.Location;

/**
 * @author Virna Stefan Alexandru
 */
public class City extends Location {
    private Integer Population;

    /**
     * Returns a new instance of City
     * @param name
     * @param x
     * @param y
     */
    public City(String name, Integer x, Integer y) {
        super(name, x, y);
    }

    /**
     * @return City's population
     */
    public Integer getPopulation() {
        return Population;
    }

    /**
     * Sets city's population
     * @param population
     */
    public void setPopulation(Integer population) {
        Population = population;
    }
}

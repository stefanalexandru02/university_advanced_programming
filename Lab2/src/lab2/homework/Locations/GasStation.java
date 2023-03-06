package lab2.homework.Locations;

import lab2.homework.Location;

/**
 * @author Virna Stefan Alexandru
 */
public class GasStation extends Location {
    private Integer PriceForGasoline;
    private Integer PriceForDiesel;

    /**
     * Returns new instance of GasStation
     * @param name
     * @param x
     * @param y
     */
    public GasStation(String name, Integer x, Integer y) {
        super(name, x, y);
    }

    /**
     * @return Price for gasoline
     */
    public Integer getPriceForGasoline() {
        return PriceForGasoline;
    }

    /**
     * @param priceForGasoline Sets price for gasoline
     */
    public void setPriceForGasoline(Integer priceForGasoline) {
        PriceForGasoline = priceForGasoline;
    }

    /**
     * @return Price for diesel
     */
    public Integer getPriceForDiesel() {
        return PriceForDiesel;
    }

    /**
     * Sets price for diesel
     * @param priceForDiesel
     */
    public void setPriceForDiesel(Integer priceForDiesel) {
        PriceForDiesel = priceForDiesel;
    }
}

package lab2.homework;

import lab2.compulsory.LocationType;

/**
 * @author Virna Stefan Alexandru
 */
public class Location {
    private String Name;
    private Integer X;
    private Integer Y;

    /**
     * Returns new instance of Location
     * @param name
     * @param x
     * @param y
     */
    public Location(String name, Integer x, Integer y) {
        Name = name;
        X = x;
        Y = y;
    }

    /**
     * @return Name
     */
    public String getName() {
        return Name;
    }

    /**
     * Sets name
     * @param name
     */
    public void setName(String name) {
        Name = name;
    }

    /**
     * @return X
     */
    public Integer getX() {
        return X;
    }

    /**
     * Sets X
     * @param x
     */
    public void setX(Integer x) {
        X = x;
    }

    /**
     * @return Y
     */
    public Integer getY() {
        return Y;
    }

    /**
     * Sets Y
     * @param y
     */
    public void setY(Integer y) {
        Y = y;
    }

    /**
     * @param obj
     * @return Whether or not the current object is equal to obj
     */
    @Override
    public boolean equals(Object obj) {
        if(this.getX() == ((Location)obj).getX()
                && this.getY() == ((Location)obj).getY()
                && this.getName() == ((Location)obj).getName())
            return true;

        return super.equals(obj);
    }
}


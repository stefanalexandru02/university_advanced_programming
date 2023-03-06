package lab2.homework;

import lab2.compulsory.RoadType;

/**
 * @author Virna Stefan Alexandru
 */
public class Road {
    private int Length;
    private int SpeedLimit;

    private Location Location1;
    private Location Location2;

    /**
     * @param length
     * @param speedLimit
     */
    public Road(int length, int speedLimit) {
        Length = length;
        SpeedLimit = speedLimit;
    }

    /**
     * @param length
     * @param speedLimit
     * @param location1
     * @param location2
     */
    public Road(int length, int speedLimit, Location location1, Location location2)
    {
        Length = length;
        SpeedLimit = speedLimit;
        Location1 = location1;
        Location2 = location2;
    }

    /**
     * @return Lenght for the road
     */
    public int getLength() {
        return Length;
    }

    /**
     * @param length
     */
    public void setLength(int length) {
        Length = length;
    }

    /**
     * @return Speed limit for the road
     */
    public int getSpeedLimit() {
        return SpeedLimit;
    }

    /**
     * @param speedLimit
     */
    public void setSpeedLimit(int speedLimit) {
        SpeedLimit = speedLimit;
    }

    /**
     * @param obj
     * @return Whether or not the current object is equal to obj
     */
    @Override
    public boolean equals(Object obj) {
        if(this.getLength() == ((Road)obj).getLength()
                && this.getSpeedLimit() == ((Road)obj).getSpeedLimit())
            return true;
        return super.equals(obj);
    }

    /**
     * @return the first location that a road connects to
     */
    public Location getLocation1() {
        return Location1;
    }

    /**
     * @return the second location that a road connects to
     */
    public Location getLocation2() {
        return Location2;
    }

    /**
     * @return Whether or not a road is valid
     */
    public boolean CheckIsRoadValid()
    {
        // Calculate euclidian distance
        int euclidianDistance = (int) Math.sqrt(
                Math.pow(Location2.getX() - Location1.getY(), 2) +
                Math.pow(Location2.getY() - Location1.getX(), 2)
        );
        if(Length < euclidianDistance) return false;
        return true;
    }

    /**
     * @param locationToCheck
     * @return Whether or not a road is connected to one of the location
     */
    public boolean HasLocation(Location locationToCheck)
    {
        if(Location1.equals(locationToCheck)) return true;
        if(Location2.equals(locationToCheck)) return true;
        return false;
    }
}


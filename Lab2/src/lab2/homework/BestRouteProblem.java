package lab2.homework;

import java.util.*;

/**
 * @author Virna Stefan Alexandru
 */
public class BestRouteProblem {
    private List<Location> Locations = new ArrayList<>();
    private List<Road> Roads = new ArrayList<>();

    private Dictionary<Integer, Boolean> VisitedLocation = new Hashtable<Integer, Boolean>();

    /**
     * @param newLocation
     * @return True is location was added. False if it was already present
     */
    public boolean AddLocation(Location newLocation)
    {
        // Check if location is already present in the list
        for(int i = 0; i < Locations.size(); i++)
        {
            if(Locations.get(i).equals(newLocation))
            {
                return false;
            }
        }
        Locations.add(newLocation);
        return true;
    }

    /**
     * @param newRoad
     * @return True is the road was added. False if it was already present
     */
    public boolean AddRoad(Road newRoad)
    {
        // Check if road is already present in the list
        for(int i = 0; i < Roads.size(); i++)
        {
            if(Roads.get(i).equals(newRoad))
            {
                return false;
            }
        }
        Roads.add(newRoad);
        AddLocation(newRoad.getLocation1());
        AddLocation(newRoad.getLocation2());
        return true;
    }

    /**
     * @return True if instance was valid. False otherwise
     */
    public boolean CheckIfInstanceIsValid()
    {
        for(int i = 0; i < Roads.size(); i++) {
            // Check if the road is valid for it's Locations
            if(Roads.get(i).CheckIsRoadValid() == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param startLocation
     * @param endLocation
     * @return True if endLocation is accessible from startLocation
     */
    public boolean CheckIfLocationIsAccessible(Location startLocation, Location endLocation)
    {
        for(int i = 0; i < Roads.size(); i++)
        {
            if(Roads.get(i).HasLocation(startLocation))
            {
                // Initialize visited locations with false
                for(int j = 0; j < Locations.size(); j++)
                {
                    VisitedLocation.put(j, false);
                }
                // Mark the starting location as visited
                VisitedLocation.put(i, true);
                // Check if endLocation is accessible through this road
                if(HasEndLocation(Roads.get(i), startLocation, endLocation))
                {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param currentRoad
     * @param comingFrom
     * @param endLocation
     * @return True is endLocation is accessible from comingFrom using currentRoad
     */
    private boolean HasEndLocation(Road currentRoad, Location comingFrom, Location endLocation)
    {
        // If the current road connects to the destination, return true
        if(currentRoad.HasLocation(endLocation))
        {
            return true;
        }
        if(currentRoad.getLocation1() != comingFrom)
        {
            // explore roads from location1
            Location l = currentRoad.getLocation1();
            // Ignore location if already visited
            if(VisitedLocation.get(Locations.indexOf(l))) return false;
            for(int i = 0; i < Roads.size(); i++)
            {
                if(Roads.get(i).HasLocation(l))
                {
                    if(HasEndLocation(Roads.get(i), l, endLocation))
                    {
                        return true;
                    }
                }
            }
        }
        if(currentRoad.getLocation2() != comingFrom)
        {
            // explore roads from location2
            Location l = currentRoad.getLocation2();
            // Ignore location if already visited
            if(VisitedLocation.get(Locations.indexOf(l))) return false;
            for(int i = 0; i < Roads.size(); i++)
            {
                if(Roads.get(i).HasLocation(l))
                {
                    if(HasEndLocation(Roads.get(i), l, endLocation))
                    {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}

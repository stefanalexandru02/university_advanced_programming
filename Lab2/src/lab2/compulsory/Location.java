package lab2.compulsory;

import java.util.Objects;

/**
 * @author Virna Stefan Alexandru
 */
public class Location {
    private String Name;
    private Integer X;
    private Integer Y;
    private LocationType Type;

    public Location(String name, Integer x, Integer y, LocationType type) {
        Name = name;
        X = x;
        Y = y;
        Type = type;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getX() {
        return X;
    }

    public void setX(Integer x) {
        X = x;
    }

    public Integer getY() {
        return Y;
    }

    public void setY(Integer y) {
        Y = y;
    }

    public LocationType getType() {
        return Type;
    }

    public void setType(LocationType type) {
        Type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location location)) return false;
        return Objects.equals(Name, location.Name) && Objects.equals(X, location.X) && Objects.equals(Y, location.Y) && Type == location.Type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name, X, Y, Type);
    }

    @Override
    public String toString() {
        return "Location{" +
                "Name='" + Name + '\'' +
                ", X=" + X +
                ", Y=" + Y +
                ", Type=" + Type +
                '}';
    }
}


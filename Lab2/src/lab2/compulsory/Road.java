package lab2.compulsory;

import java.util.Objects;

/**
 * @author Virna Stefan Alexandru
 */
public class Road {
    private RoadType Type;
    private int Length;
    private int SpeedLimit;

    public Road(RoadType type, int length, int speedLimit) {
        Type = type;
        Length = length;
        SpeedLimit = speedLimit;
    }

    public RoadType getType() {
        return Type;
    }

    public void setType(RoadType type) {
        Type = type;
    }

    public int getLength() {
        return Length;
    }

    public void setLength(int length) {
        Length = length;
    }

    public int getSpeedLimit() {
        return SpeedLimit;
    }

    public void setSpeedLimit(int speedLimit) {
        SpeedLimit = speedLimit;
    }

    @Override
    public String toString() {
        return "Road{" +
                "Type=" + Type +
                ", Length=" + Length +
                ", SpeedLimit=" + SpeedLimit +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Road road)) return false;
        return Length == road.Length && SpeedLimit == road.SpeedLimit && Type == road.Type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Type, Length, SpeedLimit);
    }
}


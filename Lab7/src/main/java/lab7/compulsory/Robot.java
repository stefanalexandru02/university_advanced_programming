package lab7.compulsory;

import lab7.homework.Direction;
import org.javatuples.Pair;

import java.util.*;

/**
 * @author Virna Stefan Alexandru
 */
public class Robot implements Runnable {
    private String name;
    private boolean isRunning;
    private int xPos;
    private int yPos;
    private List<Token> tokens = new ArrayList<>();

    @Override
    public String toString() {
        return "Robot{" +
                "name='" + name + '\'' +
                ", xPos=" + xPos +
                ", yPos=" + yPos +
                ", tokens=" + tokens +
                '}';
    }

    public String getNumberOfTokens() {
        return "Robot{" +
                ", tokens=" + tokens.size() +
                '}';
    }

    public Robot(String name, int xPos, int yPos, boolean printLogs, boolean useRandom) {
        this.name = name;
        this.xPos = xPos;
        this.yPos = yPos;

        this.printLogs = printLogs;
        this.useRandom = useRandom;

        isRunning = true;
    }

    private Boolean printLogs = false;
    private Boolean useRandom;

    public Boolean getPrintLogs() { return printLogs; }

    public String getName() { return name; }
    public int getxPos() { return xPos; }
    public int getyPos() { return yPos; }
    public void setxPos(int xPos) { this.xPos = xPos; }
    public void setyPos(int yPos) { this.yPos = yPos; }

    public boolean isOverlapping(Robot r)
    {
        return isOverlapping(new Pair<>(r.xPos, r.yPos));
    }

    public boolean isOverlapping(Pair<Integer, Integer> position)
    {
        return position.getValue0() == xPos &&
                position.getValue1() == yPos;
    }

    @Override
    public void run() {
        while(isRunning)
        {
            if(useRandom) {
                if(Map.exploreRandom(this) == false)
                {
                    System.out.println(name + " finished exploration");
                    isRunning = false;
                }
            }
            else {
                if(Map.exploreLogic(this) == false)
                {
                    System.out.println(name + " finished exploration");
                    isRunning = false;
                }
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
        }
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public void setTokens(List<Token> tokens) {
        this.tokens = tokens;
    }

    public void pause() {
        isRunning = false;
    }

    public void start() {
        isRunning = true;
        run();
    }

    public boolean getIsRunning() { return isRunning; }

    private Direction robotDirection = Direction.None;

    public Direction getRobotDirection() {
        return robotDirection;
    }

    public void setRobotDirection(Direction robotDirection) {
        this.robotDirection = robotDirection;
    }
}

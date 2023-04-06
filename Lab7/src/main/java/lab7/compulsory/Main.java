package lab7.compulsory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Virna Stefan Alexandru
 */
public class Main {
    private static final int n = 5;
    private static final int robotsCount = 5;
    private static SharedMemPool mem;
    private static List<Robot> robots = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        SharedMemPool.setupMemPool(n);
        Map.setupMap(n);
        for(int i = 0; i < robotsCount; i++)
        {
            Random rand = new Random();
            Robot newRobot = null;
            boolean isOk = false;
            while(!isOk)
            {
                isOk = true;
                newRobot = new Robot("ROBOT_" + i, rand.nextInt(n), rand.nextInt(n));
                for(int q = 0; q < robots.size() && isOk; q++)
                {
                    if(robots.get(q).isOverlapping(newRobot))
                    {
                        isOk = false;
                    }
                }
            }
            robots.add(newRobot);
        }
        System.out.println("Initialized");

        List<Thread> threads = new ArrayList<>();
        for (Robot robot : robots) {
            var thread = new Thread(() -> {
                System.out.println("Thread Running for: " + robot);
                robot.run();
            });
            threads.add(thread);
            thread.start();
        }

        // Wait for all robots to explore
        for (Thread thread : threads) {
            thread.join();
        }

        for(Robot robot : robots)
        {
            System.out.println(robot);
        }
    }
}
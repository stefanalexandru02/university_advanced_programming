package lab7.homework;

import lab7.compulsory.Map;
import lab7.compulsory.Robot;
import lab7.compulsory.SharedMemPool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
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

    public static void main(String[] args) throws InterruptedException, IOException {
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
                newRobot = new Robot(
                        "ROBOT_" + i, rand.nextInt(n), rand.nextInt(n),
                        false, true);
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

        List<RobotExecutionThread> threads = new ArrayList<>();
        for (Robot robot : robots) {
            threads.add(new RobotExecutionThread(robot));
        }

        Timekeeper timekeeperThread = new Timekeeper(
                Duration.ofSeconds(30), threads
         );
        var timekeeper = new Thread(() -> {
            timekeeperThread.run();
        });
        timekeeper.setDaemon(true);
        timekeeper.start();
        for(Thread thread : threads) {
            thread.start();
        }

        // Keyboard commands
        while(true) {
            // Exit loop if all completed their runs
            boolean allStopped = true;
            for(Robot r : robots)
            {
                if(r.getIsRunning()) {
                    allStopped = false;
                    break;
                }
            }
            if(allStopped) { break; }

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));
            String command = reader.readLine().toLowerCase();
            if(command == "exit") { break; }
            if(command.contains("stop ")) {
                String remaining = command.replace("stop ", "");
                if(remaining.equals("all")) {
                    for(RobotExecutionThread thread : threads) {
                        thread.pauseExecution();
                    }
                    System.out.println("ALL BOTS PAUSED");
                }
                else {
                    int index = Integer.parseInt(remaining);
                    threads.get(index).pauseExecution();
                }
            }
            if(command.contains("start ")) {
                String remaining = command.replace("start ", "");
                if(remaining.equals("all")) {
                    for(RobotExecutionThread thread : threads) {
                        thread.resumeExecution();
                    }
                    System.out.println("ALL BOTS PAUSED");
                }
                else {
                    int index = Integer.parseInt(remaining);
                    threads.get(index).resumeExecution();
                }
            }
        }

        // Robots final report
        for(Robot robot : robots) {
            System.out.println(robot.getNumberOfTokens());
        }
    }
}
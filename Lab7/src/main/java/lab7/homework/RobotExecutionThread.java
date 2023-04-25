package lab7.homework;

import lab7.compulsory.Robot;

/**
 * @author Virna Stefan Alexandru
 */
public class RobotExecutionThread extends Thread {
    public RobotExecutionThread(Robot robot)
    {
        this.robot = robot;
    }

    Robot robot;

    public void run() {
        robot.run();
    }

    public void pauseExecution() {
        robot.pause();
    }

    public void resumeExecution() {
        if(!robot.getIsRunning())
        {
            robot.start();
        }
    }
}

package lab7.homework;

import lab7.compulsory.Robot;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

/**
 * @author Virna Stefan Alexandru
 */
public class Timekeeper implements Runnable {
    public Timekeeper(Duration maximumDuration, List<RobotExecutionThread> threads) {
        this.maximumDuration = maximumDuration;
        this.threads = threads;
        startTime = Instant.now();
        daemonRunning = true;
    }

    private Duration maximumDuration;
    private Instant startTime;
    private boolean daemonRunning;
    private List<RobotExecutionThread> threads;

    @Override
    public void run() {
        while(daemonRunning)
        {
            System.out.println("Elapsed time: " + Duration.between(startTime, Instant.now()).getSeconds() + "sec");
            if(Duration.between(startTime, Instant.now()).getSeconds()
                    > maximumDuration.getSeconds())
            {
                System.out.println("Time elapsed. Killing my babies");
                for(Thread thread : threads)
                {
                    thread.stop();
                }
                daemonRunning = false;
            }

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

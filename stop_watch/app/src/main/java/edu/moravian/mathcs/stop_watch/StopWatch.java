package edu.moravian.mathcs.stop_watch;


/**
 * Created by meotm01 on 2/8/18.
 */

public class StopWatch implements Runnable {

    long     seconds;
    boolean  running;

    StopWatch() {
        this.seconds = 0;
        this.running = false;
    }

    long getSeconds() {
        return seconds;
    }

    boolean isRunning() {
        return running;
    }

    @Override
    public void run() {
        running = true;
        while (true) {
            seconds++;
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException ex) {
                break;
            }
        }
        running = false;
    }
}

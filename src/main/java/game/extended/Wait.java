package game.extended;

import java.util.concurrent.TimeUnit;

public class Wait {

    public void wait(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }

}

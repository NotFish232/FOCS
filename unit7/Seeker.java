import edu.fcps.karel2.*;
public class Seeker extends Athlete implements Runnable {
    public Seeker() {
    }

    public Seeker(int i) {
        super(1, i, Display.EAST, 0);
    }

    public void seek() {
        for (int i = 0; i < WorldBackend.getCurrent().getSize().y; i++) {
            new Thread(new Seeker(i + 1));
        }
    }

    public void run() {
        for (int i = 1; i < WorldBackend.getCurrent().getSize().x; i++) {
            if (nextToABeeper()) {
                pickBeeper();
            }
            move();
        }
        moveTo(1, 1);
        if (hasBeepers()) {
            putBeeper();
        }
    }
}

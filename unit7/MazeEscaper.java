
import edu.fcps.karel2.Display;

public class MazeEscaper extends Athlete {
    public MazeEscaper() {
        super(1, 1, Display.NORTH, 0);
    }

    public void escape() {
        while (!nextToABeeper()) {
            if (!rightIsClear()) {
                if (frontIsClear()) move();
                else turnLeft();
            } else {
                turnRight();
                move();
            }
        }
    }
}

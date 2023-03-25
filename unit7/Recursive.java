import edu.fcps.karel2.Display;

public class Recursive extends Athlete {
    public Recursive() {
        super(1, 1, Display.NORTH, 0);
        find();
    }

    public void find() {
        if (hasBeepers() && getX() == 1 && getY() == 1) {
            putBeeper();
        } else if (nextToABeeper() && getX() == 1 && getY() == 1) {
            turnLeft();
            turnLeft();
            move();
            return;
        } else if (nextToABeeper()) {
            if (!facingNorth()) {
                turnLeft();
            } else {
                pickBeeper();
            }
        } else if (hasBeepers()) {
            if (!leftIsClear()) {
                move();
            } else {
                turnLeft();
                move();
            }
        } else if (!rightIsClear()) {
            move();
        } else {
            turnRight();
            move();
        }
        find();
    }
}

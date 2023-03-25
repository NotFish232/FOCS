import edu.fcps.karel2.Robot;
import edu.fcps.karel2.Display;

public class Athlete extends Robot {
    public Athlete() {
        super(1, 1, Display.NORTH, Display.INFINITY);
    }

    public Athlete(int x, int y, int direction, int count) {
        super(x, y, direction, count);
    }

    public void turnRight() {
        turnLeft();
        turnLeft();
        turnLeft();
    }

    public void turnAround() {
        turnLeft();
        turnLeft();
    }

    public void keepMoving() {
        while (frontIsClear())
            move();
    }

    public void beeperMove() {
        while (!nextToABeeper())
            move();
    }

    public void putAll() {
        while (hasBeepers()) {
            putBeeper();
        }
    }

    public void faceNorth() {
        while (!facingNorth())
            turnLeft();
    }

    public void faceEast() {
        while (!facingEast())
            turnLeft();
    }

    public void faceSouth() {
        while (!facingSouth())
            turnLeft();
    }

    public void faceWest() {
        while (!facingWest())
            turnLeft();
    }
    public void moveTo(int x, int y) {
        if (x > getX()) {
            faceEast();
        }
        if (x < getX()) {
            faceWest();
        }
        while (x != getX())
            move();
        if (y > getY()) {
            faceNorth();
        }
        if (y < getY()) {
            faceSouth();
        }
        while (y != getY())
            move();
    }

    public int pickAll() {
        int i = 0;
        while (nextToABeeper()) {
            i++;
            pickBeeper();
        }
        return i;
    }
}

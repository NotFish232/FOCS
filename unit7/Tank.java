import edu.fcps.karel2.*;

public class Tank extends Athlete implements Runnable{
    public Tank() {
        super();
    }

    public Tank(int x, int y, int direction) {
        super(x, y, direction, 0);
    }

    public void fire() {
        switch (getDirection()) {
            case Display.NORTH:
                for (int i = 1; i <= 3; i++) {
                    WorldBackend.getCurrent().putBeepers(getX(), getY() + i, 1);
                }
                break;
            case Display.EAST:
                for (int i = 1; i <= 3; i++) {
                    WorldBackend.getCurrent().putBeepers(getX() + i, getY(), 1);
                }
                break;
            case Display.SOUTH:
                for (int i = 1; i <= 3; i++) {
                    WorldBackend.getCurrent().putBeepers(getX(), getY() - i, 1);
                }
                break;
            case Display.WEST:
                for (int i = 1; i <= 3; i++) {
                    WorldBackend.getCurrent().putBeepers(getX() - i, getY(), 1);
                }
                break;
        }

    }

    public void run() {
        while (pickAll()!=2) {
        if (nextToABeeper()) {
            fire();
        }
        if (leftIsClear())
            turnLeft();
        move();

    }
}
}


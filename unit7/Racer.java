import edu.fcps.karel2.Display;
public class Racer extends Athlete {
    public Racer(int x) {
        super(1, x, Display.EAST, 0);
    }

    public void shuttle(int spaces, int beepers) {
        move();
        turnLeft();
        move();
        turnRight();
        move();
        turnRight();
        move();
        turnLeft();
        for (int i = 0; i < spaces; i++) {
            move();
        }
        for (int i = 0; i < beepers; i++) {
            pickBeeper();
        }
        turnAround();
        for (int i = 0; i < spaces; i++) {
            move();
        }
        turnRight();
        move();
        turnLeft();
        move();
        turnLeft();
        move();
        turnRight();
        move();
        putAll();
        turnAround();
    }
}

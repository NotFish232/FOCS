import edu.fcps.karel2.Display;
public abstract class ObstacleBot extends Athlete implements Runnable {
    public ObstacleBot(int x) {
        super(x,1,Display.NORTH,0);
    }
    public abstract boolean keepGoing();
    public void run() {
        while (keepGoing()) {
            if (frontIsClear()) {
                move();
            } else {
                turnRight();
                int col=getX();
                while (!leftIsClear()) {
                    move();
                }
                turnLeft();
                move();
                turnLeft();
                while (col!=getX()) {
                    move();
                }
                turnRight();
            }
        }
    }
}

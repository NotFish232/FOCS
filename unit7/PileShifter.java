import edu.fcps.karel2.Display;
public class PileShifter extends Athlete{
    public PileShifter(int x, int y) {
        super(x,y,Display.WEST,0);
    }
    public void shift() {
        while (frontIsClear()) {
            move();
        if (nextToABeeper()) {
            pickAll();
            turnAround();
            move();
            putAll();
            turnAround();
            move();
        }

        }
    }
    
}

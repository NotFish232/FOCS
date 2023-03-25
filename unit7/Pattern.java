import edu.fcps.karel2.*;

public class Pattern extends Athlete {
    int x;
    int y;
    int cnt;

    public Pattern() {
        super(1, 3, Display.EAST, 0);
        while (nextToABeeper()) {
            move();
        }
        for (int i = 1; i < getX(); i++) {
           new Pattern(i).run();
        }
        explode();
    }

    public Pattern(int i) {
        super(i, 3, Display.SOUTH, 0);
    }

    public void run() {
        cnt = pickAll();
        move();
        y = pickAll();
        move();
        x = pickAll();
        moveTo(x,y);
        putAll();
        explode();
    }

}

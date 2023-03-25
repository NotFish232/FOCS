import java.util.ArrayList;
import edu.fcps.karel2.Display;
public class PictoBot extends Athlete {
    private ArrayList<int[]> coords = new ArrayList<int[]>();
    int axis;
    public PictoBot() {
        super(1, 1, Display.EAST, 0);
    }
    public void rotate() {
        beeperMove();
        turnLeft();
        for (int i=0;i<4;i++) {
            while (nextToABeeper()) {
                coords.add(new int[]{getX(),getY()});
                pickBeeper();
                move();
                axis=getX()+1;
            }
            if (i==3) break;
            moveTo(getX(),1);
            turnLeft();
            move();
            turnLeft();
        }
        for (int[] pos: coords) {
            moveTo(pos[1],axis-pos[0]);
            putBeeper();
        }
        explode();
    }
}

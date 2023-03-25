import edu.fcps.karel2.Display;
public class Target extends Athlete implements Runnable{
    public Target(int x,int y) {
        super(x,y,Display.NORTH,0);
    }
    public void run() {
        while (true) {
            if (nextToABeeper()) {
                for (int i=0;i<4;i++) turnLeft();
                explode();
            }
        }
    
    }
    
}

import edu.fcps.karel2.Display;
public class ch2 {
    public static void main(String[] args) {
        Display.openWorld("maps/maze.map");
        Athlete a=new Athlete();
        a.putBeeper();
        a.move();
        a.putBeeper();
        a.turnRight();
        a.move();
        a.putBeeper();
        a.turnRight();
        a.move();
        a.putBeeper();
        a.turnLeft();
        a.move();
        a.putBeeper();
        a.turnLeft();
        a.move();
        a.putBeeper();
        a.turnRight();
        a.move();
        a.putBeeper();
        a.move();
        a.putBeeper();
        a.turnRight();
        a.move();
        a.putBeeper();
        a.turnLeft();
        a.move();
        a.putBeeper();
        a.turnLeft();
        a.move();
        a.putBeeper();
        a.move();
        a.putBeeper();
        a.move();
        a.putBeeper();
        a.move();
        a.putBeeper();
        a.turnRight();
        a.move();
        a.putBeeper();
        a.move();
    }
    
}

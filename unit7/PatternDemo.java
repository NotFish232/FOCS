import edu.fcps.karel2.Display;
public class PatternDemo {
    public static void main(String[] args) {
        Display.openWorld("maps/d1.map");  //Test on maze1.map, maze2.map, and maze3.map
        Display.setSize(10,10);
        Display.setSpeed(10);
        new Pattern();

    }
    
}

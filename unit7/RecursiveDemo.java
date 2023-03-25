import edu.fcps.karel2.Display;
public class RecursiveDemo {
    public static void main(String[] args) {
        Display.openWorld("maps/a2.map");  //DON'T FORGET to test on obstacle2.map as well!
        Display.setSize(10,10);
        Display.setSpeed(10);
        new Recursive();
    }
    
}

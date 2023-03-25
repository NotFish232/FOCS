import edu.fcps.karel2.*;
public class EnlargerDemo {
    public static void main(String[] args) {
        Display.openWorld("maps/b1.map");  //DON'T FORGET to test on obstacle2.map as well!
        Display.setSize(20,20);
        Display.setSpeed(10);
        new Enlarger(4);
    }
    
}

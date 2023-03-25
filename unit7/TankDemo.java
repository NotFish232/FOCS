import edu.fcps.karel2.Display;
public class TankDemo {
    public static void main(String[] args) {
        Display.openWorld("maps/tank1.map");
        Display.setSize(10,10);
        Display.setSpeed(2);
        new Thread(new Tank(10,7,Display.NORTH)).start();
        new Thread(new Target(10,10)).start();
        new Thread(new Target(1,7)).start();
        new Thread(new Target(4,1)).start();
        new Thread(new Target(10,4)).start();
    }

}

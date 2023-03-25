import edu.fcps.karel2.Display;

public class Follower extends Athlete {
    public Follower() {
        super(2, 2, Display.EAST, 0);
    }

    public void follow() {
        while (true) {
            switch(check()) {
                case "Front":
                    move();
                    break;
                case "Right":
                    turnRight();
                    move();
                    break;
                case "Left":
                    turnLeft();
                    move();
                    break;
                case "Done":
                    return;
            }
        }
    }

    public String check() {
        String beep="Done";
        if (frontIsClear()) {
            move();
            if (nextToABeeper()) beep= "Front";  
            turnAround();
            move();
            turnAround();
            if (beep.equals("Front")) return "Front";
        }
        if (rightIsClear()) {
            turnRight();
            move();
            if (nextToABeeper()) beep="Right";
            turnAround();
            move();
            turnRight();
            if (beep.equals("Right")) return "Right";
        }
        if (leftIsClear()) {
            turnLeft();
            move();
            if (nextToABeeper()) beep="Left";
            turnAround();
            move();
            turnLeft();
        }
        return beep;
    }
}

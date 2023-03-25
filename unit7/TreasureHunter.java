import edu.fcps.karel2.Display;

public class TreasureHunter extends Athlete {
    public TreasureHunter() {
        super(1, 1, Display.EAST, 0);
    }

    public void hunt() {
        while (true) {
            beeperMove();
            switch (pickAll()) {
                case 5:
                    return;
                case 1:
                    turnLeft();
                    break;
                case 2:
                    turnAround();
                    break;
                case 3:
                    turnRight();
                    break;
            }
        }
    }
}

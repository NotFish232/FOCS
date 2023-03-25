import edu.fcps.karel2.Display;

public class Enlarger extends Athlete {
    int scale;
    String _pattern = "999999999";

    public Enlarger(int factor) {
        super(1, 1, Display.EAST, Display.INFINITY);
        scale = factor;
        getPattern();
        draw(_pattern);
    }

    public void draw(String pattern) {
        if (pattern.length() == 0)
            return;
        if (pattern.charAt(0) != '9') {
            moveTo(Character.getNumericValue(pattern.charAt(0)));
            drawSquare(scale,0);
            goToStart();
        }
        draw(pattern.substring(1));

    }
    private void drawSquare(int n,int row) {
        if (row==n) return;
        drawRow(n);
        turnLeft();
        turnLeft();
        move(n);
        turnRight();
        move();
        turnRight();
        drawSquare(n,row+1);
    }
    private void drawRow(int count) {
        if (count==0) return;
        putBeeper();
        move();
        drawRow(count-1);
    }
    private void move(int count) {
        if (count == 0)
            return;
        move();
        move(count-1);
    }

    private void moveTo(int pos) {
        switch (pos) {
            case 0:
                break;
            case 1:
                move(scale);
                break;
            case 2:
                move(2 * scale);
                break;
            case 3:
                turnLeft();
                move(scale);
                turnRight();
                break;

            case 4:
                turnLeft();
                move(scale);
                turnRight();
                move(scale);
                break;
            case 5:
                turnLeft();
                move(scale);
                turnRight();
                move(2 * scale);
                break;

            case 6:
                turnLeft();
                move(2 * scale);
                turnRight();
                break;
            case 7:
                turnLeft();
                move(2 * scale);
                turnRight();
                move(scale);
                break;
            case 8:
                turnLeft();
                move(2 * scale);
                turnRight();
                move(2 * scale);
                break;

        }

    }

    private void getPattern() {
        read(0);
        move();
        read(1);
        move();
        read(2);
        turnLeft();
        move();
        read(5);
        move();
        read(8);
        turnLeft();
        move();
        read(7);
        move();
        read(6);
        turnLeft();
        move();
        read(3);
        turnLeft();
        move();
        read(4);
        goToStart();
    }

    private void read(int i) {
        if (nextToABeeper()) {
            _pattern = _pattern.substring(0, i) + Integer.toString(i) + _pattern.substring(i + 1);
            pickBeeper();
        }
    }

    private void goToStart() {
        if (getX() == 1 && getY() == 1) {
            turnLeft();
            if (facingEast()) return;
        }
        if (getX() != 1) {
            if (!facingWest())
                turnLeft();
            else
                move();
        } else if (getY() != 1) {
            if (!facingSouth())
                turnLeft();
            else
                move();
        }
        goToStart();
    }
}

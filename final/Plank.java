public class Plank implements Block {
    public Plank() {
    }

    public int x() {
        return 4;
    }

    public int y() {
        return 0;
    }

    public String tool() {
        return "Axe";
    }

    public String toString() {
        return "Plank";
    }

    public boolean permeable() {
        return false;
    }
}

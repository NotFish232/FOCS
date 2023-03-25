public class Grass implements Block {
    public Grass() {
    }

    public int x() {
        return 3;
    }

    public int y() {
        return 0;
    }

    public String tool() {
        return "Shovel";
    }

    public String toString() {
        return "Grass";
    }

    public boolean permeable() {
        return false;
    }
}

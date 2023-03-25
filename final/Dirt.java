public class Dirt implements Block{
    public Dirt() {
    }
    public int x() {
        return 2;
    }
    public int y() {
        return 0;
    }
    public String tool() {
        return "Shovel";
    }
    public String toString() {
        return "Dirt";
    }
    public boolean permeable() {
        return false;
    }
}

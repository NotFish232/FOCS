public class Andesite implements Block{
    public Andesite() {
    }
    public int x() {
        return 3;
    }
    public int y() {
        return 1;
    }
    public String tool() {
        return "Pickaxe";
    }
    public String toString() {
        return "Andesite";
    }
    public boolean permeable() {
        return false;
    }
}

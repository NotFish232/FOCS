public class Redstone_Ore implements Block{
    public Redstone_Ore() {
    }
    public int x() {
        return 3;
    }
    public int y() {
        return 3;
    }
    public String tool() {
        return "Pickaxe";
    }
    public String toString() {
        return "Redstone_Ore";
    }
    public boolean permeable() {
        return false;
    }
}


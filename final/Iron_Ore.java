public class Iron_Ore implements Block{
    public Iron_Ore() {
    }
    public int x() {
        return 1;
    }
    public int y() {
        return 2;
    }
    public String tool() {
        return "Pickaxe";
    }
    public String toString() {
        return "Iron_Ore";
    }
    public boolean permeable() {
        return false;
    }
}

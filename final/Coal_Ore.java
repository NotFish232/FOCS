public class Coal_Ore implements Block{
    public Coal_Ore() {
    }
    public int x() {
        return 2;
    }
    public int y() {
        return 2;
    }
    public String tool() {
        return "Pickaxe";
    }
    public String toString() {
        return "Coal_Ore";
    }
    public boolean permeable() {
        return false;
    }
}

public class Diamond_Ore implements Block{
    public Diamond_Ore() {
    }
    public int x() {
        return 2;
    }
    public int y() {
        return 3;
    }
    public String tool() {
        return "Pickaxe";
    }
    public String toString() {
        return "Diamond_Ore";
    }
    public boolean permeable() {
        return false;
    }
}

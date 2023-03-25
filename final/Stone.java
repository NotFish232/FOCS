public class Stone implements Block{
    public Stone() {
    }
    public int x() {
        return 1;
    }
    public int y() {
        return 0;
    }
    public String tool() {
        return "Pickaxe";
    }
    public String toString() {
        return "Stone";
    }
    public boolean permeable() {
        return false;
    }
}


public class Air implements Block{
    public Air() {
    }
    public int x() {
        return -1;
    }
    public int y() {
        return -1;
    }
    public String tool() {
        return "";
    }
    public String toString() {
        return "Air";
    }
    public boolean permeable() {
        return true;
    }
}

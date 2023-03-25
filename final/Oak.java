public class Oak implements Block {
    public Oak() {
    }

    public int x() {
        return 4;
    }

    public int y() {
        return 1;
    }

    public String tool() {
        return "Axe";
    }

    public String toString() {
        return "Oak";
    }

    public boolean permeable() {
        return true;
    }
}

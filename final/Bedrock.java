public class Bedrock implements Block{
    public Bedrock() {
    }
    public int x() {
        return 1;
    }
    public int y() {
        return 1;
    }
    public String tool() {
        return "";
    }
    public String toString() {
        return "Bedrock";
    }
    public boolean permeable() {
        return false;
    }
}

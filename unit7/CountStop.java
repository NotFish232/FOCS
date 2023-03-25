public class CountStop extends ObstacleBot{
    int row;
    public CountStop(int x, int row) {
        super(x);
        this.row=row;
    }
    public boolean keepGoing() {
        return !(getY()==row);
    }
}

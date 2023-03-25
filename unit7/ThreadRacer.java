public class ThreadRacer extends Racer implements Runnable {
    private int[] distances;
    private int[] size;
    public ThreadRacer(int y, int[] distances, int[] size) {
        super(y);
        this.distances=distances;
        this.size=size;
    }  
    public void run() {
        for (int i=0;i<distances.length;i++) {
            shuttle(distances[i],size[i]);
        }
        move();
    }
    
}

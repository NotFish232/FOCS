import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
public class Triangle {

    public int[] x;
    public int[] y;
    public Color color;
    public Triangle(int[] x, int[] y, Color color) {
        this.x=x;
        this.y=y;
        this.color=color;
    }
    public int maxX() {
        int max=0;
        for (int tmp: x) {
           if (tmp>max) max=tmp;
        }
        return max;
     }
     public int maxY() {
        int max=0;
        for (int tmp: y) {
           if (tmp>max) max=tmp;
        }
        return max;
     }
     public int minX() {
        int min=10000;
        for (int tmp: x) {
           if (tmp<min) min=tmp;
        }
        return min;
     }
     public int minY() {
        int min=10000;
        for (int tmp: y) {
           if (tmp<min) min=tmp;
        }
        return min;
     }
}

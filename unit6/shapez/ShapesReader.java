import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
public class ShapesReader {
    private Shape[] shapes;
    public ShapesReader(String fileName) throws FileNotFoundException {
        Scanner reader=new Scanner(new File(fileName));
        shapes=new Shape[Integer.parseInt(reader.nextLine())];
        for (int i=0;i<shapes.length;i++) {
            String[] d = reader.nextLine().split(" ");
            switch(d[0]) {
                case "Circle":
                    shapes[i]=new Circle(Double.parseDouble(d[1]));
                    break;
                case "Triangle":
                    shapes[i]=new Triangle(Double.parseDouble(d[1]),Double.parseDouble(d[2]),Double.parseDouble(d[3]));
                    break;
                case "Square":
                    shapes[i]=new Square(Double.parseDouble(d[1]));
                    break;
                case "Rectangle":
                    shapes[i]=new Rectangle(Double.parseDouble(d[1]),Double.parseDouble(d[2]));
                    break;
                case "Parallelogram":
                    shapes[i]=new Parallelogram(Double.parseDouble(d[1]),Double.parseDouble(d[2]),Double.parseDouble(d[3]));
                    break;
            }
        }
        reader.close();
    }
    public String toString() {
        return Arrays.toString(shapes);
    }
    public void sortMe() {
        Arrays.sort(shapes);
    }
}

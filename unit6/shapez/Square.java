public class Square implements Shape, Comparable<Shape>{
    double side=0;
    public Square(double _side) {
        side=_side;
    }
    public double getArea() {
        return side*side;

    }
    public double getPerimeter() {
        return 4*side;

    }
    public int compareTo(Shape x) {
        if (getArea()>x.getArea()) return 1;
        if (getArea()==x.getArea()) return 0;
        return -1;
    }
    public String toString() {
        return "Square with side "+side+" has area "+getArea();
    }

    
}

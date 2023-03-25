public class Circle implements Shape, Comparable<Shape>{
    double radius=0;
    public Circle(double _radius) {
        radius=_radius;
    }
    public double getArea() {
        return Math.PI*Math.pow(radius,2);

    }
    public double getPerimeter() {
        return Math.PI*2*radius;

    }
    public int compareTo(Shape x) {
        if (getArea()>x.getArea()) return 1;
        if (getArea()==x.getArea()) return 0;
        return -1;
    }
    public String toString() {
        return "Circle with radius "+radius+" has area "+getArea();
    }
}

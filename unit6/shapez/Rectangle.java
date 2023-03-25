public class Rectangle implements Shape, Comparable<Shape>{
    double side1;
    double side2;
    public Rectangle(double _side1, double _side2) {
        side1=_side1;
        side2=_side2;
    }
    public double getArea() {
        return side1*side2;

    }
    public double getPerimeter() {
        return 2*(side1+side2);
    }
    public int compareTo(Shape x) {
        if (getArea()>x.getArea()) return 1;
        if (getArea()==x.getArea()) return 0;
        return -1;
    }
    public String toString() {
        return "Rectangle with sides "+side1+" and "+side2+" has area "+getArea();
    }
}

public class Parallelogram implements Shape, Comparable<Shape> {
    double base;
    double slant_height;
    double vertical_height;
    public Parallelogram(double _base, double _slant_height, double _vertical_height) {
        base=_base;
        slant_height=_slant_height;
        vertical_height=_vertical_height;
    }
    public double getArea() {
        return base*vertical_height;

    }
    public double getPerimeter() {
        return 2*(slant_height+base);

    }
    public int compareTo(Shape x) {
        if (getArea()>x.getArea()) return 1;
        if (getArea()==x.getArea()) return 0;
        return -1;
    }
    public String toString() {
        return "Parallelogram with base "+base+" slant height 3.0 "+slant_height+" and height "+vertical_height+" has area "+getArea();
    }
}

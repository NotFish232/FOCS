public class Triangle implements Shape, Comparable<Shape> {
    private double[] sides=new double[3];
    public Triangle(double s1, double s2, double s3) {
        sides[0]=s1;
        sides[1]=s2;
        sides[2]=s3;
    }
    public double getArea() {
        double s=getPerimeter()/2;
        return Math.sqrt(s*(s-sides[0])*(s-sides[1])*(s-sides[2]));
        
    }
    public double getPerimeter(){
        return sides[0]+sides[1]+sides[2];

    }
    public int compareTo(Shape x) {
        if (getArea()>x.getArea()) return 1;
        if (getArea()==x.getArea()) return 0;
        return -1;
    }
    public String toString() {
        return "Triangle with sides "+sides[0]+" "+sides[1]+" and "+sides[2]+" has area "+getArea();
    }
}
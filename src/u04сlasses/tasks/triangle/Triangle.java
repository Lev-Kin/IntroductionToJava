package u04сlasses.tasks.triangle;

public class Triangle {

    private Side A;
    private Side B;
    private Side C;

    private Triangle(Side a, Side b, Side c) {
        A = a;
        B = b;
        C = c;
    }

    public static Triangle createTriangle(Point a, Point b, Point c) {
        Side A = new Side(a, b);
        Side B = new Side(b, c);
        Side C = new Side(a, c);
        return new Triangle(A, B, C);
    }

    public void printSide() {
        System.out.println("a = " + A.calculateSide());
        System.out.println("b = " + B.calculateSide());
        System.out.println("c = " + C.calculateSide());
    }

    public double calculatePerimeter() {
        return A.calculateSide() + B.calculateSide() + C.calculateSide();
    }

    public double calculateArea() {
        double p = calculatePerimeter() / 2;
        // Формула Герона
        return Math.sqrt(p * (p - A.calculateSide()) * (p - B.calculateSide()) * (p - C.calculateSide()));
    }

    public Point pointMedianIntersection() {
        int x = (A.getOne().getX() + A.getTwo().getX() + B.getTwo().getX()) / 3;
        int y = (A.getOne().getY() + A.getTwo().getY() + B.getTwo().getY()) / 3;
        return new Point(x, y);
    }
}
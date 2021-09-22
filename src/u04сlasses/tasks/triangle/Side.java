package u04сlasses.tasks.triangle;

public class Side {

    private Point one;
    private Point two;

    public Side(Point one, Point two) {
        this.one = one;
        this.two = two;
    }

    public Point getOne() {
        return one;
    }

    public Point getTwo() {
        return two;
    }

    public double calculateSide() {
        return Math.sqrt(Math.pow((one.getX() - two.getX()), 2) +
                Math.pow((one.getY() - two.getY()), 2));
    }
}
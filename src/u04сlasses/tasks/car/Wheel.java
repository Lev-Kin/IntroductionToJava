package u04сlasses.tasks.car;

public class Wheel {
    private static int diameter;
    private boolean isGood;

    public Wheel() {
        this.diameter = diameter;
        this.isGood = true;
    }

    public Wheel(int diameter) {
        this.diameter = diameter;
        this.isGood = true;
    }

    public static int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public boolean isGood() {
        return isGood;
    }

    public void setGoodWhell() {
        isGood = true;
    }

    public void breakWheel() {
        this.isGood = false;
    }
}
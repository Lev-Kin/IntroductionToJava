package u05oop.tasks.gift.sweetness;

import u05oop.tasks.gift.sweetness.produce.*;

public class SweetnessFactory {
    public Sweetness createSweetness(SweetnessType type, String name, double price) {
        switch (type) {
            case PIE:
                return new Pie(name, price);
            case CAKE:
                return new Cake(name, price);
            case CANDY:
                return new Candy(name, price);
            case DONUT:
                return new Donut(name, price);
            case COOKIE:
                return new Cookie(name, price);
            case ECLAIR:
                return new Eclair(name, price);
            case WAFFLE:
                return new Waffle(name, price);
            case LOLLIPOP:
                return new Lollipop(name, price);
            case CHOCOLATE:
                return new Chocolate(name, price);
            default:
                System.out.println("Empty! Factory does not produce it.");
                return null;
        }
    }
}

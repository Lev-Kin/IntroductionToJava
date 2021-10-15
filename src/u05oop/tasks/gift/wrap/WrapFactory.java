package u05oop.tasks.gift.wrap;

import u05oop.tasks.gift.wrap.produce.Bag;
import u05oop.tasks.gift.wrap.produce.Basket;
import u05oop.tasks.gift.wrap.produce.Box;
import u05oop.tasks.gift.wrap.produce.Sphere;

public class WrapFactory {
    public Wrap createWrap(WrapType wrapType, String sign, String material) {
        switch (wrapType) {
            case BAG:
                return new Bag(sign, material);
            case BOX:
                return new Box(sign, material);
            case BASKET:
                return new Basket(sign, material);
            case SPHERE:
                return new Sphere(sign, material);
            default:
                System.out.println("Empty! Factory does not produce it.");
                return null;
        }
    }

}

package u05oop.tasks.gift.wrap.produce;

import u05oop.tasks.gift.wrap.Wrap;

public class Box implements Wrap {
    private String sing;
    private String material;

    public Box(String sing, String material) {
        this.sing = sing;
        this.material = material;
    }

    @Override
    public void setName(String sign) {
        this.sing = sign;
    }

    @Override
    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "Box{" +
                "sing='" + sing + '\'' +
                ", material='" + material + '\'' +
                '}';
    }
}

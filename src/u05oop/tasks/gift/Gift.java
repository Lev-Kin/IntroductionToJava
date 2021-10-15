package u05oop.tasks.gift;

import u05oop.tasks.gift.sweetness.Sweetness;
import u05oop.tasks.gift.wrap.Wrap;

import java.util.ArrayList;

public class Gift {
    private ArrayList<Sweetness> sweetnesses = new ArrayList<>();
    private Wrap wrap;

    public ArrayList<Sweetness> getSweetnesses() {
        return sweetnesses;
    }

    public void setSweetnesses(ArrayList<Sweetness> sweetnesses) {
        this.sweetnesses = sweetnesses;
    }

    public Wrap getWrap() {
        return wrap;
    }

    public void setWrap(Wrap wrap) {
        this.wrap = wrap;
    }

    public void addSweetness(Sweetness sweetness){
        sweetnesses.add(sweetness);
    }

    @Override
    public String toString() {
        return "Gift{" +
                "sweetnesses=" + sweetnesses +
                ", wrap=" + wrap +
                '}';
    }
}

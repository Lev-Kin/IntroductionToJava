package u05oop.tasks.cave;

import u05oop.tasks.cave.treasure.Treasure;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class Cave {
    private int treasureCount;

    private ArrayList<Treasure> treasures = new ArrayList<>();

    private ArrayList<Treasure> myTreasures = new ArrayList<>();

    public Cave(int treasureCount) {
        this.treasureCount = treasureCount;
    }

    public ArrayList<Treasure> getTreasures() {
        return treasures;
    }

    public void setTreasures(ArrayList<Treasure> treasures) {
        this.treasures = treasures;
    }

    public void createTreasures() {
        for (int i = 0; i < treasureCount; i++) {
            treasures.add(new Treasure());
        }
    }

    public void takeMostExpensiveTreasure() {
        if (!treasures.isEmpty()) {
            System.out.println(treasures.stream().max(Comparator.comparingDouble(Treasure::getPrice)).get());
            String removeAndAdd = String.format("%s", treasures.stream().max(Comparator.comparingDouble(Treasure::getPrice)).get());
            myTreasures.add(removeTreasure(removeAndAdd));
        } else
            System.out.println("Сокровищ в пещере не осталось все забраны");
    }

    public Treasure removeTreasure(String nameTreasure) {
        Treasure removedTreasure = null;
        Iterator<Treasure> treasureIterator = treasures.iterator();
        while (treasureIterator.hasNext()) {
            Treasure nextTreasure = treasureIterator.next();
            if (nextTreasure.toString().equals(nameTreasure)) {
                removedTreasure = nextTreasure;
                treasureIterator.remove();
            }
        }
        return removedTreasure;
    }

    public void printAllTreasures() {
        int i = 0;
        for (Treasure treasure : treasures) {
            i++;
            System.out.printf("%-4d", i);
            System.out.println(treasure);
        }
    }

    public void printTakenTreasures() {
        int i = 0;
        for (Treasure treasure : myTreasures) {
            i++;
            System.out.printf("%-4d", i);
            System.out.println(treasure);
        }
    }

    public void takeOnSum(double sum) {
        if (!treasures.isEmpty()) {

            double takeSum = 0;

            for (Treasure treasure : treasures) {
                if ((takeSum += treasure.getPrice()) >= sum) {
                    takeSum -= treasure.getPrice();
                } else {
                    System.out.println(treasure);
                    myTreasures.add(treasure);
                }
            }

            for (Treasure treasureTake : myTreasures) {
                removeTreasure(treasureTake.toString());
            }

            if (takeSum != 0.0) {
                System.out.printf("Выбрано на сумму = %.2f\n", takeSum);
                System.out.printf("Остаток составил = %.2f\n", sum - takeSum);
            }

        } else {
            System.out.println("Сокровищ в пещере не осталось все забраны");
            System.out.printf("Остаток составил = %.2f\n", sum);
        }

    }

}

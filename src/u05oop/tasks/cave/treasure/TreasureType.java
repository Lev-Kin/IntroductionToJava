package u05oop.tasks.cave.treasure;

import java.util.Random;

public enum TreasureType {
    RING,
    CROWN,
    ARMOR,
    BOOTS,
    SWORD;

    private static final TreasureType[] TREASURE_TYPE = values();
    private static final int SIZE = TreasureType.values().length;
    private static final Random RANDOM = new Random();

    public static TreasureType getRandomType() {
        return TREASURE_TYPE[RANDOM.nextInt(SIZE)];
    }
}
